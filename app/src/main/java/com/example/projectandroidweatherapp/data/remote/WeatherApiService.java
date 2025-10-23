package com.example.projectandroidweatherapp.data.remote;

import com.example.projectandroidweatherapp.data.model.City;
import com.example.projectandroidweatherapp.data.model.CurrentWeatherResponse;
import com.example.projectandroidweatherapp.data.model.ForecastResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Retrofit API Service for OpenWeatherMap
 */
public interface WeatherApiService {
    
    /**
     * Geocoding API - Search city by name
     * GET /geo/1.0/direct
     * 
     * @param cityName City name to search
     * @param limit Number of results (default: 1)
     * @param apiKey API key
     * @return List of cities
     */
    @GET("geo/1.0/direct")
    Call<List<City>> searchCity(
            @Query("q") String cityName,
            @Query("limit") int limit,
            @Query("appid") String apiKey
    );

    /**
     * Current Weather API
     * GET /data/2.5/weather
     * 
     * @param latitude Latitude
     * @param longitude Longitude
     * @param units Units of measurement (metric, imperial, standard)
     * @param apiKey API key
     * @return Current weather data
     */
    @GET("data/2.5/weather")
    Call<CurrentWeatherResponse> getCurrentWeather(
            @Query("lat") double latitude,
            @Query("lon") double longitude,
            @Query("units") String units,
            @Query("appid") String apiKey
    );

    /**
     * 5 Day / 3 Hour Forecast API
     * GET /data/2.5/forecast
     * 
     * @param latitude Latitude
     * @param longitude Longitude
     * @param units Units of measurement (metric, imperial, standard)
     * @param apiKey API key
     * @return 5-day forecast data
     */
    @GET("data/2.5/forecast")
    Call<ForecastResponse> getForecast(
            @Query("lat") double latitude,
            @Query("lon") double longitude,
            @Query("units") String units,
            @Query("appid") String apiKey
    );
}
