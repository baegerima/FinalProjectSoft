package com.example.chyraistyle.controllers;

import com.example.chyraistyle.services.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/weather")
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping("/{city}")
    public Map<String, Object> getWeather(@PathVariable String city) {
        return weatherService.getWeatherData(city);
    }
}
