package com.example.end_semester_homework.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.example.end_semester_homework.R;
import com.example.end_semester_homework.activty.MainActivity;
import com.example.end_semester_homework.activty.MyCollectActivity;

public class MyFragment extends Fragment {
    protected View mRootView = null; // 根view

    // 每次创建绘制view时的回调
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mRootView == null) {
            mRootView = inflater.inflate(R.layout.fragment_my, container, false);

//            ImageView imageView = mRootView.findViewById(R.id.img_header);
            RelativeLayout rl_back = mRootView.findViewById(R.id.rl_logout);
            rl_back.setOnClickListener(view -> {
                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
            });
            RelativeLayout rl_collect = mRootView.findViewById(R.id.rl_collect);
            rl_collect.setOnClickListener(view -> {
                Intent intent = new Intent(getActivity(), MyCollectActivity.class);
                startActivity(intent);
            });
            RelativeLayout rl_skin = mRootView.findViewById(R.id.rl_skin);
            rl_skin.setOnClickListener(view->{
                Toast.makeText(getActivity(), "此功能未开放", Toast.LENGTH_SHORT).show();
            });
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
