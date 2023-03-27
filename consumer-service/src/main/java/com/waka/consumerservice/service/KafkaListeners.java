package com.waka.consumerservice.service;


import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class KafkaListeners {

    @KafkaListener(topics = "Weather-Forecast", groupId = "test")
    void listener(String data) {
        System.out.println("Listener Received : " + data);
    }
}
