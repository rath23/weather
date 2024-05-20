package com.myComp.weather.Service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.myComp.weather.Data.WeatherData;

@Service
public class WeatherServiceImpl implements WeatherService {
    private final RestTemplate restTemplate;

    private String api = "Your API key";

    public WeatherServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public WeatherData getWeather(String city) {
        ResponseEntity<WeatherData> response = restTemplate.getForEntity(
                String.format("https://api.openweathermap.org/data/2.5/weather?q=%s&appid=%s", city, api),
                WeatherData.class);

        if (response.getStatusCode().is2xxSuccessful()) {
            return response.getBody();
        } else {
            throw new RuntimeException("Failed to fetch weather data: " + response.getStatusCode());
        }
    }
}
