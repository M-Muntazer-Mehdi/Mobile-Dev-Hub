package com.example.smd_assignments.Assignment_3;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.smd_assignments.R;

public class PickFile_Activity_Three extends AppCompatActivity {

    Button button1, button2;
    Intent intent;

    public static final int Pick_File = 99;
    public static final int Pick_File1 = 200;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pick_file_three);

        button1 = findViewById(R.id.Mp3Button);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
                intent.addCategory(Intent.CATEGORY_OPENABLE);
                intent.setType("audio/*");
                startActivityForResult(intent, Pick_File);
            }
        });

        button2 = findViewById(R.id.Mp4Button);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(Intent.ACTION_OPEN_DOCUMENT);
                intent1.addCategory(Intent.CATEGORY_OPENABLE);
                intent1.setType("video/*");
                startActivityForResult(intent1, Pick_File1);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 99) {
            Uri uri = data.getData();
            PlayMusic(uri);
        }
        else if(requestCode == 200)
        {
            Uri uri = data.getData();
            PlayVideo(uri);
        }
    }

    public void PlayMusic(Uri uri)
    {
        intent = new Intent(PickFile_Activity_Three.this,MusicPlayer_Activity_Two.class);
        intent.putExtra("Music", uri);
        startActivity(intent);

    }

    public void PlayVideo(Uri uri)
    {
        intent = new Intent(PickFile_Activity_Three.this,MediaPlayer_Activity_One.class);
        intent.putExtra("Video", uri);
        startActivity(intent);
    }
}