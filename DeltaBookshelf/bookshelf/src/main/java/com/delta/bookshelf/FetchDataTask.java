package com.delta.bookshelf;

/**
 * Created by spawrks on 2/22/14.
 */

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;

public class FetchDataTask extends AsyncTask<Void, Void, FacebookEntity> {

    private LazyAdapter adapter;
    private int position;
    private String id;

    public FetchDataTask(LazyAdapter adapter, int position) {
        this.adapter = adapter;
        this.position = position;
        this.id = (String) adapter.getItem(position);
    }

    @Override
    protected FacebookEntity doInBackground(Void... params) {

        //first get the user data
        FacebookEntity user = new FacebookEntity(id);

        //then bitmap
        Bitmap bitmap = null;
        try {
            HttpURLConnection httpUrlConnection;
            httpUrlConnection = (HttpURLConnection) new java.net.URL(
                    user.getPicture()).openConnection();
            httpUrlConnection.setReadTimeout(10000);
            httpUrlConnection.setConnectTimeout(10000);
            InputStream inputStream = httpUrlConnection.getInputStream();
            BufferedInputStream bufferedInputStream = new BufferedInputStream(
                    inputStream);
            bitmap = BitmapFactory.decodeStream(bufferedInputStream);
            bufferedInputStream.close();
            inputStream.close();
            httpUrlConnection.disconnect();

        } catch (MalformedURLException e) {
        } catch (IOException e) {
        }

        user.setBitmap(bitmap);

        return user;
    }

    @Override
    protected void onPostExecute(FacebookEntity result) {
        super.onPostExecute(result);
        adapter.saveEntity(result);
        //recursion!
        if (position < adapter.getCount() - 1) {
            new FetchDataTask(adapter, ++position).execute();
        }
    }
}