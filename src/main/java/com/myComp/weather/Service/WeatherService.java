package com.myComp.weather.Service;

import com.myComp.weather.Data.WeatherData;

public interface WeatherService {
    public WeatherData getWeather(String city);
}
