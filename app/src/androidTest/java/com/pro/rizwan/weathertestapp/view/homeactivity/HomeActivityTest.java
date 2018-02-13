package com.pro.rizwan.weathertestapp.view.homeactivity;

import android.support.test.rule.ActivityTestRule;
import android.widget.FrameLayout;

import com.pro.rizwan.weathertestapp.R;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;


public class HomeActivityTest {
    @Rule
    public ActivityTestRule<HomeActivity> homeActivityActivityTestRule = new ActivityTestRule<HomeActivity>(HomeActivity.class);

    HomeActivity homeActivity = null;

    @Before
    public void setUp() throws Exception {
        homeActivity = homeActivityActivityTestRule.getActivity();
    }

    @Test
    public void uiExist() {
        assertNotNull(homeActivity.findViewById(R.id.swForeCastRefresh));
        assertNotNull(homeActivity.findViewById(R.id.swForeCastRefresh));
        FrameLayout frameLayout =homeActivity.findViewById(R.id.fmEachDayForeCast);
        assertNotNull(frameLayout);
    }

    @After
    public void tearDown() throws Exception {
        homeActivity = null;
    }

}