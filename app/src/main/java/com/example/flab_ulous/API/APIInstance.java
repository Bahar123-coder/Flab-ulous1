package com.example.flab_ulous.API;

import android.util.Log;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

import org.jetbrains.annotations.NotNull;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIInstance {
    private static Retrofit retrofit;
    private static final String BASE_URL = "localhost:8085";

    public static Retrofit getRetrofitInstance() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(@NotNull String s) {
                String logName = "OKHTTP";
                if (s.startsWith("{")) {
                    Log.d(logName, s);
                }
                try {
                    String prettyPrintJson = new GsonBuilder().setPrettyPrinting().create().toJson(new JsonParser().parse(s));
                    Log.d(logName, prettyPrintJson);
                } catch (JsonSyntaxException m) {
                    Log.d(logName, s);
                }
            }
        });
        interceptor.level(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient
                .Builder()
                .readTimeout(20, TimeUnit.SECONDS)
                .writeTimeout(20, TimeUnit.SECONDS)
                .addInterceptor(interceptor)
                .build();
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
        return retrofit;
    }
}
