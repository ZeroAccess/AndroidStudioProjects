package com.delta.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.app.ListFragment;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by robertsg on 12/30/2014.
 */
public class HeadlinesFragment extends ListFragment {

    OnHeadlineSelectedListener callback;

    public interface OnHeadlineSelectedListener {
        public void onArticleSelected(int position);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        //Make sure that the container Activity has implemented
        //the interface. If not, throw an exception so we can fix it
        try {
            callback = (OnHeadlineSelectedListener) activity;
        } catch(ClassCastException e) {
            throw new ClassCastException(activity.toString() + "must implement OnHeadlineSelectedListener");
        }
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        int layout = android.R.layout.simple_list_item_activated_1; //not available before honeycomb
        String[] data = Ipsum.Headlines;

        setListAdapter(new ArrayAdapter<String>(getActivity(), layout, data));
    }

    @Override
    public void onStart() {
        super.onStart();

        //When in a two-pane layout, set the lightview to highlight the list item
        //instead of just simply blinking

        Fragment f = getFragmentManager().findFragmentById(R.id.article_fragment);
        ListView v = getListView();
        if(f != null && v != null) {
            v.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        }
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        //Notify the parent of the selected item
        callback.onArticleSelected(position);

        //again set the item to be highlighted in a two-pane layout
        l.setItemChecked(position,true);
    }
}
