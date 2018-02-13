package com.pro.rizwan.weathertestapp.remote;

import android.os.Environment;

import com.pro.rizwan.weathertestapp.model.WeatherModel;


import java.io.File;
import io.reactivex.Observable;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;



public class RetrofitHelper {

    private String BASE_URL_CUR_WEATHER ;
    private String apiKey;

    public RetrofitHelper(String apikey, String baseUrl) {
        this.apiKey= apikey;
        this.BASE_URL_CUR_WEATHER= baseUrl;

    }

    private static OkHttpClient httpClientConfig(HttpLoggingInterceptor interceptor){
       // File httpCache = new File(Context.getExternalCacheDir().getAbsolutePath() + "/tile_cache");
        File httpCacheDirectory = new File(Environment.getExternalStorageDirectory(), "HttpCache");// Here to facilitate the file directly on the SD Kagan catalog HttpCache in ， Generally put in context.getCacheDir() in

        int cacheSize = 10 * 1024 * 1024; // 10 MiB
        Cache cache = new Cache(httpCacheDirectory, cacheSize);
        return new OkHttpClient.Builder().cache(cache).addInterceptor(interceptor).build();

    }

    private static HttpLoggingInterceptor loggingInterceptor(){
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return  httpLoggingInterceptor;
    }

    private Retrofit createConfig(){
        return new Retrofit.Builder()
                .baseUrl(BASE_URL_CUR_WEATHER)
                .client(httpClientConfig(loggingInterceptor()))
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

    }


    public Observable<WeatherModel> getForecast( double latitude, double longitude){
        Retrofit retrofit = createConfig();
        RemoteService remoteService = retrofit.create(RemoteService.class);
        return remoteService.getCurrentWeather(apiKey, latitude, longitude);
    }



}
