package com.pro.rizwan.weathertestapp.injection.module.component;

import com.pro.rizwan.weathertestapp.view.homeactivity.HomeActivity;
import com.pro.rizwan.weathertestapp.injection.module.module.HomeModule;

import dagger.Subcomponent;


@Subcomponent(modules = HomeModule.class)
public interface HomeComponent {
    void inject(HomeActivity homeActivity);
}
