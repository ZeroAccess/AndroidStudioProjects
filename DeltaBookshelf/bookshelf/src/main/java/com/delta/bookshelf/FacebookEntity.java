package com.delta.bookshelf;

import android.graphics.Bitmap;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.ByteArrayOutputStream;

/**
 * Created by spawrks on 2/22/14.
 */
public class FacebookEntity {
    private final String GRAPH_API_URL = "https://graph.facebook.com/user?fields=picture,name";
    private String name;
    private String picture;
    private Bitmap bitmap;

    public FacebookEntity(String id) {

        try {
            HttpClient httpClient = new DefaultHttpClient();
            String queryString = GRAPH_API_URL.replace("user", id);
            HttpResponse httpResponse = httpClient.execute(new HttpGet(queryString));

            StatusLine statusLine = httpResponse.getStatusLine();
            if (statusLine.getStatusCode() == HttpStatus.SC_OK) {
                ByteArrayOutputStream out = new ByteArrayOutputStream();
                httpResponse.getEntity().writeTo(out);
                out.close();
                String responseString = out.toString();

                JSONObject object = (JSONObject) new JSONTokener(responseString).nextValue();

                this.picture = object.getJSONObject("picture")
                                     .getJSONObject("data")
                                     .getString("url");

                this.name = object.getString("name");
            } else {
                httpResponse.getEntity().getContent().close();
            }
        } catch (Exception e) {
        }
    }

    public String getName() {
        return name;
    }

    public String getPicture() {
        return picture;
    }

    public Bitmap getBitmap() {
        return this.bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }
}