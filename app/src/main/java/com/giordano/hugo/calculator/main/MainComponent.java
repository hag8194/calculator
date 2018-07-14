package com.giordano.hugo.calculator.main;

import com.giordano.hugo.calculator.di.scope.ActivityScope;

import dagger.BindsInstance;
import dagger.Subcomponent;

@ActivityScope
@Subcomponent(modules = MainModule.class)
public interface MainComponent {

    void inject(MainActivity mainActivity);

    @Subcomponent.Builder
    interface Builder {
        @BindsInstance
        Builder activity(MainActivity mainActivity);
        MainComponent build();
    }
}
