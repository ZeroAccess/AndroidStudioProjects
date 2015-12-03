package com.randstad.deltaobjects;

import android.util.Log;

/**
 * Created by robertsg on 12/11/2014.
 */
public class Bot {

    public final static String creatorName = "Spawrks";

    private String name = "ROBOT";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    protected void talk(String whatToSay){
        Log.e(getName(), whatToSay);
    }
}
