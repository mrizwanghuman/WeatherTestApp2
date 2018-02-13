package com.pro.rizwan.weathertestapp.injection.module.component;

import com.pro.rizwan.weathertestapp.view.homeactivity.HomeActivity;
import com.pro.rizwan.weathertestapp.injection.module.module.AppsModule;
import com.pro.rizwan.weathertestapp.injection.module.module.HomeModule;


import dagger.Component;


@Component(modules=AppsModule.class)
public interface AppComponent {
    HomeComponent add(HomeModule homeModule);
}
