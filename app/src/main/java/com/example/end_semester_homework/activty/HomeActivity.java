package com.example.end_semester_homework.activty;


import android.app.Activity;
import android.content.Intent;
import android.content.res.AssetManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.end_semester_homework.R;
import com.example.end_semester_homework.adapter.MyPagerAdapter;
import com.example.end_semester_homework.fragment.FragmentA;
import com.example.end_semester_homework.fragment.FragmentB;
import com.example.end_semester_homework.fragment.FragmentC;
import com.example.end_semester_homework.fragment.FragmentD;
import com.flyco.tablayout.SlidingTabLayout;

import java.io.IOException;
import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity{
    private VideoView videoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        // Get a reference to the SlidingTabLayout and the ViewPager
        SlidingTabLayout slidingTabLayout = findViewById(R.id.slidingTabLayout);
        ViewPager viewPager = findViewById(R.id.view_pager);

        // Create an adapter for the ViewPager
        MyPagerAdapter adapter = new MyPagerAdapter(getSupportFragmentManager());

        // Add some fragments to the adapter
        adapter.addFragment(new FragmentA(), "游戏");
        adapter.addFragment(new FragmentB(), "音乐");
        adapter.addFragment(new FragmentC(), "美食");
        adapter.addFragment(new FragmentD(), "农人");
        adapter.addFragment(new FragmentA(), "Vlog");
        adapter.addFragment(new FragmentB(), "搞笑");
        adapter.addFragment(new FragmentC(), "宠物");
        adapter.addFragment(new FragmentD(), "军事");

        // Set the adapter for the ViewPager
        viewPager.setAdapter(adapter);

        // Set the ViewPager as the source for the SlidingTabLayout
        slidingTabLayout.setViewPager(viewPager);
    }
}

