package com.example.projectandroidweatherapp.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Utility class for date and time formatting
 */
public class DateTimeUtils {

    /**
     * Format timestamp to readable date time
     * Format: "Oct 23, 2025 14:30"
     */
    public static String formatDateTime(long timestamp) {
        SimpleDateFormat sdf = new SimpleDateFormat("MMM dd, yyyy HH:mm", Locale.getDefault());
        return sdf.format(new Date(timestamp * 1000L));
    }

    /**
     * Format timestamp to time only
     * Format: "14:30"
     */
    public static String formatTime(long timestamp) {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm", Locale.getDefault());
        return sdf.format(new Date(timestamp * 1000L));
    }

    /**
     * Format timestamp to date only
     * Format: "Oct 23, 2025"
     */
    public static String formatDate(long timestamp) {
        SimpleDateFormat sdf = new SimpleDateFormat("MMM dd, yyyy", Locale.getDefault());
        return sdf.format(new Date(timestamp * 1000L));
    }

    /**
     * Format timestamp to short date
     * Format: "Mon, Oct 23"
     */
    public static String formatShortDate(long timestamp) {
        SimpleDateFormat sdf = new SimpleDateFormat("EEE, MMM dd", Locale.getDefault());
        return sdf.format(new Date(timestamp * 1000L));
    }

    /**
     * Get current timestamp in seconds
     */
    public static long getCurrentTimestamp() {
        return System.currentTimeMillis() / 1000L;
    }

    /**
     * Check if timestamp is expired (older than TTL)
     * 
     * @param timestamp Timestamp to check
     * @param ttlMinutes Time to live in minutes
     * @return true if expired
     */
    public static boolean isExpired(long timestamp, int ttlMinutes) {
        long currentTime = getCurrentTimestamp();
        long ttlSeconds = ttlMinutes * 60L;
        return (currentTime - timestamp) > ttlSeconds;
    }
}
