package com.delta.navigation;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by learnovate on 4/11/14.
 */
public class FirstFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.first_fragment,container,false);
        TextView textView = (TextView) rootView.findViewById(R.id.fragmentName);
        textView.setText("First Fragment");

        return rootView;
    }
}
