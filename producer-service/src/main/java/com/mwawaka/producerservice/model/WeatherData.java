package com.mwawaka.producerservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WeatherData {
    private Coord coord;
    private List<Weather> weather;
    @JsonProperty("base")
    private String base;
    private Main main;
    @JsonProperty("visibility")
    private int visibility;
    private Wind wind;
    private Rain rain;
    private Clouds clouds;
    @JsonProperty("dt")
    private long timestamp;
    private Sys sys;
    @JsonProperty("timezone")
    private long timezone;
    @JsonProperty("id")
    private int cityId;
    @JsonProperty("name")
    private String cityName;
    @JsonProperty("cod")
    private int statusCode;

}
