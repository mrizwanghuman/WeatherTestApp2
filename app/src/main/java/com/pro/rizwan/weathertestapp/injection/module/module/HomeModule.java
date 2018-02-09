package com.pro.rizwan.weathertestapp.injection.module.module;

import com.pro.rizwan.weathertestapp.homeactivity.ForeCastPresenter;
import com.pro.rizwan.weathertestapp.remote.RetrofitHelper;

import dagger.Module;
import dagger.Provides;


@Module
public class HomeModule {
    @Provides
    ForeCastPresenter providesHomePresenter(RetrofitHelper remoteDataSource){
        return new ForeCastPresenter(remoteDataSource);
    }
}
