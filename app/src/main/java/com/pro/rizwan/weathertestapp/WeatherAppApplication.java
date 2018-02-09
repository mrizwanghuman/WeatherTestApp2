package com.pro.rizwan.weathertestapp;

import android.app.Application;
import android.content.Context;

import com.pro.rizwan.weathertestapp.injection.module.component.AppComponent;
import com.pro.rizwan.weathertestapp.injection.module.component.DaggerAppComponent;
import com.pro.rizwan.weathertestapp.injection.module.component.HomeComponent;
import com.pro.rizwan.weathertestapp.injection.module.module.AppsModule;
import com.pro.rizwan.weathertestapp.injection.module.module.HomeModule;
import com.pro.rizwan.weathertestapp.utils.Constants;



public class WeatherAppApplication extends Application {

    private String BASE_URL_CUR_WEATHER ="https://api.darksky.net/forecast/";
    private static String apiKey = Constants.apiKey;
    private AppComponent appComponent;
    private HomeComponent homeComponent;

    @Override
    public void onCreate() {
        super.onCreate();
AppsModule appsModule= new AppsModule(BASE_URL_CUR_WEATHER, apiKey);
appComponent= DaggerAppComponent.builder().appsModule(appsModule).build();
    }

    public static WeatherAppApplication get(Context context) {
        return (WeatherAppApplication) context.getApplicationContext();
    }

    public HomeComponent getHomeComponent() {
        homeComponent = appComponent.add(new HomeModule());
        return homeComponent;
    }
    public void clearHomeComponent() {
        homeComponent = null;

    }
}
