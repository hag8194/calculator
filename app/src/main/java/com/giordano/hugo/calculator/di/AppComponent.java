package com.giordano.hugo.calculator.di;

import dagger.BindsInstance;
import dagger.Component;
import com.giordano.hugo.calculator.CalculatorApplication;
import com.giordano.hugo.calculator.main.MainComponent;

import javax.inject.Singleton;

@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {

    MainComponent.Builder mainComponent();

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(CalculatorApplication application);
        AppComponent build();
    }
}
