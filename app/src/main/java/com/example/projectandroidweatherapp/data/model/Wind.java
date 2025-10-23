package com.example.projectandroidweatherapp.data.model;

import com.google.gson.annotations.SerializedName;

/**
 * Model for Wind data
 */
public class Wind {
    @SerializedName("speed")
    private double speed;

    @SerializedName("deg")
    private int degree;

    @SerializedName("gust")
    private double gust;

    // Getters and Setters
    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public int getDegree() {
        return degree;
    }

    public void setDegree(int degree) {
        this.degree = degree;
    }

    public double getGust() {
        return gust;
    }

    public void setGust(double gust) {
        this.gust = gust;
    }
}
