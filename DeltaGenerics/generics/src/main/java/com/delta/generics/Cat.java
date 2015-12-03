package com.delta.generics;

import android.app.Activity;
import android.util.Log;

import java.lang.reflect.Field;

/**
 * Created by learnovate on 2/25/14.
 */
public class Cat implements Animal,Adoptable {


    public static final int MAX_SHELTER_DAYS = 30;

    private String whatYouCallYourCat = "";
    private String shelterDescription = "";
    private String catPic = "";

    private int daysAtShelter = 1;
    private String phoneNumber = "";

    public Cat(String aName, String aDescription, String anImageName, int aDaysAtShelter) {
        this.whatYouCallYourCat = aName;
        this.shelterDescription = aDescription;
        this.catPic = anImageName;
        this.daysAtShelter = aDaysAtShelter;
    }

    @Override
    public int getRating() {
        int rating = 5 * daysAtShelter / MAX_SHELTER_DAYS;
        return rating;
    }

    @Override
    public String getNumber() {
        //All cat adoptions go through one number
        return "+1-202-555-0171";
    }

    @Override
    public String getName() {
        return whatYouCallYourCat;
    }

    @Override
    public String getImageName() {
        return catPic;
    }

    @Override
    public String getDescription() {
        return shelterDescription;
    }

    @Override
    public int getImageResourceId(Activity a) {

        int drawableId = 0;
        try {
            Class res = R.drawable.class;
            Field field = res.getField(getImageName());
            drawableId= field.getInt(null);
        }
        catch (Exception e) {
            Log.e("MyTag", "Failure to get drawable id.", e);
        }
        return drawableId;
    }
}
