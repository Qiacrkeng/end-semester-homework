package com.example.end_semester_homework.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import androidx.fragment.app.Fragment;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;
import com.example.end_semester_homework.R;
import com.example.end_semester_homework.adapter.MyPagerAdapter;
import com.flyco.tablayout.SlidingTabLayout;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    protected View mRootView = null; // 根view
    private ViewPager viewPager;


    // 每次创建绘制view时的回调
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mRootView == null) {
            mRootView = inflater.inflate(R.layout.fragment_home, container, false);

            viewPager = mRootView.findViewById(R.id.content_view_pager);

            // Get a reference to the SlidingTabLayout and the ViewPager
            // 顶部导航栏
            SlidingTabLayout slidingTabLayout = mRootView.findViewById(R.id.slide_nav_bar);


            String[] titles = {"游戏", "音乐", "美食", "农人",
                    "Vlog", "搞笑", "宠物", "军事"};
            ArrayList<Fragment> fragments = new ArrayList<>();
            fragments.add(new FragmentA());
            fragments.add(new FragmentB());
            fragments.add(new FragmentC());
            fragments.add(new FragmentD());
            fragments.add(new FragmentA());
            fragments.add(new FragmentB());
            fragments.add(new FragmentC());
            fragments.add(new FragmentD());

            // Create an adapter for the ViewPager
            MyPagerAdapter adapter = new MyPagerAdapter(getFragmentManager(), titles,fragments);

            // Add some fragments to the adapter
//            adapter.addFragment(new FragmentA(), "游戏");
//            adapter.addFragment(new FragmentB(), "音乐");
//            adapter.addFragment(new FragmentC(), "美食");
//            adapter.addFragment(new FragmentD(), "农人");
//            adapter.addFragment(new FragmentA(), "Vlog");
//            adapter.addFragment(new FragmentB(), "搞笑");
//            adapter.addFragment(new FragmentC(), "宠物");
//            adapter.addFragment(new FragmentD(), "军事");

            // Set the adapter for the ViewPager
            viewPager.setAdapter(adapter);

            // Set the ViewPager as the source for the SlidingTabLayout
            slidingTabLayout.setViewPager(viewPager);
        }
        return mRootView;
    }
}
