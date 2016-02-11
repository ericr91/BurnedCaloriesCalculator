package com.rossignol.burnedcaloriescalculator;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.TextView.OnEditorActionListener;

public class BurnedCaloriesCalculatorActivity extends AppCompatActivity implements OnEditorActionListener {



    private EditText weight;
    private TextView milesRan;
    private SeekBar milesRanSeek;
    private TextView caloriesBurned;
    private Spinner feet;
    private Spinner inches;
    private TextView bmi;
    private EditText name;
    //private EditText name;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_burned_calories_calculator);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //get references to the widgets
        weight = (EditText) findViewById(R.id.weightEditText);
        milesRan = (TextView) findViewById(R.id.milesRanAmount);
        milesRanSeek = (SeekBar) findViewById(R.id.milesRanSeekBar);
        caloriesBurned = (TextView) findViewById(R.id.caloriesBurnedAmount);
        feet = (Spinner) findViewById(R.id.feetSpinner);
        inches = (Spinner) findViewById(R.id.inchesSpinner);
        bmi = (TextView) findViewById(R.id.bmiAmount);
        name = (EditText) findViewById(R.id.nameEditText);

        //set Listener
        //name.setOnEditorActionListener(this);
        name.setOnEditorActionListener(this);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    /*@Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {

        if(actionId == EditorInfo.IME_ACTION_DONE ||
                actionId == EditorInfo.IME_ACTION_UNSPECIFIED) {

            calculateAndDisplay();

        }

        return false;
    }*/

    private void calculateAndDisplay(){

        float cal;
        float miles;
        float weightAmount;
        float bmiAmount;
        float inchAmount;
        float feetAmount;
        String str;

        miles = milesRanSeek.getProgress();
        milesRan.setText((int) miles);
        str = weight.getText().toString();

        weightAmount = Float.parseFloat(str);

        //weightAmount = Float.parseFloat(weight.getText().toString());

        str = inches.getSelectedItem().toString();
        inchAmount = Float.parseFloat(str);

        str = feet.getSelectedItem().toString();
        feetAmount = Float.parseFloat(str);

        //inchAmount = inches.getSelectedItemPosition() + 1;
        //feetAmount = feet.getSelectedItemPosition() + 1;

        bmiAmount = (weightAmount * 703) / ((12 * feetAmount + inchAmount) * (12 * feetAmount + inchAmount));

        cal = (float) (.75 * weightAmount * bmiAmount);

        bmi.setText((int) bmiAmount);
        caloriesBurned.setText((int) cal);
    }

    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {

        if (actionId == EditorInfo.IME_ACTION_DONE ||
                actionId == EditorInfo.IME_ACTION_UNSPECIFIED) {
            calculateAndDisplay();
        }

        return false;
    }
}
