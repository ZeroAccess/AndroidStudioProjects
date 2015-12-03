package com.delta.activities;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by robertsg on 12/19/2014.
 */
public class SecondActivity extends Activity {

    public static final int DETAIL_REQUEST = 1;

    private Button mButton = null;
    private Button mDetailButton = null;
    private TextView mSelectedView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        mSelectedView = (TextView) findViewById(R.id.userSelection);

        mButton = (Button) findViewById(R.id.goFirstActivty);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(),FirstActivity.class);
                startActivity(i);
            }
        });


        mDetailButton = (Button) findViewById(R.id.goDetailActivity);
        mDetailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(),DetailActivity.class);
                i.putExtra("KeyForSending","Some data from SecondActivity");
                startActivityForResult(i,DETAIL_REQUEST);

            }
        });

        //Becoming an implicient Intent receiver here
        Intent httpIntent = getIntent();
        String action = httpIntent.getAction();
        if(action != null && action.equals(Intent.ACTION_VIEW)) {
            Uri data = httpIntent.getData();
            if(data != null) {
                mSelectedView.setText(data.toString());
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK && requestCode == DETAIL_REQUEST) {
            if(data.hasExtra("KeyForReturning")) {
                String myValue = data.getExtras().getString("KeyForReturning");
                mSelectedView.setText(myValue);
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.first, menu);
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
