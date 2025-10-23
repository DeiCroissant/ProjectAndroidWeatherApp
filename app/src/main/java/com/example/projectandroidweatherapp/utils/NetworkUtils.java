package com.example.projectandroidweatherapp.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Utility class for network operations
 */
public class NetworkUtils {

    /**
     * Check if device has internet connection
     * 
     * @param context Application context
     * @return true if connected
     */
    public static boolean isNetworkAvailable(Context context) {
        if (context == null) return false;
        
        ConnectivityManager connectivityManager = 
                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        
        if (connectivityManager != null) {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnected();
        }
        
        return false;
    }

    /**
     * Get error message based on HTTP status code
     * 
     * @param statusCode HTTP status code
     * @return User-friendly error message
     */
    public static String getErrorMessage(int statusCode) {
        switch (statusCode) {
            case 401:
                return "Invalid API key. Please check your configuration.";
            case 404:
                return "City not found. Please try another name.";
            case 429:
                return "Too many requests. Please try again later.";
            case 500:
            case 502:
            case 503:
                return "Server error. Please try again later.";
            default:
                return "Something went wrong. Please try again.";
        }
    }
}
