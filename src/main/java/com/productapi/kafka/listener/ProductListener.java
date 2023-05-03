package com.productapi.kafka.listener;

import com.productapi.avros.ProductRequest;
import com.productapi.avros.ProductResult;
import com.productapi.avros.Products;
import com.productapi.kafka.constants.Topics;
import com.productapi.repository.ProductRepository;
import com.productapi.repository.model.Product;
import com.productapi.utils.GenericPromiser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductListener {
    private static final Logger LOGGER = LogManager.getLogger(ProductListener.class);

    private final GenericPromiser<ProductResult> genericPromiser;
    private final ProductRepository repository;

    public ProductListener(GenericPromiser<ProductResult> genericPromiser, ProductRepository repository) {
        this.genericPromiser = genericPromiser;
        this.repository = repository;
    }

    @KafkaListener(topics = Topics.Product.GetProduct.COMMAND)
    public void listen(ProductRequest productRequest, @Payload GenericMessage<ProductRequest> message, @Header(KafkaHeaders.RECEIVED_TOPIC) String receivedTopic) {

        LOGGER.info("Message:{} Received topic: {}", message, receivedTopic);

        LOGGER.info("Product Listener...");
        ProductResult result = this.response(productRequest);
        genericPromiser.complete(productRequest.getRequestIdentification().getId(), result);
    }

    private ProductResult response(ProductRequest command) {
        List<Product> products = repository.findByProductLikeCaseInsensitive(command.getProductCommand().getName());
        List<Products> productsAvro = mapProduct(products);

        return ProductResult.newBuilder()
                .setName(productsAvro)
                .build();

    }

    private List<Products> mapProduct(List<Product> products) {
        ArrayList<Products> productsArrayList = new ArrayList<>();

        for (Product product : products) {
            Products productList = Products.newBuilder()
                    .setName(product.getName())
                    .setCode(product.getCode())
                    .build();
            productsArrayList.add(productList);
        }
        return productsArrayList;
    }
}
