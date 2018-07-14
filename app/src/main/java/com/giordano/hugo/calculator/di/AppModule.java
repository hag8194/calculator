package com.giordano.hugo.calculator.di;

import android.content.Context;
import com.giordano.hugo.calculator.CalculatorApplication;
import com.giordano.hugo.calculator.MainComponent;

import dagger.Module;
import dagger.Provides;

@Module(subcomponents = MainComponent.class)
public class AppModule {
    @Provides
    public Context provideApplicationContext(CalculatorApplication application) {
        return application.getApplicationContext();
    }

    @Provides
    public String provideString() {
        return "holis";
    }
}
