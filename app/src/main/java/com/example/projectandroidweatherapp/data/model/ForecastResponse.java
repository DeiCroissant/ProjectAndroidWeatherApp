package com.example.projectandroidweatherapp.data.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * Response model for 5 Day / 3 Hour Forecast API
 * Endpoint: /data/2.5/forecast
 */
public class ForecastResponse {
    @SerializedName("list")
    private List<ForecastItem> list;

    @SerializedName("city")
    private CityInfo city;

    // Nested ForecastItem class
    public static class ForecastItem {
        @SerializedName("dt")
        private long timestamp;

        @SerializedName("main")
        private Main main;

        @SerializedName("weather")
        private List<Weather> weather;

        @SerializedName("wind")
        private Wind wind;

        @SerializedName("dt_txt")
        private String dateText;

        public long getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(long timestamp) {
            this.timestamp = timestamp;
        }

        public Main getMain() {
            return main;
        }

        public void setMain(Main main) {
            this.main = main;
        }

        public List<Weather> getWeather() {
            return weather;
        }

        public void setWeather(List<Weather> weather) {
            this.weather = weather;
        }

        public Wind getWind() {
            return wind;
        }

        public void setWind(Wind wind) {
            this.wind = wind;
        }

        public String getDateText() {
            return dateText;
        }

        public void setDateText(String dateText) {
            this.dateText = dateText;
        }

        public Weather getPrimaryWeather() {
            return weather != null && !weather.isEmpty() ? weather.get(0) : null;
        }
    }

    // Nested CityInfo class
    public static class CityInfo {
        @SerializedName("name")
        private String name;

        @SerializedName("country")
        private String country;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }
    }

    // Getters and Setters
    public List<ForecastItem> getList() {
        return list;
    }

    public void setList(List<ForecastItem> list) {
        this.list = list;
    }

    public CityInfo getCity() {
        return city;
    }

    public void setCity(CityInfo city) {
        this.city = city;
    }
}
