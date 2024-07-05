package com.example.smd_assignments.Assignment_4;

import android.annotation.SuppressLint;
import android.app.DownloadManager;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.smd_assignments.R;

import java.io.File;
import java.io.InputStream;
import java.net.URL;

public class Service_Fragment_Activity_One extends AppCompatActivity {

    EditText editText;
    Button button;
    int count = 0;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_fragment_one);

        editText = findViewById(R.id.txtUrl);
        button = findViewById(R.id.downloadButton);

        button.setOnClickListener(v -> {
            count++;
            String Url = editText.getText().toString();
            downloadImage("image"+count, Url);

            Bundle bundle = new Bundle();
            bundle.putString("message",editText.getText().toString());

            if(count == 1) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                PictureFragment_One fragment_1 = new PictureFragment_One();
                fragment_1.setArguments(bundle);
                fragmentTransaction.replace(R.id.fragment1, fragment_1).commit();
            }

            if(count == 2) {
                FragmentManager fragmentManager1 = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction1 = fragmentManager1.beginTransaction();
                PictureFragment_Two fragment_2 = new PictureFragment_Two();
                fragment_2.setArguments(bundle);
                fragmentTransaction1.replace(R.id.fragment2, fragment_2).commit();
            }

            if(count == 3) {
                FragmentManager fragmentManager3 = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction3 = fragmentManager3.beginTransaction();
                PictureFragment_Three fragment_3 = new PictureFragment_Three();
                fragment_3.setArguments(bundle);
                fragmentTransaction3.replace(R.id.fragment3, fragment_3).commit();
            }

            if(count >= 4) {
                FragmentManager fragmentManager4 = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction4 = fragmentManager4.beginTransaction();
                PictureFragment_Four fragment_4 = new PictureFragment_Four();
                fragment_4.setArguments(bundle);
                fragmentTransaction4.replace(R.id.fragment4, fragment_4).commit();
            }

        });

    }

    public void downloadImage(String FileName, String Url)
    {
        try {
            DownloadManager downloadManager;
            downloadManager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);

            Uri uri = Uri.parse(Url);

            DownloadManager.Request request = new DownloadManager.Request(uri);
            request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI)
                    .setAllowedOverRoaming(false)
                    .setTitle(FileName)
                    .setMimeType("image/jpeg")
                    .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
                    .setDestinationInExternalPublicDir(Environment.DIRECTORY_PICTURES, File.separator + FileName + ".jpg");

            downloadManager.enqueue(request);

            Toast.makeText(this, "Image Downloading Done", Toast.LENGTH_SHORT).show();
        }catch (Exception e)
        {
            Toast.makeText(this, "Image Downloading Fail", Toast.LENGTH_SHORT).show();
        }
    }
}