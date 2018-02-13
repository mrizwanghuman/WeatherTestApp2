package com.pro.rizwan.weathertestapp.view.fragments;

import android.support.test.rule.ActivityTestRule;
import android.view.View;
import android.widget.FrameLayout;

import com.pro.rizwan.weathertestapp.R;
import com.pro.rizwan.weathertestapp.view.homeactivity.HomeActivity;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static org.junit.Assert.*;


public class DayForecastFragmentTest {
    @Rule
    public ActivityTestRule<HomeActivity> homeActivityActivityTestRule = new ActivityTestRule<>(HomeActivity.class);

    private HomeActivity homeActivity=null;
    private DayForecastFragment dayForecastFragment;
    @Before
    public void setUp() throws Exception {
        homeActivity= homeActivityActivityTestRule.getActivity();
        dayForecastFragment= new DayForecastFragment();
    }
@Test
public void testFragmentLaunch(){
    FrameLayout frameLayout = homeActivity.findViewById(R.id.fmEachDayForeCast);
    // fragment test
    homeActivity.getSupportFragmentManager().beginTransaction().replace(frameLayout.getId(), dayForecastFragment).commit();
    // fragment view test
    getInstrumentation().waitForIdleSync();
    View view = dayForecastFragment.getView().findViewById(R.id.cvFragment);
    assertNotNull(view);
}
    @After
    public void tearDown() throws Exception {
    }

}