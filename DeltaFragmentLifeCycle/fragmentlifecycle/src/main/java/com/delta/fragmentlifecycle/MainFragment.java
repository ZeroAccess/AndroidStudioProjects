package com.delta.fragmentlifecycle;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

/**
 * Created by learnovate on 3/27/14.
 */
public class MainFragment extends Fragment {

    String status = "";
    int order = 0;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        status = "Fragment Attached";
        displayStatus();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        status = "Fragment Created";
        displayStatus();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        status = "Fragment Create View";
        displayStatus();
        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        status = "Fragment View Created";
        displayStatus();
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        status = "Fragment Activity Created";
        displayStatus();
    }

    @Override
    public void onStart() {
        super.onStart();
        status = "Fragment Started";
        displayStatus();
    }

    @Override
    public void onViewStateRestored(Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        status = "Fragment State Restored";
        displayStatus();

    }

    @Override
    public void onResume() {
        super.onResume();
        status = "Fragment Resumed";
        displayStatus();
    }


    @Override
    public void onPause() {
        super.onPause();
        status = "Fragment Paused";
        displayStatus();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        status = "Fragment Saving State";
        displayStatus();
    }

    @Override
    public void onStop() {
        super.onStop();
        status = "Fragment Stopped";
        displayStatus();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        status = "Fragment View Destroyed";
        displayStatus();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        status = "Fragment Destroyed";
        displayStatus();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        status = "Fragment Detached";
        displayStatus();
    }

    public void displayStatus(){
        order++;
        String message = String.valueOf(order) + ": " + status;
        View v = getView();
        if(v != null){
            message = message + " [+View]";
        }
        //t.setText(status);
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }



}
