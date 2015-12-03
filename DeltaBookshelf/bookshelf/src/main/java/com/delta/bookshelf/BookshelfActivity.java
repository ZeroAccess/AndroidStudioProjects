package com.delta.bookshelf;

import android.app.Activity;
import android.app.ListActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;

/*

Originally inspired by Dmytro Titov's demo on GitHub:

https://github.com/dtitov/SpinList
 */
public class BookshelfActivity extends ListActivity {


    ArrayList<String> entitiesToDisplay = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //sample data
        entitiesToDisplay.add("startrek");
        entitiesToDisplay.add("thegreatgatsby");
        entitiesToDisplay.add("goodnightmoonbook");
        entitiesToDisplay.add("afarewelltoarms");
        entitiesToDisplay.add("atlasshrugged");
        entitiesToDisplay.add("schwem");
        entitiesToDisplay.add("thedeltaprogram");
        entitiesToDisplay.add("adamlupu");
        entitiesToDisplay.add("YETspaceATX");
        entitiesToDisplay.add("Philosophical-Investigations");
        entitiesToDisplay.add("A-Light-in-the-Attic");
        entitiesToDisplay.add("adventuretime");
        entitiesToDisplay.add("The-Power-of-Myth");
        entitiesToDisplay.add("Cryptonomicon");
        entitiesToDisplay.add("SweetRitual");
        entitiesToDisplay.add("ChicagoBears");
        entitiesToDisplay.add("androidislife");
        entitiesToDisplay.add("theiliad");

        ListView l = getListView();
        l.setBackgroundColor(Color.argb(200,34,119,147));

        //display it
        LazyAdapter lazyAdapter = new LazyAdapter(this, entitiesToDisplay);
        setListAdapter(lazyAdapter);





    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.bookshelf, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
