package com.myComp.weather.Data;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WeatherData {
    private String cityName;
    private double temperature;
    private String weatherDescription;

    @JsonProperty("main")
    private void unpackMain(Map<String, Object> main) {
        double temp = (double) main.get("temp");
        this.temperature = Math.round((temp - 273.15) * Math.pow(10, 2)) / Math.pow(10, 2);
        System.out.println(temperature);
    }

    @JsonProperty("weather")
    private void unpackWeather(List<Map<String, Object>> weather) {
        Map<String, Object> weatherInfo = weather.get(0);
        this.weatherDescription = (String) weatherInfo.get("description");
    }

    @JsonProperty("name")
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCityName() {
        return cityName;
    }

    public double getTemperature() {
        return temperature;
    }

    public String getWeatherDescription() {
        return weatherDescription;
    }

}
