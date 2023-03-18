package com.mwawaka.producerservice.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mwawaka.producerservice.service.WeatherApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class WeatherApiController {

    private final WeatherApiService weatherApiService;

    @GetMapping("/data")
    public ResponseEntity<String> getExternalData() throws JsonProcessingException {
        String data= weatherApiService.getExternalData();
        return new ResponseEntity<>(data,HttpStatus.OK);
    }
    @GetMapping("/pub")
    @Scheduled(fixedDelay = 5000)
    public HttpStatus publish() throws JsonProcessingException {
        return weatherApiService.publish();
    }

}
