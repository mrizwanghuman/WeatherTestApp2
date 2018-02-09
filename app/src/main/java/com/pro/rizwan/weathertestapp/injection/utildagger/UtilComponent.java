package com.pro.rizwan.weathertestapp.injection.utildagger;

import com.pro.rizwan.weathertestapp.homeactivity.ForeCastPresenter;
import com.pro.rizwan.weathertestapp.homeactivity.HomeActivity;

import dagger.Component;


@Component (modules = UtilModule.class)
public interface UtilComponent {
    void inject(HomeActivity homeActivity);
}
