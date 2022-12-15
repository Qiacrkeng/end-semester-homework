package com.example.end_semester_homework.adapter;

import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class MyPagerAdapter extends FragmentPagerAdapter {
    // 页面标题
    private String[] mTitles;
    // 页面片段
    private ArrayList<Fragment> mFragments;
//    private List<String> titles = new ArrayList<>();
//
//    public MyPagerAdapter(FragmentManager fm) {
//        super(fm);
//        mFragments = new ArrayList<>();
//        mTitles = new String[]{};
//    }

    public MyPagerAdapter(FragmentManager fm, String[] titles, ArrayList<Fragment> fragments) {
        super(fm);
        this.mTitles = titles;
        this.mFragments = fragments;
    }


//    public void addFragment(Fragment fragment, String title) {
//        mFragments.add(fragment);
//        titles.add(title);
//    }
    // 显示片段
    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }
    // 大小
    @Override
    public int getCount() {
        return mFragments.size();
    }
    // 标题展示
    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles[position];
    }
}

