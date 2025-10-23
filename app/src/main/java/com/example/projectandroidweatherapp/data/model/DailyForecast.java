package com.example.projectandroidweatherapp.data.model;

/**
 * Processed daily forecast model
 * Used to display aggregated data for each day
 */
public class DailyForecast {
    private String date; // Format: "Mon, Oct 23"
    private long timestamp;
    private double tempMin;
    private double tempMax;
    private String iconCode;
    private String iconUrl;
    private String description;

    public DailyForecast(String date, long timestamp, double tempMin, double tempMax, 
                         String iconCode, String description) {
        this.date = date;
        this.timestamp = timestamp;
        this.tempMin = tempMin;
        this.tempMax = tempMax;
        this.iconCode = iconCode;
        this.iconUrl = "https://openweathermap.org/img/wn/" + iconCode + "@2x.png";
        this.description = description;
    }

    // Getters and Setters
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public double getTempMin() {
        return tempMin;
    }

    public void setTempMin(double tempMin) {
        this.tempMin = tempMin;
    }

    public double getTempMax() {
        return tempMax;
    }

    public void setTempMax(double tempMax) {
        this.tempMax = tempMax;
    }

    public String getIconCode() {
        return iconCode;
    }

    public void setIconCode(String iconCode) {
        this.iconCode = iconCode;
        this.iconUrl = "https://openweathermap.org/img/wn/" + iconCode + "@2x.png";
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTempRangeDisplay() {
        return String.format("%.0f° / %.0f°", tempMin, tempMax);
    }
}
