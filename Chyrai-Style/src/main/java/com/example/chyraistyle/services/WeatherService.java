package com.example.chyraistyle.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Map;

@Service
public class WeatherService {

    @Value("${openweather.api.key}")
    private String apiKey; // Ключ API для доступа к OpenWeather

    private static final String WEATHER_API_URL = "https://api.openweathermap.org/data/2.5/weather"; // Базовый URL API погоды

    /**
     * Получает данные о погоде для указанного города.
     *
     * @param city название города, для которого требуется информация о погоде
     * @return карта с данными о погоде
     */
    public Map<String, Object> fetchWeatherData(String city) {
        // Создаем URL с параметрами для запроса к API
        String url = UriComponentsBuilder.fromHttpUrl(WEATHER_API_URL)
                .queryParam("q", city) // Параметр запроса: город
                .queryParam("appid", apiKey) // Параметр запроса: ключ API
                .queryParam("units", "metric") // Параметр запроса: единицы измерения
                .toUriString(); // Формируем окончательный URL

        RestTemplate restTemplate = new RestTemplate(); // Создаем RestTemplate для выполнения HTTP-запросов
        return restTemplate.getForObject(url, Map.class); // Отправляем GET-запрос и возвращаем данные как карту
    }

    public Map<String, Object> getWeatherData(String city) {
    }
}
