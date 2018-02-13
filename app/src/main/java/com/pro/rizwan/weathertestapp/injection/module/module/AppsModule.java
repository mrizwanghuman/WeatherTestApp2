package com.pro.rizwan.weathertestapp.injection.module.module;

import com.pro.rizwan.weathertestapp.remote.RetrofitHelper;

import dagger.Module;
import dagger.Provides;


@Module
public class AppsModule {

    private String BaseURL;
    private String apiKey;

    public AppsModule(String baseURL, String apiKey) {
        this.BaseURL = baseURL;
        this.apiKey = apiKey;
    }

    @Provides
    RetrofitHelper providesRemoteDataSource(){
        return new RetrofitHelper(apiKey, BaseURL);
    }
}
