package com.example.motinnovation;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.NumberPicker;
import android.view.View;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    NumberPicker numberPicker_categorySelect;
    String[] strings_categories = {
            "General",
            "Health",
            "Skills",
            "Career"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // NUMBER_PICKER

        numberPicker_categorySelect = (NumberPicker) findViewById(R.id.numberPicker_categorySelect);
        numberPicker_categorySelect.setDisplayedValues(strings_categories);
        numberPicker_categorySelect.setMinValue(0);
        numberPicker_categorySelect.setMaxValue(strings_categories.length - 1);

        // ^this chunk of code creates an array of strings to hold the category names, sets the
        // displayed values of the NumberPicker to the strings held in this array, and sets the min
        // and max values of the NumberPicker relative to the length of the array, so that the
        // number of categories can be easily changed.
    }

    // CATEGORY_CONFIRM METHOD

    public void categoryConfirm(View v) {
        int categoryCode = numberPicker_categorySelect.getValue();
        String category = strings_categories[categoryCode];
        Intent goToSecond = new Intent();
        goToSecond.setClass(this, SecondActivity.class);
        goToSecond.putExtra("category", category);
        startActivity(goToSecond);
    }

    // ^this is the onClick method of the button_categoryConfirm, which retrieves a string
    // corresponding to the category selected on the NumberPicker, utilises an Intent to go to the
    // second activity, and passes the category selected on to this new activity.
}