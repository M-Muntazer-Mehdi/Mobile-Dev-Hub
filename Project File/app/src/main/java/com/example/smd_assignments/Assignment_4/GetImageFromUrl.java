package com.example.smd_assignments.Assignment_4;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.io.InputStream;


public class GetImageFromUrl extends AsyncTask<String, Void, Bitmap>
{
    Bitmap myBitmap;
    ImageView imageView;

    public GetImageFromUrl(ImageView imageView) {
        this.imageView = imageView;
    }

    @Override
    protected Bitmap doInBackground(String... url) {
        String Urldisplay = url[0];
        try {

            InputStream src = new java.net.URL(Urldisplay).openStream();
            myBitmap = BitmapFactory.decodeStream(src);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return myBitmap;
    }

    @Override
    protected void onPostExecute(Bitmap result) {
        super.onPostExecute(result);
        imageView.setImageBitmap(result);
    }

}
