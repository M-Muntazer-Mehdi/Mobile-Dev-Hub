package com.example.smd_assignments.Assignment_4;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.smd_assignments.R;
public class PictureFragment_Four extends Fragment {

    ImageView imageView_Four;
    String Url;

    public PictureFragment_Four() {
    }
    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_picture__four, container, false);
        Bundle bundle = getArguments();
        if(bundle != null)
        {
            Url = bundle.getString("message");
        }

        imageView_Four = view.findViewById(R.id.imageView_Four);
        imageView_Four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(imageView_Four.getVisibility() == View.VISIBLE)
                {
                    imageView_Four.setVisibility(View.GONE);
                }
                else
                {
                    imageView_Four.setVisibility(View.VISIBLE);
                }
            }
        });

        GetImageFromUrl image = new GetImageFromUrl(imageView_Four);
        image.execute(Url);
        return view;
    }
}