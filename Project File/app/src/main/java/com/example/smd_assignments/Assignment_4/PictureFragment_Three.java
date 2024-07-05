package com.example.smd_assignments.Assignment_4;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.smd_assignments.R;

public class PictureFragment_Three extends Fragment {

    ImageView imageView_Three;
    String Url;

    public PictureFragment_Three() {
        // Required empty public constructor
    }

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_picture__three, container, false);
        Bundle bundle = getArguments();
        if(bundle != null)
        {
            Url = bundle.getString("message");
        }

        imageView_Three = view.findViewById(R.id.imageView_Three);
        imageView_Three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(imageView_Three.getVisibility() == View.VISIBLE)
                {
                    imageView_Three.setVisibility(View.GONE);
                }
                else
                {
                    imageView_Three.setVisibility(View.VISIBLE);
                }
            }
        });

        GetImageFromUrl image = new GetImageFromUrl(imageView_Three);
        image.execute(Url);
        return view;
    }
}