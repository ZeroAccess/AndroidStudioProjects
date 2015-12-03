package com.randstad.deltaabstraction;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by robertsg on 12/11/2014.
 */
public class Switch {

    private List<Switchable> switchableItems = new ArrayList<Switchable>();

    public void wireUp(Switchable thing){
        switchableItems.add(thing);
    }

    public void unWire(Switchable thing){
        switchableItems.remove(thing);
    }

    public void flipSwitchUp(){
        for(Switchable thing:switchableItems){
            thing.turnOn();
        }
    }

    public void flipSwitchDown(){
        for(Switchable thing:switchableItems){
            thing.turnOff();
        }
    }
}
