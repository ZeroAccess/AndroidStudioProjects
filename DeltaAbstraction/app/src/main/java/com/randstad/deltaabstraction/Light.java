package com.randstad.deltaabstraction;

import android.util.Log;

/**
 * Created by robertsg on 12/11/2014.
 */
public class Light extends Device implements Switchable{

    public Light(){
        setDeviceName("LIGHT");
    }

    @Override
    public void breakDevice() {
        Log.e(getDeviceName(), "Glass Everywhere!....I guess it's not that bad");
    }

    public void turnOn(){
        Log.e(getDeviceName(),"Now I can see. There are my keys");
    }

    public void turnOff(){
        Log.e(getDeviceName(),"Ouch, now it's dark I stubbed my toe!");
    }
}
