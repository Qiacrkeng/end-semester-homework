package com.example.end_semester_homework.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.end_semester_homework.R;
import com.example.end_semester_homework.adapter.NewsAdapter;
import com.example.end_semester_homework.entity.NewsEntity;

import java.util.ArrayList;
import java.util.List;

public class NewsFragment extends Fragment {
    View mRootView;
    // 集合
    private RecyclerView recyclerView;
    private List<NewsEntity> datas = new ArrayList<>();
    private NewsAdapter newsAdapter;
    int pageNum = 1;
    private LinearLayoutManager linearLayoutManager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mRootView == null) {
            mRootView = inflater.inflate(R.layout.fragment_news, container, false);

            recyclerView = mRootView.findViewById(R.id.recyclerView);

            linearLayoutManager = new LinearLayoutManager(getActivity());
            linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL); // 垂直
            // 设置布局
            recyclerView.setLayoutManager(linearLayoutManager);
            newsAdapter = new NewsAdapter(getActivity());

            NewsEntity newsEntity = new NewsEntity();
            newsEntity.setNewsTitle("《天外世界：果根险境》9月9日上架游戏将支持Xbox Series X专属强化");
            newsEntity.setAuthorName("游戏早知道 .");
            newsEntity.setCommentCount(1);
            newsEntity.setNewsId(1);
            newsEntity.setHeaderUrl(String.valueOf(R.mipmap.news_pic));
            newsEntity.setType(1);
            newsEntity.setReleaseDate("1小时前");

            NewsEntity.ThumbEntitiesBean tBean = new NewsEntity.ThumbEntitiesBean();
            List<NewsEntity.ThumbEntitiesBean> tBeans = new ArrayList<>();
            tBeans.add(tBean);
            newsEntity.setThumbEntities(tBeans);

            List<NewsEntity> newsEntityList = new ArrayList<>();
            newsEntityList.add(newsEntity);

            newsAdapter.setDatas(newsEntityList);
            recyclerView.setAdapter(newsAdapter);
            newsAdapter.notifyDataSetChanged();

        }
        return mRootView;
    }
}
