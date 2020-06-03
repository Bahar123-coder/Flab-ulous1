package com.example.flab_ulous.preferences;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

public class AppPreferences {
    private static final String APP_NAME = "DietPlan";
    private static final String PATIENT_ID = "patientId";
    private static final String IS_USER_LOGGED_IN = APP_NAME + ".isUserLoggedIn";
    private final SharedPreferences preferences;

    public AppPreferences(Application application) {
        this.preferences = application.getSharedPreferences("preferences_dietPlan", Context.MODE_PRIVATE);
    }

    public boolean isUserLoggedIn() {
        return preferences.getBoolean(IS_USER_LOGGED_IN, false);
    }

    public void setIsUserLoggedIn(boolean isUserLoggedIn) {
        preferences.edit().putBoolean(IS_USER_LOGGED_IN, isUserLoggedIn).apply();
    }

    public int getPatientId() {
        return preferences.getInt(PATIENT_ID, 0);
    }

    public void setPatientId(int patientId) {
        preferences.edit().putInt(PATIENT_ID, patientId).apply();
    }
}
