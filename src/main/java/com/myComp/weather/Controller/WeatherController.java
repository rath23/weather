package com.myComp.weather.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.myComp.weather.Data.WeatherData;
import com.myComp.weather.Service.WeatherServiceImpl;

@Controller
public class WeatherController {

    private final WeatherServiceImpl weatherService;

    public WeatherController(WeatherServiceImpl weatherService) {
        this.weatherService = weatherService;
    }

    
    @GetMapping("/weather")
    public String getWeather(String city,Model model) {
        WeatherData data = weatherService.getWeather(city);
        model.addAttribute("data", data);
        return "weatherInfo";
    }
}