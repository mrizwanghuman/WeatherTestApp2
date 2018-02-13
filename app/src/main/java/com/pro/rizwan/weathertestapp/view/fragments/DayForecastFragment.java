package com.pro.rizwan.weathertestapp.view.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pro.rizwan.weathertestapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DayForecastFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DayForecastFragment extends Fragment {

    private static final String Arg_highTemp = "highTemp";
    private static final String Arg_lowTemp = "lowTemp";
    private static final String Arg_condition = "condition";
    private static final String Arg_windspeed = "windspeed";
    @BindView(R.id.tvHighTemp)
    TextView tvHighTemp;
    @BindView(R.id.tvLowTemp)
    TextView tvLowTemp;
    @BindView(R.id.tvCondition)
    TextView tvCondition;
    @BindView(R.id.tvWindSpeed)
    TextView tvWindSpeed;
    Unbinder unbinder;


    private double mHighTemp;
    private double mLowTemp;
    private String mCondition;
    private double mWindSpeed;


    public DayForecastFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param highTemp  Parameter 1.
     * @param lowTemp   Parameter 2.
     * @param condition Parameter 3.
     * @param windspeed Parameter 4.
     * @return A new instance of fragment DayForecastFragment.
     */

    public static DayForecastFragment newInstance(double highTemp, double lowTemp, String condition, double windspeed) {
        DayForecastFragment fragment = new DayForecastFragment();
        Bundle args = new Bundle();
        args.putDouble(Arg_highTemp, highTemp);
        args.putDouble(Arg_lowTemp, lowTemp);
        args.putString(Arg_condition, condition);
        args.putDouble(Arg_windspeed, windspeed);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mHighTemp = getArguments().getDouble(Arg_highTemp);
            mLowTemp = getArguments().getDouble(Arg_lowTemp);
            mCondition = getArguments().getString(Arg_condition);
            mWindSpeed = getArguments().getDouble(Arg_windspeed);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_day_forecast, container, false);


        unbinder = ButterKnife.bind(this, view);
        String highttemp="High: "+ Double.toString(mHighTemp);
        String lowtemp = "Low: "+Double.toString(mLowTemp);
        String windspeed ="Wind Speed: "+ Double.toString(mWindSpeed);
        tvHighTemp.setText(highttemp);
        tvLowTemp.setText(lowtemp);
        tvWindSpeed.setText(windspeed);
        tvCondition.setText("Condition: "+mCondition);

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
