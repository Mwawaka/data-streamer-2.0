package com.mwawaka.kafkabroker.configuration;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic rawDataTopic() {
        return TopicBuilder.name("Weather-Cast-Data").build();
    }

    @Bean
    public NewTopic airQualityIndexTopic() {
        return TopicBuilder.name("Air-Quality-Index").build();
    }

    @Bean
    public NewTopic weatherForeCastTopic() {
        return TopicBuilder.name("Weather-Forecast").build();

    }

    @Bean
    public NewTopic airQualityAlertsTopic() {
        return TopicBuilder.name("Air-Quality-Alerts").build();
    }

    @Bean
    public NewTopic weatherAlertsTopic() {
        return TopicBuilder.name("Weather-Alerts").build();

    }


}
