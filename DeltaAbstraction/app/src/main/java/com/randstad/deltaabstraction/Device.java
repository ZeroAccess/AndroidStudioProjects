package com.randstad.deltaabstraction;

/**
 * Created by robertsg on 12/11/2014.
 */
public abstract class Device {

    protected String deviceName;
    protected boolean isOn;

    public abstract void breakDevice();

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public boolean isOn() {
        return isOn;
    }

    public void setOn(boolean isOn) {
        this.isOn = isOn;
    }
}
