package com.delta.navigation;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by learnovate on 4/11/14.
 */
public class SecondFragment extends Fragment {

    private TextView coordinateView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.second_fragment, container, false);
        TextView textView = (TextView) rootView.findViewById(R.id.fragmentName);
        textView.setText("Second Fragment");

        coordinateView = (TextView) rootView.findViewById(R.id.coordinates);
        rootView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                if(motionEvent.getAction() == MotionEvent.ACTION_MOVE) {
                    String xCoord = String.valueOf(motionEvent.getX());
                    String yCoord = String.valueOf(motionEvent.getY());
                    coordinateView.setText("Finger X:" + xCoord + " Y:" + yCoord);

                    return true;
                }
                return true; //must switch to true from false get a move events
            }
        });

        return rootView;

    }
}
