package com.delta.activitylifecycle;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class LifecycleActivity extends Activity {

    String status = "";
    int order = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lifecycle);

        status = "Activity Created";
        displayStatus();
    }

    @Override
    protected void onStart() {
        //activity resumed
        super.onStart();
        status = "Activity Started";
        displayStatus();
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        //restoring instance state
        super.onRestoreInstanceState(savedInstanceState);
        status = "Restoring Instance";
        displayStatus();

    }

    @Override
    protected void onResume() {
        //activity resumed
        super.onResume();
        status = "Activity Resumed";
        displayStatus();
    }

    @Override
    protected void onPause() {
        //activity paused
        super.onPause();
        status = "Activity Paused";
        displayStatus();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        //saving instance state
        super.onSaveInstanceState(outState);
        status = "Saving Instance";
        displayStatus();

    }

    @Override
    protected void onStop() {
        //activity stopped
        super.onStop();
        status = "Activity Stopped";
        displayStatus();
    }

    @Override
    protected void onDestroy() {
        //activity destroyed
        super.onDestroy();
        status = "Activity Destroyed";
        displayStatus();
    }

    @Override
    protected void onRestart() {
        //activity destroyed
        super.onRestart();
        status = "Activity Restarted";
        displayStatus();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.lifecycle, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            case R.id.action_settings:
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void displayStatus(){
        order++;
        String message = String.valueOf(order) + ": " + status;
        //t.setText(status);
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

}
