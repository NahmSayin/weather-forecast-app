package com.example.weatherapp;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@SpringBootTest
class WeatherTests {

    @Test
    void sampleTest() {
        boolean checker = true;
        assertTrue(checker);
    }

    @Test
    void weatherSetsTemperatureTest() {
        Weather weatherTest = new Weather();
        weatherTest.setTemperature(5);
        assertEquals(weatherTest.getTemperature(), 5);
    }

    @Test
    void weatherSetsAnotherTemperatureTest() {
        Weather weatherTest = new Weather();
        weatherTest.setTemperature(10);
        assertEquals(weatherTest.getTemperature(), 10);
    }

    @Test
        //Server not running
    void invalidPathReturns404ErrorTest() throws IOException, InterruptedException {
        HttpClient httpClient = HttpClient.newBuilder()
                .build();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080/anything"))
                .GET()
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        assertEquals(404, response.statusCode());
    }
    //Server running

    //Fetching data from API
}
