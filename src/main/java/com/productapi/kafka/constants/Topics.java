package com.productapi.kafka.constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Topics {
    private static final String PREFIX = "com.supermarket";

    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class Product {
        private static final String COMMAND = ".command";
        private static final String RESULT = ".result";


        @NoArgsConstructor(access = AccessLevel.PRIVATE)
        public static class GetProduct {
            public static final String COMMAND = PREFIX + Product.COMMAND;
            public static final String RESULT = PREFIX + Product.RESULT;
        }
    }
}
