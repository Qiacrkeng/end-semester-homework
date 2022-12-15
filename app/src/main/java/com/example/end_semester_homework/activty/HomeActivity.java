package com.example.end_semester_homework.activty;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.end_semester_homework.R;
import com.example.end_semester_homework.adapter.Adapter_Home;
import com.flyco.tablayout.SlidingTabLayout;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Create the adapter that will return a fragment for each section
        Adapter_Home adapter = new Adapter_Home(getSupportFragmentManager());

        // Add fragments to adapter
        adapter.addFragment(new Fragment1(), "Fragment 1");
        adapter.addFragment(new Fragment2(), "Fragment 2");

        // Set the adapter to the view pager
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPage);
        viewPager.setAdapter(adapter);

        // Set the view pager to the sliding tab layout
        SlidingTabLayout slidingTabs = (SlidingTabLayout) findViewById(R.id.slide);
        slidingTabs.setViewPager(viewPager);
    }
}
