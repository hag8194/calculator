package com.giordano.hugo.calculator.main;

import android.arch.lifecycle.ViewModelProviders;
import dagger.Module;
import dagger.Provides;


@Module
public class MainModule {
    @Provides
    public MainViewModel provideMainViewModel(MainActivity activity) {
        return ViewModelProviders.of(activity).get(MainViewModel.class);
    }
}
