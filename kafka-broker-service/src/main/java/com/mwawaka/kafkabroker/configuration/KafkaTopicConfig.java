package com.mwawaka.kafkabroker.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaAdmin;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public KafkaAdmin.NewTopics rawDataTopic() {
        return new KafkaAdmin.NewTopics(TopicBuilder.name("Weather-Cast-Data").build(), TopicBuilder.name("Air-Quality").build());
    }


}
