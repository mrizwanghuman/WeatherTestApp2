package com.pro.rizwan.weathertestapp.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.pro.rizwan.weathertestapp.R;
import com.pro.rizwan.weathertestapp.model.Datum__;


import java.util.List;




public class DailyForecastAdapter extends ArrayAdapter<Datum__> {
    private List<Datum__> dailyForeCast;

    public DailyForecastAdapter(@NonNull Context context, int resource, @NonNull List<Datum__> objects) {
        super(context, resource, objects);
        this.dailyForeCast = objects;
    }

    @SuppressLint("ViewHolder")
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
View view;

            LayoutInflater inflater = (LayoutInflater) parent.getContext()
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            view = inflater.inflate(R.layout.daily_forecast_listview, parent, false);



        TextView tvHighTemprature= view.findViewById(R.id.tvHighTemprature);
            TextView tvCondition= view.findViewById(R.id.tvCondition);
            TextView tvLowTemp = view.findViewById(R.id.tvLowTemprature);
            ImageView imIcon = view.findViewById(R.id.imIcon);

            String highTemp="H: "+dailyForeCast.get(position).getTemperatureHigh().toString()+"\u2109";
            String lowTemp = "L: "+dailyForeCast.get(position).getTemperatureLow().toString()+"\u2109";

        tvHighTemprature.setText(highTemp);
        tvLowTemp.setText(lowTemp);
            tvCondition.setText(ConditionSwitch.conditionSwitch(dailyForeCast.get(position).getIcon()));
            imIcon.setImageResource(IconSwitch.iconSwitchart(dailyForeCast.get(position).getIcon()));


        return view;
    }


}
