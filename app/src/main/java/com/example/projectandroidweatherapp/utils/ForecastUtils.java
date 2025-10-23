package com.example.projectandroidweatherapp.utils;

import com.example.projectandroidweatherapp.data.model.DailyForecast;
import com.example.projectandroidweatherapp.data.model.ForecastResponse;
import com.example.projectandroidweatherapp.data.model.Weather;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * Utility class to process forecast data
 * Converts 3-hour forecast data into daily aggregated data
 */
public class ForecastUtils {

    /**
     * Process 3-hour forecast data into daily forecasts
     * Groups by date, calculates min/max temperature, and selects representative icon
     * 
     * @param forecastResponse Raw forecast response from API
     * @return List of daily forecasts (5 days)
     */
    public static List<DailyForecast> processDailyForecast(ForecastResponse forecastResponse) {
        if (forecastResponse == null || forecastResponse.getList() == null) {
            return new ArrayList<>();
        }

        // Group forecast items by date
        Map<String, DayData> dailyDataMap = new HashMap<>();
        SimpleDateFormat dateKeyFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        
        for (ForecastResponse.ForecastItem item : forecastResponse.getList()) {
            Date date = new Date(item.getTimestamp() * 1000L);
            String dateKey = dateKeyFormat.format(date);
            
            // Get or create DayData for this date
            DayData dayData = dailyDataMap.get(dateKey);
            if (dayData == null) {
                dayData = new DayData(item.getTimestamp());
                dailyDataMap.put(dateKey, dayData);
            }
            
            // Update min/max temperature
            double temp = item.getMain().getTemperature();
            dayData.updateMinMax(temp);
            
            // Collect icon for noon (12:00) or most frequent
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            int hour = cal.get(Calendar.HOUR_OF_DAY);
            
            Weather weather = item.getPrimaryWeather();
            if (weather != null) {
                dayData.addIcon(weather.getIcon(), weather.getDescription(), hour);
            }
        }

        // Convert to DailyForecast list
        List<DailyForecast> dailyForecasts = new ArrayList<>();
        SimpleDateFormat displayDateFormat = new SimpleDateFormat("EEE, MMM dd", Locale.getDefault());
        
        // Sort by timestamp and limit to 5 days
        List<Map.Entry<String, DayData>> sortedEntries = new ArrayList<>(dailyDataMap.entrySet());
        sortedEntries.sort((a, b) -> Long.compare(a.getValue().timestamp, b.getValue().timestamp));
        
        int count = 0;
        for (Map.Entry<String, DayData> entry : sortedEntries) {
            if (count >= 5) break;
            
            DayData dayData = entry.getValue();
            Date date = new Date(dayData.timestamp * 1000L);
            String displayDate = displayDateFormat.format(date);
            
            String[] iconAndDesc = dayData.getRepresentativeIcon();
            
            DailyForecast dailyForecast = new DailyForecast(
                    displayDate,
                    dayData.timestamp,
                    dayData.tempMin,
                    dayData.tempMax,
                    iconAndDesc[0],
                    iconAndDesc[1]
            );
            
            dailyForecasts.add(dailyForecast);
            count++;
        }
        
        return dailyForecasts;
    }

    /**
     * Helper class to aggregate data for one day
     */
    private static class DayData {
        long timestamp;
        double tempMin = Double.MAX_VALUE;
        double tempMax = Double.MIN_VALUE;
        Map<String, Integer> iconFrequency = new HashMap<>();
        Map<String, String> iconDescriptions = new HashMap<>();
        String noonIcon = null;
        String noonDescription = null;

        DayData(long timestamp) {
            this.timestamp = timestamp;
        }

        void updateMinMax(double temp) {
            if (temp < tempMin) tempMin = temp;
            if (temp > tempMax) tempMax = temp;
        }

        void addIcon(String icon, String description, int hour) {
            // Save noon icon (12:00 - 14:00)
            if (hour >= 12 && hour <= 14 && noonIcon == null) {
                noonIcon = icon;
                noonDescription = description;
            }
            
            // Track frequency
            iconFrequency.put(icon, iconFrequency.getOrDefault(icon, 0) + 1);
            iconDescriptions.put(icon, description);
        }

        String[] getRepresentativeIcon() {
            // Prefer noon icon
            if (noonIcon != null) {
                return new String[]{noonIcon, noonDescription};
            }
            
            // Otherwise, use most frequent icon
            String mostFrequentIcon = null;
            int maxFrequency = 0;
            for (Map.Entry<String, Integer> entry : iconFrequency.entrySet()) {
                if (entry.getValue() > maxFrequency) {
                    maxFrequency = entry.getValue();
                    mostFrequentIcon = entry.getKey();
                }
            }
            
            String description = iconDescriptions.get(mostFrequentIcon);
            return new String[]{
                    mostFrequentIcon != null ? mostFrequentIcon : "01d",
                    description != null ? description : "Clear"
            };
        }
    }
}
