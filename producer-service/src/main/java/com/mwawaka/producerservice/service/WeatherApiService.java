package com.mwawaka.producerservice.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mwawaka.producerservice.model.WeatherData;
import org.springframework.http.HttpStatus;

import java.net.http.HttpResponse;

public interface WeatherApiService {

    String getExternalData() throws JsonProcessingException;
  HttpStatus publish() throws JsonProcessingException;
}
