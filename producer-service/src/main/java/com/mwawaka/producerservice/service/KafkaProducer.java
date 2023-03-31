package com.mwawaka.producerservice.service;

import com.mwawaka.producerservice.model.Rain;
import com.mwawaka.producerservice.model.WeatherData;
import com.mwawaka.producerservice.utils.DateTimeUtils;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class KafkaProducer implements Callback {

    private final KafkaTemplate<String, WeatherData> kafkaTemplate;

    public void sendMessage(String topic, WeatherData weatherData) {

        String formattedTimestamp = DateTimeUtils.formatTimestamp(weatherData.getTimestamp());
        weatherData.setFormattedTimestamp(formattedTimestamp);

        Rain rain = weatherData.getRain();
        if (rain == null) {
            rain = new Rain();
            rain.setVolume(0);
            weatherData.setRain(rain);
        }

        kafkaTemplate.send(topic, weatherData);
    }

    @Override
    public void onCompletion(RecordMetadata result, Exception e) {
        if (e == null) {
            System.out.println("Message sent to Kafka, topic: " + result.topic() +
                    ", partition: " + result.partition() +
                    ", offset: " + result.offset());
        }
        System.out.println("Error Message: " + e.getMessage());

    }

}
