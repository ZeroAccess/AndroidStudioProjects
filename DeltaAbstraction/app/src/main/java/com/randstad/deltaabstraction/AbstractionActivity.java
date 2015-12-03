package com.randstad.deltaabstraction;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class AbstractionActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abstraction);

        Fan myFan = new Fan();
        Light myLight = new Light();

        myFan.breakDevice();
        myLight.breakDevice();

        Switch mySwitch = new Switch();

        mySwitch.wireUp(myFan);
        mySwitch.wireUp(myLight);

        mySwitch.flipSwitchUp();
        mySwitch.flipSwitchDown();

        mySwitch.unWire(myFan);

        mySwitch.flipSwitchUp();
        mySwitch.flipSwitchDown();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_abstraction, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
