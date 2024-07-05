package com.example.smd_assignments.Assignment_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import com.example.smd_assignments.R;

public class MediaPlayer_Activity_One extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_player_one);

        VideoView videoView = findViewById(R.id.videoview1);

        Intent intent1 = getIntent();

        Uri videouri = (Uri) intent1.getParcelableExtra("Video");

        videoView.setVideoURI(videouri);
        videoView.start();

        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);


    }
}