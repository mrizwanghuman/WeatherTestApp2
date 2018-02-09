package com.pro.rizwan.weathertestapp.utils;


public interface BasePresenter<V extends BaseView> {
    void onAttachView(V view);
    void onDetachView();
}
