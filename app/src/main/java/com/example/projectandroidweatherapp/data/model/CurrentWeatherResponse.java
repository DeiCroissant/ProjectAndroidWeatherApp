package com.example.projectandroidweatherapp.data.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * Response model for Current Weather API
 * Endpoint: /data/2.5/weather
 */
public class CurrentWeatherResponse {
    @SerializedName("coord")
    private Coord coord;

    @SerializedName("weather")
    private List<Weather> weather;

    @SerializedName("main")
    private Main main;

    @SerializedName("wind")
    private Wind wind;

    @SerializedName("dt")
    private long timestamp;

    @SerializedName("name")
    private String cityName;

    // Nested Coord class
    public static class Coord {
        @SerializedName("lon")
        private double longitude;

        @SerializedName("lat")
        private double latitude;

        public double getLongitude() {
            return longitude;
        }

        public void setLongitude(double longitude) {
            this.longitude = longitude;
        }

        public double getLatitude() {
            return latitude;
        }

        public void setLatitude(double latitude) {
            this.latitude = latitude;
        }
    }

    // Getters and Setters
    public Coord getCoord() {
        return coord;
    }

    public void setCoord(Coord coord) {
        this.coord = coord;
    }

    public List<Weather> getWeather() {
        return weather;
    }

    public void setWeather(List<Weather> weather) {
        this.weather = weather;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    // Helper methods
    public Weather getPrimaryWeather() {
        return weather != null && !weather.isEmpty() ? weather.get(0) : null;
    }
}
