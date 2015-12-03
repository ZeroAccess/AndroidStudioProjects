package com.delta.persistence;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class PersistenceActivity extends Activity {


    TextView readingView;
    TextView appRestartsView;

    private int howManyTimesBeenRun = 0;
    private static final String NUMBER_OF_TIMES_RUN_KEY = "NUMBER_OF_TIMES_RUN_KEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_persistence);

        readingView = (TextView) findViewById(R.id.displayView);
        appRestartsView = (TextView) findViewById(R.id.applicationRestarts);

        SharedPreferences sharedPreferences = getPreferences(Context.MODE_PRIVATE);

        //read
        int defaultValue = 0;
        howManyTimesBeenRun = sharedPreferences.getInt(NUMBER_OF_TIMES_RUN_KEY,defaultValue);

        //first time message
        if(howManyTimesBeenRun == 0) {
            Toast.makeText(this,"Welcome to your new magic notepad!", Toast.LENGTH_LONG).show();
        }
        howManyTimesBeenRun++;

        //write
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(NUMBER_OF_TIMES_RUN_KEY,howManyTimesBeenRun);
        editor.commit();

        appRestartsView.setText(String.valueOf(howManyTimesBeenRun));

    }

    @Override
    protected void onPause() {
        super.onPause();
        saveTextFile(readingView.getText().toString());
    }

    @Override
    protected void onResume() {
        super.onResume();
        readingView.setText(getTextFile());
    }

    private static final String DATA_FILE ="my file";

    //Reading and Writing

    public String getTextFile() {

        FileInputStream fileInputStream = null;
        String fileData = null;

        try{
            fileInputStream = openFileInput(DATA_FILE);
            int size = fileInputStream.available();
            byte[] buffer = new byte[size];
            fileInputStream.read(buffer);
            fileInputStream.close();
            fileData = new String(buffer,"UTF-8");
        }catch (FileNotFoundException e){
            Log.e("FILE","Couldn't find that file");
        }catch(IOException e){
            Log.e("FILE","Error");
            e.printStackTrace();
        }finally{
            try{
                if(fileInputStream != null){
                    fileInputStream.close();
                }
            }catch(IOException e){
                e.printStackTrace();
            }
        }
        return fileData;
    }

    public void saveTextFile(String content) {

        FileOutputStream fileOutputStream = null;

        try{
            fileOutputStream = openFileOutput(DATA_FILE,Context.MODE_PRIVATE);
            fileOutputStream.write(content.getBytes());
        }catch (FileNotFoundException e){
            Log.e("FILE","Couldn't find that file");
        }catch(IOException e){
            Log.e("FILE","IO Error");
            e.printStackTrace();
        }finally{
            try{
                if(fileOutputStream != null){
                    fileOutputStream.close();
                }
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.persistence, menu);
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
