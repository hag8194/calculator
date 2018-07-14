package com.giordano.hugo.calculator.di;

import android.content.Context;
import com.giordano.hugo.calculator.CalculatorApplication;
import com.giordano.hugo.calculator.R;
import com.giordano.hugo.calculator.di.qualifier.NumbersQualifier;
import com.giordano.hugo.calculator.di.qualifier.OperatorsQualifier;
import com.giordano.hugo.calculator.main.MainComponent;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import dagger.multibindings.ElementsIntoSet;

@Module(subcomponents = MainComponent.class)
public class AppModule {
    @Provides
    @Named("AppContext")
    public Context provideApplicationContext(CalculatorApplication application) {
        return application.getApplicationContext();
    }

    @Provides
    public String provideString() {
        return "holis";
    }

    @Provides
    @ElementsIntoSet
    @NumbersQualifier
    public Set<String> provideNumbers(@Named("AppContext") Context applicationContext) {
        return new HashSet<>(Arrays.asList(applicationContext.getResources().getStringArray(R.array.numbers)));
    }

    @Provides
    @ElementsIntoSet
    @OperatorsQualifier
    public Set<String> provideOperators(@Named("AppContext") Context applicationContext) {
        return new HashSet<>(Arrays.asList(applicationContext.getResources().getStringArray(R.array.operators)));
    }
}
