package com.randstad.deltaabstraction;

import android.util.Log;

/**
 * Created by robertsg on 12/11/2014.
 */
public class Fan extends Device implements Switchable{

    public Fan(){
        setDeviceName("FAN");
    }

    public void breakDevice(){
        Log.e(getDeviceName(), "BANG, CRASH! ... oops");
    }

    public void turnOn(){
        Log.e(getDeviceName(),"whooooooooooooooooosh");
    }

    public void turnOff(){
        Log.e(getDeviceName(),"darn, now it's hot and stuffy in here");
    }
}
