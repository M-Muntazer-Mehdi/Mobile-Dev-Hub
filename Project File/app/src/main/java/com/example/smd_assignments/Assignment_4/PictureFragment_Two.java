package com.example.smd_assignments.Assignment_4;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.smd_assignments.R;

public class PictureFragment_Two extends Fragment {
    ImageView imageView_Two;
    String Url;

    public PictureFragment_Two() {
        // Required empty public constructor
    }

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_picture__two, container, false);
        Bundle bundle = getArguments();
        if(bundle != null)
        {
            Url = bundle.getString("message");
        }

        imageView_Two = view.findViewById(R.id.imageView_Two);
        imageView_Two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(imageView_Two.getVisibility() == View.VISIBLE)
                {
                    imageView_Two.setVisibility(View.GONE);
                }
                else
                {
                    imageView_Two.setVisibility(View.VISIBLE);
                }
            }
        });

        GetImageFromUrl image = new GetImageFromUrl(imageView_Two);
        image.execute(Url);
        return view;
    }
}