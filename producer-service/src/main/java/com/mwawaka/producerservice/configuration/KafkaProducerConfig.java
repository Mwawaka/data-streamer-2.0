package com.mwawaka.producerservice.configuration;

import com.mwawaka.producerservice.model.WeatherData;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaProducerConfig {

    @Value("${spring.kafka.producer.bootstrap-servers}")
    private String bootStrapServers;

    @Value("${spring.kafka.producer.properties.connections.max.idle.ms}")
    private int maxIdleTime;

    public Map<String, Object> producerConfig() {

        Map<String, Object> props = new HashMap<>();

        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootStrapServers);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        props.put(ProducerConfig.CONNECTIONS_MAX_IDLE_MS_CONFIG, maxIdleTime);
        return props;
    }

    //    ProducerFactory-enables creation of kafka producer instances
    @Bean
    public ProducerFactory<String, WeatherData> producerFactory() {
        return new DefaultKafkaProducerFactory<>(producerConfig());
    }

//Sending messages

    @Bean
    public KafkaTemplate<String,WeatherData> kafkaTemplate(ProducerFactory<String,WeatherData> producerFactory){
        return new KafkaTemplate<>(producerFactory);
    }

}
