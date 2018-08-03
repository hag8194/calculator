package com.giordano.hugo.calculator.di;

import android.arch.lifecycle.ViewModel;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import dagger.MapKey;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@MapKey
@Retention(RUNTIME)
public @interface ViewModelKey {
    Class<? extends ViewModel> value();
}
