package com.codeherenow.sicalculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

public class SICalculatorActivity extends Activity implements OnClickListener,
    OnSeekBarChangeListener {
// view
    private EditText principalAmountEditT;
    private EditText interestRateEditT;
    private SeekBar numberOfYearsSeekB;
    private TextView numberOfYearsTextV;
    private Button calcButton;
    private TextView calculationTextV;

// calculation
    private double principalAmount;
    private double interest;
    private int years;
    private StringBuilder sB = new StringBuilder();
    private double result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sicalculator);
// Initializiation
        principalAmountEditT = (EditText) findViewById(R.id.principalAmountEditTextView);
        interestRateEditT = (EditText) findViewById(R.id.interestRateEditTextView);
        numberOfYearsSeekB = (SeekBar) findViewById(R.id.yearsBorrowedSeekBar);
        numberOfYearsSeekB.setMax(30);
        numberOfYearsTextV = (TextView) findViewById(R.id.displayYearsTextView);
        calcButton = (Button) findViewById(R.id.calculateButton);
        calculationTextV = (TextView) findViewById(R.id.totalDisplayTextView);
// Listeners
        calcButton.setOnClickListener(this);
        numberOfYearsSeekB.setOnSeekBarChangeListener(this);
    }
    @Override
    public void onClick(View v) {
        if (v == calcButton) {
// Getting values from textFields for calculation
            updateValuesFromFields();
// calculate
            calculateInterest();
// Update view
            updateUI();
        }
    }
    private void updateUI() {
        String textOnEnd = String.
                format("The interest for $%.0f at rate of %.2f%% for %d year(s) is $%.2f",principalAmount, interest, years, result);
        calculationTextV.setText(textOnEnd);
    }

    private void calculateInterest() {
        result = principalAmount * (interest / 100) * years;
    }

    private void updateValuesFromFields() {
// ensures that the text
        if ((!principalAmountEditT.getText().toString().equals(""))
                && (!interestRateEditT.getText().toString().equals(""))) {
            principalAmount = Double.parseDouble(principalAmountEditT.getText()
                    .toString());
            interest = Double.parseDouble(interestRateEditT.getText()
                    .toString());
        }
    }

    @Override
    public void onProgressChanged(SeekBar arg0, int arg1, boolean arg2) {
        sB.delete(0, sB.length());
        sB.append(arg1);
        sB.append(" Year(s)");
        numberOfYearsTextV.setText(sB.toString());
    }
    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
// TODO Auto-generated method stub
    }
    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        years = numberOfYearsSeekB.getProgress();
    }
}