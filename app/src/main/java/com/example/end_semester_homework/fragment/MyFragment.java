package com.example.end_semester_homework.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.example.end_semester_homework.R;

public class MyFragment extends Fragment {
    protected View mRootView = null; // 根view

    // 每次创建绘制view时的回调
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mRootView == null) {
            mRootView = inflater.inflate(R.layout.fragment_my, container, false);
        }
        return mRootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    // 统一点击事件
    public void viewClick(View view) {
        switch (view.getId()) {
            // 点击头像
            case R.id.img_header:
                break;
            // 点击收藏
            case R.id.rl_collect:
//                Intent intent = new Intent(this,)
                break;
            // 更换皮肤
            case R.id.rl_skin:
                break;

        }
    }
}
