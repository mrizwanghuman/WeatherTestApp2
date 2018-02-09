package com.pro.rizwan.weathertestapp.homeactivity;


import com.pro.rizwan.weathertestapp.model.Currently;
import com.pro.rizwan.weathertestapp.model.Daily;

import com.pro.rizwan.weathertestapp.utils.BasePresenter;
import com.pro.rizwan.weathertestapp.utils.BaseView;


/**
 * Created by  Riz.
 */

public interface GetForecastContractor {
interface View extends BaseView{
    void showProgress(String progress);
    void setForeCast(Daily dailyForecast);
}
interface Presenter extends BasePresenter<View> {
    void getForecast(double latitude, double longitude);

}
}
