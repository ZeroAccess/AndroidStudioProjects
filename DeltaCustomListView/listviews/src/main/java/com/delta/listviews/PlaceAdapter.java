package com.delta.listviews;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by robertsg on 12/29/2014.
 */
public class PlaceAdapter extends ArrayAdapter<Place> {

    Context mContext;
    int mLayoutResourceId;
    Place mData[] = null;

    public PlaceAdapter(Context context, int resource, Place[] data) {
        super(context, resource, data);
        this.mContext = context;
        this.mLayoutResourceId = resource;
        this.mData = data;
    }


    @Override
    public Place getItem(int position) {
        return super.getItem(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        //inflate the layout for a single row
        LayoutInflater inflater = LayoutInflater.from(mContext);
        row = inflater.inflate(mLayoutResourceId, parent, false);

        //get a reference to the different view elements we wish to update
        TextView nameView = (TextView) row.findViewById(R.id.nameTextView);
        TextView zipView = (TextView) row.findViewById(R.id.zipcodeTextView);
        ImageView imageView = (ImageView) row.findViewById(R.id.imageView);

        //get the data from the data array
        Place place = mData[position];

        //setting the view to reflect the data we need to display
        nameView.setText(place.mNameOfPlace);
        zipView.setText(String.valueOf(place.mZipCode)); //always pay attention to your datatypes!

        int resId = mContext.getResources().getIdentifier(place.mNameOfImage,"drawable",mContext.getPackageName());
        imageView.setImageResource(resId);

        //returning the row view (because this is called getView after all)
        return row;

    }
}

