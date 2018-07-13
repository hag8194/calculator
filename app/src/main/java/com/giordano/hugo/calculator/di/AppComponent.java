package com.giordano.hugo.calculator.di;

import dagger.BindsInstance;
import dagger.Component;
import com.giordano.hugo.calculator.CalculatorApplication;
import com.giordano.hugo.calculator.MainActivity;

import javax.inject.Singleton;

@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {
    void inject(MainActivity activity);

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(CalculatorApplication application);
        AppComponent build();
    }
}
