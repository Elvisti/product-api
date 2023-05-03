package com.productapi.kafka.config;

import com.productapi.avros.ProductResult;
import com.productapi.kafka.constants.Topics;
import io.confluent.kafka.serializers.KafkaAvroSerializer;
import jakarta.annotation.PostConstruct;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;

import java.util.HashMap;
import java.util.Map;

import static io.confluent.kafka.serializers.AbstractKafkaSchemaSerDeConfig.SCHEMA_REGISTRY_URL_CONFIG;

public class KafkaProducer {

    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapServers;

    @Value("${spring.kafka.properties.schema.registry.url}")
    private String schemaRegistryServer;

    protected Map<String, Object> kafkaProducerConfigs;

    @PostConstruct
    public void init() {
        this.kafkaProducerConfigs = new HashMap<>();
        kafkaProducerConfigs.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        kafkaProducerConfigs.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        kafkaProducerConfigs.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, KafkaAvroSerializer.class);
        kafkaProducerConfigs.put(SCHEMA_REGISTRY_URL_CONFIG, schemaRegistryServer);

    }

    @Bean
    public KafkaTemplate<String, String> kafkaTemplate() {
        return new KafkaTemplate<>(new DefaultKafkaProducerFactory<>(this.kafkaProducerConfigs));
    }

    @Bean
    public KafkaTemplate<String, ProductResult> setProduct() {
        KafkaTemplate<String, ProductResult> kafkaTemplate = new KafkaTemplate<>(new DefaultKafkaProducerFactory<>(this.kafkaProducerConfigs));
        kafkaTemplate.setDefaultTopic(Topics.Product.GetProduct.RESULT);
        return kafkaTemplate;
    }
}
