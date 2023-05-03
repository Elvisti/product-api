package com.productapi.utils;

import com.productapi.avros.RequestIdentification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;

@Component
public class GenericPromiser<T> {
    protected static final Logger LOGGER = LogManager.getLogger(GenericPromiser.class);
    protected static final Long TIMEOUT_IN_MILLIS = 300000L;

    private final ConcurrentMap<String, TypedPromise<T>> promises = new ConcurrentHashMap<>();

    private static class TypedPromise<T> {
        Class<T> responseClass;
        CompletableFuture<T> promise;
    }

    // Add the promise
    public CompletableFuture<T> waitFor(RequestIdentification requestIdentification, Class<T> responseClass) {
        return this.waitFor(requestIdentification, responseClass, null, TIMEOUT_IN_MILLIS);
    }

    // Add the promise
    public CompletableFuture<T> waitFor(RequestIdentification requestIdentification, Class<T> responseClass, long howLong) {
        return this.waitFor(requestIdentification, responseClass, null, howLong);
    }

    // Add the promise
    public CompletableFuture<T> waitFor(RequestIdentification requestIdentification, Class<T> responseClass, T specificTimeoutResponse) {
        return this.waitFor(requestIdentification, responseClass, specificTimeoutResponse, TIMEOUT_IN_MILLIS);
    }

    // Add the promise
    public CompletableFuture<T> waitFor(RequestIdentification requestIdentification, Class<T> responseClass, T specificTimeoutResponse, long howLong) {
        CompletableFuture<T> promise = new CompletableFuture<>();

        // If there is already an specific timeout response, return it instead of creating a new one
        if (specificTimeoutResponse == null ) {
            promise.orTimeout(howLong, TimeUnit.MILLISECONDS);
        } else {
            promise.completeOnTimeout(specificTimeoutResponse, howLong, TimeUnit.MILLISECONDS);
        }

        // Clean the promise from the hash and log the result of the promise
        promise.handle((t, throwable) -> {
            this.cleanPromise(requestIdentification.getId());
            return t;
        });

        TypedPromise<T> typedPromise = new TypedPromise<>();

        typedPromise.promise = promise;
        typedPromise.responseClass = responseClass;

        this.promises.put(requestIdentification.getId(), typedPromise);

        return promise;
    }

    // Resolve the promise
    public void complete(String requestUUID, T responseObject) {
        if (promises.containsKey(requestUUID)) {
            TypedPromise<T> typedPromise = this.promises.get(requestUUID);
            CompletableFuture<T> promise = typedPromise.promise;

            if (typedPromise.responseClass.isInstance(responseObject)) {
                // Just solve the completion if the class is the expected, otherwise this would explode an exception
                promise.complete(responseObject);
            } else {
                String response = responseObject.getClass().toString();
                LOGGER.error("Oh well, tried to resolve completion of type: [%s], with type: [%s], what is obviously an error. It should not happen. Solve this bug", typedPromise.responseClass, response);
                promise.complete(null);
            }
        }
    }

    private void cleanPromise(String requestUUID) {
        if (this.promises.containsKey(requestUUID)) {
            LOGGER.info("Cleaned promise {}", requestUUID);
            this.promises.remove(requestUUID);
        }
    }
}
