package com.example.admin.async;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

import com.example.admin.downloadimagebyhttpurlconnection.MainActivity;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by Admin on 9/25/2017.
 */

public class ImageAsync extends AsyncTask<String , Void, Bitmap> {

    public Context context;
    public ImageView imgLoad;

    public ImageAsync(Context context, ImageView imageView){
        this.context = context;
        this.imgLoad = imageView;
    }


    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected Bitmap doInBackground(String... strings) {
        Bitmap bitmap = null;
        bitmap = downLoad(strings[0]);
        return bitmap;
    }

    private Bitmap downLoad(String string) {
        Bitmap bitmap = null;
        try {
            InputStream inputStream = null;

            URL url = new URL(string);
            URLConnection connection = url.openConnection();

            HttpURLConnection httpURLConnection = (HttpURLConnection) connection;
            httpURLConnection.setDoInput(true);
            httpURLConnection.connect();

            inputStream = httpURLConnection.getInputStream();
            bitmap = BitmapFactory.decodeStream(inputStream);
            return bitmap;


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
        imgLoad.setImageBitmap(bitmap);
    }
}
