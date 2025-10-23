package com.example.projectandroidweatherapp.utils;

/**
 * Constants used throughout the application
 */
public class Constants {
    
    // API Constants
    public static final String UNITS_METRIC = "metric";
    public static final String UNITS_IMPERIAL = "imperial";
    
    // Cache TTL (Time To Live)
    public static final int CACHE_TTL_MINUTES = 20; // 20 minutes
    
    // Default values
    public static final int DEFAULT_CITY_SEARCH_LIMIT = 5;
    public static final int FORECAST_DAYS = 5;
    
    // SharedPreferences keys
    public static final String PREF_NAME = "WeatherAppPrefs";
    public static final String PREF_LAST_CITY = "last_city";
    public static final String PREF_LAST_LAT = "last_lat";
    public static final String PREF_LAST_LON = "last_lon";
    public static final String PREF_UNITS = "units";
    
    // Error messages
    public static final String ERROR_NO_INTERNET = "No internet connection";
    public static final String ERROR_CITY_NOT_FOUND = "City not found";
    public static final String ERROR_API_LIMIT = "API limit reached. Please try again later.";
    public static final String ERROR_GENERIC = "Something went wrong. Please try again.";
    
    // Permissions
    public static final int LOCATION_PERMISSION_REQUEST_CODE = 1001;
}
