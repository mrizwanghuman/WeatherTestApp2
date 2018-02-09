package com.pro.rizwan.weathertestapp.splashscreen;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.pro.rizwan.weathertestapp.R;
import com.pro.rizwan.weathertestapp.homeactivity.HomeActivity;

public class SplashScreen extends AppCompatActivity {
Intent homeScreenIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        startHomeActivity();
    }
    public   void startHomeActivity(){
         homeScreenIntent                = new Intent(this, HomeActivity.class);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                startActivity(homeScreenIntent );
                finish();
            }
        }, 2000);

    }
}
