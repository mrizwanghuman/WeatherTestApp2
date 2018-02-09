package com.pro.rizwan.weathertestapp.injection.module.component;

import com.pro.rizwan.weathertestapp.homeactivity.HomeActivity;
import com.pro.rizwan.weathertestapp.injection.module.module.HomeModule;

import dagger.Subcomponent;

/**
 * Created by  Admin on 2/9/2018.
 */
@Subcomponent(modules = HomeModule.class)
public interface HomeComponent {
    void inject(HomeActivity homeActivity);
}
