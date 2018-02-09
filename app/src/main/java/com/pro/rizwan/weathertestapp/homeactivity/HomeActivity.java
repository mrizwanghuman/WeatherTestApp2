package com.pro.rizwan.weathertestapp.homeactivity;


import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;


import com.pro.rizwan.weathertestapp.R;
import com.pro.rizwan.weathertestapp.fragments.DayForecastFragment;


import com.pro.rizwan.weathertestapp.injection.utildagger.DaggerUtilComponent;
import com.pro.rizwan.weathertestapp.model.Daily;
import com.pro.rizwan.weathertestapp.model.Datum__;

import com.pro.rizwan.weathertestapp.utils.DailyForecastAdapter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class HomeActivity extends AppCompatActivity implements GetForecastContractor.View {


    private static final String TAG = "MainActivity";

    @Inject
    public ForeCastPresenter foreCastPresenter;
    private ListView dailyListView;
    private android.support.v4.app.FragmentTransaction fragmentManager;
     private DayForecastFragment dayForecastFragment;
    private SwipeRefreshLayout swipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
DaggerUtilComponent.create().inject(this);
       // foreCastPresenter = new ForeCastPresenter();
        foreCastPresenter.onAttachView(this);
        swipeRefreshLayout = findViewById(R.id.swForeCastRefresh);
        foreCastPresenter.getForecast(32.715736,-117.161087);
        dailyListView = findViewById(R.id.lvDailyForecast);

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                foreCastPresenter.getForecast(32.715736,-117.161087);
                swipeRefreshLayout.setRefreshing(false);
            }
        });


    }


    @Override
    public void showError(String e) {
        Log.d(TAG, "showError: "+e);
    }

    @Override
    public void showProgress(String progress) {
        Log.d(TAG, "showProgress: "+progress);
    }

    @Override
    public void setForeCast(final Daily dailyForecast) {
        final List<Datum__> dailyForecastList = new ArrayList<>();

        dailyForecastDarkSky(dailyForecast, dailyForecastList);


    }

    private void dailyForecastDarkSky(Daily dailyForecast, final List<Datum__> dailyForecastList) {
        dailyForecastList.addAll(dailyForecast.getData());
        DailyForecastAdapter dailyForecastAdapter= new DailyForecastAdapter(this, R.layout.daily_forecast_listview,dailyForecastList);
        dailyListView.setAdapter(dailyForecastAdapter);
        dailyListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                double highTemp = dailyForecastList.get(i).getTemperatureHigh();
                double lowTemp = dailyForecastList.get(i).getTemperatureLow();
                double windSpeed = dailyForecastList.get(i).getWindSpeed();
                String condition = dailyForecastList.get(i).getSummary();

                dayForecastFragment = DayForecastFragment.newInstance(highTemp,lowTemp,condition, windSpeed);
                fragmentManager = getSupportFragmentManager().beginTransaction();

                fragmentManager.replace(R.id.fmEachDayForeCast, dayForecastFragment).addToBackStack("DayForecast").commit();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        foreCastPresenter.onDetachView();
    }

    @Override
    public void onBackPressed() {

        super.onBackPressed();


    }
}
