package com.example.end_semester_homework.fragment;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.fragment.app.Fragment;

import com.example.end_semester_homework.R;

public class FragmentA extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_one, container, false);

//        MediaController controller = new MediaController(getContext());

        VideoView videoView = view.findViewById(R.id.videoView);
        videoView.setVideoURI(Uri.parse("android.resource://" + getContext().getPackageName() + "/raw/" + R.raw.video));


        VideoView videoView2 = view.findViewById(R.id.videoView2);
        videoView2.setVideoURI(Uri.parse("android.resource://" + getContext().getPackageName() + "/raw/" + R.raw.video));

//        videoView.setMediaController(controller);
//        videoView2.setMediaController(controller);

//        videoView.requestFocus();
//        videoView2.requestFocus();
//        videoView2.start();
        videoView.start();


        videoView2.setOnClickListener(v -> {
            videoView2.start();
        });


        return view;
    }
}