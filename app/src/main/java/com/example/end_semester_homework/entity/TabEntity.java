package com.example.end_semester_homework.entity;

import com.flyco.tablayout.listener.CustomTabEntity;

public class TabEntity implements CustomTabEntity {
    public String title; // 标签标题
    public int selectedIcon; // 选中时的图标
    public int unSelectedIcon; //未选中时的图标

    public TabEntity(String title, int selectedIcon, int unSelectedIcon) {
        this.selectedIcon = selectedIcon;
        this.title = title;
        this.unSelectedIcon = unSelectedIcon;
    }

    public String getTabTitle() {
        return this.title;
    }
    public int getTabSelectedIcon(){
        return this.selectedIcon;
    }

    @Override
    public int getTabUnselectedIcon() {
        return this.unSelectedIcon;
    }
}
