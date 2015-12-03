package com.delta.jsonreader;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;


public class ParsingActivity extends Activity {
    ListView mListView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parsing);

        String s = getJSONFile();
        String myDataArray[] = {};

        //
        // Try to parse some JSON and display it in a listview.
        //

        try {
            JSONObject rootJSON = new JSONObject(s);
            JSONArray toppingJSON = rootJSON.getJSONArray("topping");

            myDataArray = new String[toppingJSON.length()];

            for(int i = 0;i < toppingJSON.length(); i++) {
                JSONObject jsonObject = toppingJSON.getJSONObject(i);
                myDataArray[i] = jsonObject.getString("type");
            }

        }catch(JSONException e){
            e.printStackTrace();
        }

        //Now we need to display the array in a ListView

        mListView = (ListView) findViewById(R.id.myListView);
        ArrayAdapter<String> stringAdapter = new ArrayAdapter<String>(getApplicationContext(),R.layout.row,myDataArray);

        if(mListView != null) {
            mListView.setAdapter(stringAdapter);
        }
    }

    //Just a simple helper method to read the file,
    //no need to read this or understand it for this exercise
    public String getJSONFile(){
        String json = null;
        try {

            InputStream is = getResources().openRawResource(R.raw.samplejson);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");

        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.parsing, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
