package com.pro.rizwan.weathertestapp.splashscreen;

import android.app.Activity;
import android.app.Instrumentation;
import android.support.test.rule.ActivityTestRule;
import android.view.View;

import com.pro.rizwan.weathertestapp.R;
import com.pro.rizwan.weathertestapp.homeactivity.HomeActivity;
import com.pro.rizwan.weathertestapp.splashscreen.SplashScreen;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static org.junit.Assert.*;


public class SplashScreenTest {
    @Rule
    public ActivityTestRule<SplashScreen> splashScreenActivityTestRule = new ActivityTestRule<>(SplashScreen.class);
    Instrumentation.ActivityMonitor activityMonitor = getInstrumentation().addMonitor(HomeActivity.class.getName(), null, false);
    private SplashScreen splashScreen= null;

    @Before
    public void setUp() throws Exception {
        splashScreen = splashScreenActivityTestRule.getActivity();
    }

    @After
    public void tearDown() throws Exception {
        splashScreen=null;
    }
    @Test
    public void testLaunch(){
        View view = splashScreen.findViewById(R.id.imLauch);
        assertNotNull(view);

        Activity HomeActivity = getInstrumentation().waitForMonitorWithTimeout(activityMonitor,2000);
        assertNotNull(HomeActivity);


    }


}