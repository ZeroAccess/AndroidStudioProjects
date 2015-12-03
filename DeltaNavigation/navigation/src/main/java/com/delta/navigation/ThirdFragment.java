package com.delta.navigation;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by learnovate on 4/11/14.
 */
public class ThirdFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.third_fragment, container, false);
        TextView textView = (TextView) rootView.findViewById(R.id.fragmentName);
        textView.setText("Third Fragment");

        rootView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    Toast.makeText(getActivity(),"Finger Up", Toast.LENGTH_SHORT).show();
                    return true;
                }

                if(motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    Toast.makeText(getActivity(),"Finger Down", Toast.LENGTH_SHORT).show();
                    return true;
                }
                return false;
            }
        });

        return rootView;

    }
}
