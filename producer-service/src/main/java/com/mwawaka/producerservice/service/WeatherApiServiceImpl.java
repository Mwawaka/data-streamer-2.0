package com.mwawaka.producerservice.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mwawaka.producerservice.model.WeatherData;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class WeatherApiServiceImpl implements WeatherApiService {

    private final RestTemplate restTemplate;
    private final KafkaProducer kafkaProducer;

    @Value("${url}")
    private String url;


    public String getExternalData() throws JsonProcessingException {

        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);


        return response.getBody();
    }


    public WeatherData getWeatherData() throws JsonProcessingException {
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

        ObjectMapper mapper = new ObjectMapper();

        return mapper.readValue(response.getBody(), WeatherData.class);

    }

    public HttpStatus publish() throws JsonProcessingException {
        kafkaProducer.sendMessage("Weather-Cast-Data", getWeatherData());
        return HttpStatus.OK;
    }


}

