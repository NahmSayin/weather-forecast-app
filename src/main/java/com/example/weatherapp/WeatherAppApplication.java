package com.example.weatherapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class WeatherAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeatherAppApplication.class, args);
    }
    @RestController
    @RequestMapping("/")
    public class TestController {

        @GetMapping
        public String testEndpoint() {
            Weather weather = new Weather();
            weather.setTemperature(30);
            return Integer.toString(weather.getTemperature());
        }
    }

}
