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
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.end_semester_homework.R;
import com.example.end_semester_homework.adapter.MyPagerAdapter;
import com.example.end_semester_homework.entity.TabEntity;
import com.example.end_semester_homework.fragment.*;
import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.SlidingTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;

import java.io.IOException;
import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {
    // 底部标题
    private String[] mTitles = {"首页", "资讯", "我的"};
    // 底部栏数据
    private ArrayList<CustomTabEntity> mTabEntity = new ArrayList<>();
    // 底部导航栏
    private CommonTabLayout commonTabLayout;
    // 未选择时的图标
    private int[] mIconUnselectIds = {
            R.mipmap.home_unselect, R.mipmap.collect_unselect, R.mipmap.my_unselect
    };
    // 选择时的图标
    private int[] mIconSelectIds = {
            R.mipmap.home_selected, R.mipmap.collect_selected, R.mipmap.my_selected
    };
    // 简单页面切换组件
    private ViewPager viewPager;
    // 所有页的片段
    private ArrayList<Fragment> mFragments = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        viewPager = findViewById(R.id.view_pager);
        commonTabLayout = findViewById(R.id.footer_nav_bar);

        mFragments.add(new HomeFragment());
        mFragments.add(new NewsFragment());
        mFragments.add(new MyFragment());
        // 底部栏数据初始化
        for (int i = 0; i < mTitles.length; i++) {
            mTabEntity.add(new TabEntity(mTitles[i], mIconSelectIds[i], mIconUnselectIds[i]));
        }
        // 加载数据
        commonTabLayout.setTabData(mTabEntity);
        // 点击底部栏会触发页面切换事件
        commonTabLayout.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                // 涌入目标片段程序
                viewPager.setCurrentItem(position);
            }

            @Override
            public void onTabReselect(int position) {
            }
        });
        // 限制
        viewPager.setOffscreenPageLimit(mFragments.size());
        // 页面切换
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}

            @Override
            public void onPageSelected(int position) {
                // 切换标签
                commonTabLayout.setCurrentTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {}
        });
        // 页面切换组件适配
        viewPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager(), mTitles, mFragments));
    }
}

