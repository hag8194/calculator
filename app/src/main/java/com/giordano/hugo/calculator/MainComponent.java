package com.giordano.hugo.calculator;

import dagger.Subcomponent;

@Subcomponent(modules = MainModule.class)
public interface MainComponent {

    void inject(MainActivity mainActivity);

    @Subcomponent.Builder
    interface Builder {
        MainComponent build();
    }
}
