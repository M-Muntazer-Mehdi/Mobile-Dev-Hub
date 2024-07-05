package com.example.smd_assignments.Assignment_4;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.smd_assignments.R;

import java.io.InputStream;
import java.net.URL;

public class PictureFragment_One extends Fragment {

    ImageView imageView_One;
    String Url;

    public PictureFragment_One() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_picture__one, container, false);

        Bundle bundle = getArguments();
        if(bundle != null)
        {
            Url = bundle.getString("message");
        }

        imageView_One = view.findViewById(R.id.imageView_One);
        imageView_One.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(imageView_One.getVisibility() == View.VISIBLE)
                {
                    imageView_One.setVisibility(View.GONE);
                }
                else
                {
                    imageView_One.setVisibility(View.VISIBLE);
                }
            }
        });

        GetImageFromUrl image = new GetImageFromUrl(imageView_One);
        image.execute(Url);
        return view;
    }
}