package com.giordano.hugo.calculator;

import android.app.Application;

import com.giordano.hugo.calculator.di.AppComponent;
import com.giordano.hugo.calculator.di.DaggerAppComponent;

import javax.inject.Inject;

public class CalculatorApplication extends Application {
    private AppComponent appComponent;
    @Inject
    String testo;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder().application(this).build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
