package com.delta.generics;

import android.app.Activity;
import android.util.Log;

/**
 * Created by learnovate on 2/25/14.
 */

public class Dog implements Adoptable,Animal{

    private String dogName = "";
    private String ownersDescription = "";
    private String imageName = "";
    private int Rating;
    private String phoneNumber = "";

    public Dog(String aName, String aDesc, String anImageName, String aPhoneNumber){
        dogName = aName;
        ownersDescription = aDesc;
        imageName = anImageName;
        phoneNumber = aPhoneNumber;
    }

    @Override
    public int getRating() {
        return 9; //all dogs are awesome
    }

    @Override
    public String getNumber() {
       return phoneNumber;
    }

    @Override
    public String getDescription() {
        return ownersDescription;
    }

    @Override
    public String getName() {
        return dogName;
    }

    @Override
    public String getImageName() {
        return imageName;
    }

    @Override
    public int getImageResourceId(Activity anActivity) {
        int resID = anActivity.getResources().getIdentifier(getImageName(), "drawable", anActivity.getPackageName());
        return resID;
    }

    public int getNumberOfBallsICanCatch(){
        return 5;
    }

    public void beTheBestDogEver(){
        for(int i = 0; i < 1000;i++){
            Log.e("DOG", getName() + "says Woof!");
        }
    }


}
