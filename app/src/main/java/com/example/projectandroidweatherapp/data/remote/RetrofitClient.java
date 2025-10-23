package com.example.projectandroidweatherapp.data.remote;

import com.example.projectandroidweatherapp.BuildConfig;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Singleton class to provide Retrofit instance
 */
public class RetrofitClient {
    private static final String BASE_URL = "https://api.openweathermap.org/";
    private static RetrofitClient instance;
    private final WeatherApiService apiService;

    private RetrofitClient() {
        // Create logging interceptor
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(
                BuildConfig.DEBUG 
                        ? HttpLoggingInterceptor.Level.BODY 
                        : HttpLoggingInterceptor.Level.NONE
        );

        // Create OkHttpClient
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .build();

        // Create Retrofit instance
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        apiService = retrofit.create(WeatherApiService.class);
    }

    /**
     * Get singleton instance
     */
    public static synchronized RetrofitClient getInstance() {
        if (instance == null) {
            instance = new RetrofitClient();
        }
        return instance;
    }

    /**
     * Get API Service
     */
    public WeatherApiService getApiService() {
        return apiService;
    }
}
