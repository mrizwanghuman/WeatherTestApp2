package com.pro.rizwan.weathertestapp.homeactivity;



import android.util.Log;


import com.pro.rizwan.weathertestapp.model.Daily;


import com.pro.rizwan.weathertestapp.model.WeatherModel;
import com.pro.rizwan.weathertestapp.remote.RetrofitHelper;
import com.pro.rizwan.weathertestapp.utils.Constants;


import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


public class ForeCastPresenter implements GetForecastContractor.Presenter {
    private GetForecastContractor.View view;
RetrofitHelper retrofitHelper;
    private Daily dailyForecast;

    @Inject
    public ForeCastPresenter(RetrofitHelper retrofitHelper) {
        this.retrofitHelper = retrofitHelper;
    }

    @Override
    public void onAttachView(GetForecastContractor.View view) {
        this.view= view;
    }

    @Override
    public void onDetachView() {
this.view=null;
    }

    @Override
    public void getForecast(double latitude, double longitude) {

        retrofitHelper.getForecast(latitude, longitude).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io())
                .subscribe(new Observer<WeatherModel>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        view.showProgress("Loading");

                    }

                    @Override
                    public void onNext(WeatherModel weatherModel) {
                        Log.d("Before", "onNext: ");



                           dailyForecast = weatherModel.getDaily();

                        Log.d("NextP", "onNext: "+dailyForecast.getData().get(0).getSummary());
                    }

                    @Override
                    public void onError(Throwable e) {
                        view.showError(e.getMessage());

                    }

                    @Override
                    public void onComplete() {
view.setForeCast(dailyForecast);
                    }
                });

    }
}
