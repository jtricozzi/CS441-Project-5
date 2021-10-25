package com.example.cs441project5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

public class VideoPlayerActivity extends AppCompatActivity {

    private TextView videoNameTV, videoTimeTV;
    private ImageButton backIB, forardIB, playPause;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_player);
    }
}