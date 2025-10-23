package com.example.projectandroidweatherapp.utils;

/**
 * Utility class for temperature and unit conversions
 */
public class UnitUtils {

    /**
     * Format temperature with degree symbol
     * 
     * @param temperature Temperature value
     * @return Formatted string (e.g., "25°C")
     */
    public static String formatTemperature(double temperature) {
        return String.format("%.0f°C", temperature);
    }

    /**
     * Format temperature range
     * 
     * @param min Minimum temperature
     * @param max Maximum temperature
     * @return Formatted string (e.g., "20° / 25°")
     */
    public static String formatTemperatureRange(double min, double max) {
        return String.format("%.0f° / %.0f°", min, max);
    }

    /**
     * Format wind speed
     * 
     * @param speed Wind speed in m/s
     * @return Formatted string (e.g., "5.2 m/s")
     */
    public static String formatWindSpeed(double speed) {
        return String.format("%.1f m/s", speed);
    }

    /**
     * Format humidity
     * 
     * @param humidity Humidity percentage
     * @return Formatted string (e.g., "65%")
     */
    public static String formatHumidity(int humidity) {
        return humidity + "%";
    }

    /**
     * Convert Celsius to Fahrenheit
     * 
     * @param celsius Temperature in Celsius
     * @return Temperature in Fahrenheit
     */
    public static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9/5) + 32;
    }

    /**
     * Convert Fahrenheit to Celsius
     * 
     * @param fahrenheit Temperature in Fahrenheit
     * @return Temperature in Celsius
     */
    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5/9;
    }

    /**
     * Capitalize first letter of each word
     * 
     * @param text Text to capitalize
     * @return Capitalized text
     */
    public static String capitalizeWords(String text) {
        if (text == null || text.isEmpty()) {
            return text;
        }
        
        String[] words = text.split(" ");
        StringBuilder result = new StringBuilder();
        
        for (String word : words) {
            if (!word.isEmpty()) {
                result.append(Character.toUpperCase(word.charAt(0)))
                      .append(word.substring(1).toLowerCase())
                      .append(" ");
            }
        }
        
        return result.toString().trim();
    }
}
