package com.pro.rizwan.weathertestapp.injection.utildagger;

import com.pro.rizwan.weathertestapp.homeactivity.ForeCastPresenter;
import com.pro.rizwan.weathertestapp.homeactivity.HomeActivity;

import dagger.Module;
import dagger.Provides;


@Module
class UtilModule {
    @Provides
    ForeCastPresenter foreCastPresenterProvide(){
        return new ForeCastPresenter();
    }
}
