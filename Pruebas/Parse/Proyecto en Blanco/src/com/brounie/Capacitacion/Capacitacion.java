package com.brounie.Capacitacion;

import android.app.Application;
import android.os.Bundle;
import com.parse.Parse;
import com.parse.ParseAnalytics;

/**
 * Created by Toshiba on 5/01/14.
 */
public class Capacitacion extends Application {
    public String message;

    @Override
    public void onCreate() {
        super.onCreate();


        Parse.initialize(this, "cNY7pfd5p2dvVIujk6dJZ8FYGpv9FIgQmH2aI3xA", "sWTD3ajKzuYhL0DP5lMNarjcyk2egOFljiudF50L");

    }
}

