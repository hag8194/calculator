package com.giordano.hugo.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject
    String testo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((CalculatorApplication)getApplication()).getAppComponent().mainComponent().build().inject(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(getClass().getSimpleName(), testo);
    }
}
