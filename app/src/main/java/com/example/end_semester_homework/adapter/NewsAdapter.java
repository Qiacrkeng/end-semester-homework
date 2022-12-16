package com.example.end_semester_homework.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.end_semester_homework.R;
import com.example.end_semester_homework.entity.NewsEntity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context mContext;
    private List<NewsEntity> datas;

    public interface OnItemClickListener {
        void onItemClick(Serializable obj);
    }

    private OnItemClickListener mOnItemClickListener;

    public void setDatas(List<NewsEntity> datas) {
        this.datas = datas;
    }


    public NewsAdapter(Context context) {
        this.mContext = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.news_item_one, parent, false);
        return new ViewHolderOne(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        NewsEntity newsEntity = datas.get(position);
        ViewHolderOne vh = (ViewHolderOne) holder;
        vh.title.setText(newsEntity.getNewsTitle());
        vh.author.setText(newsEntity.getAuthorName());
        vh.comment.setText(newsEntity.getCommentCount() + "评论 .");
        vh.time.setText(newsEntity.getReleaseDate());
        vh.newsEntity = newsEntity;
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public void setOnItemClickListener(OnItemClickListener mOnItemClickListener) {
        this.mOnItemClickListener = mOnItemClickListener;
    }

    public class ViewHolderOne extends RecyclerView.ViewHolder {
        private TextView title;
        private TextView author;
        private TextView comment;
        private TextView time;
        private ImageView header;
        private ImageView thumb;
        private NewsEntity newsEntity;

        public ViewHolderOne(@NonNull View view) {
            super(view);
            title = view.findViewById(R.id.title);
            author = view.findViewById(R.id.author);
            comment = view.findViewById(R.id.comment);
            time = view.findViewById(R.id.time);
            header = view.findViewById(R.id.header);
            thumb = view.findViewById(R.id.thumb);
            view.setOnClickListener(v -> mOnItemClickListener.onItemClick(newsEntity));
        }
    }
}
