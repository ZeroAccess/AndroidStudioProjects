package com.delta.generics;

import android.app.Activity;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

/**
 * Created by learnovate on 2/25/14.
 */
public class CatAdapter {

    private Activity activity;
    private TextView name;
    private TextView description;
    private RatingBar ratingBar;
    private ImageView imageView;

    private Cat t;

    public CatAdapter(Activity aActivity, TextView aName, TextView aDescription, RatingBar aBar, ImageView aImageView){
        this.activity = aActivity;
        this.name = aName;
        this.description = aDescription;
        this.ratingBar = aBar;
        this.imageView = aImageView;
    }

    public void set(Cat t) {
        this.t = t;
        updateView();
    }

    public Cat get() {
        return t;
    }

    private void updateView(){
        int resID = t.getImageResourceId(activity);
        imageView.setImageResource(resID);
        name.setText(t.getName());
        description.setText(t.getDescription());
        ratingBar.setNumStars(5);
        ratingBar.setRating(t.getRating());
    }
}
