package com.pro.rizwan.weathertestapp.remote;


import com.pro.rizwan.weathertestapp.model.WeatherModel;



import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;




public interface RemoteService {
    @GET("{apiKey}/{latitude},{longitude}")
    Observable<WeatherModel> getCurrentWeather(@Path(value = "apiKey", encoded = true) String apiKey,
                                               @Path(value = "latitude", encoded = true) double latitude,
                                               @Path(value = "longitude", encoded = true) double longitude);
}
