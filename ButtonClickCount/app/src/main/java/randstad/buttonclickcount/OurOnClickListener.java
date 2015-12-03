package randstad.buttonclickcount;

import android.view.View;

/**
 * Created by robertsg on 2/10/2015.
 */
public class OurOnClickListener implements View.OnClickListener {

    MainActivity caller;
    private int count;

    public OurOnClickListener(MainActivity activity){
        this.caller = activity;
        this.count = 0;
    }

    public void onClick(View view){
        count = count + 1;
        String outPutString = "The Button was clicked " + count + " time";
        if (count != 1){
            outPutString += "s";
        }
        caller.theTextView.setText(outPutString + ".");
    }
}
