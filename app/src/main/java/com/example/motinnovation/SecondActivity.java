package com.example.motinnovation;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.ImageView;
import java.util.ArrayList;
import java.util.Random;
import android.os.Bundle;
import android.content.Intent;
import android.widget.TextView;
import android.view.View;

public class SecondActivity extends AppCompatActivity {

    String categoryCapital;
    String categoryLowerCase;
    ImageView imageView_motivation;
    ArrayList<Integer> list;
    Random random;
    int index;
    int imageNum;
    String imageName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // TEXT_VIEW

        Intent caller = getIntent();
        categoryCapital = caller.getStringExtra("category");
        categoryLowerCase = categoryCapital.toLowerCase();
        TextView textView_categoryCurrent = (TextView) findViewById(R.id.textView_categoryCurrent);
        textView_categoryCurrent.setText("Current category: " + categoryCapital);

        // ^this chunk of code retrieves the string passed on by the Intent that triggered this
        // activity, and sets the TextView to display this string as the current category.


        // IMAGE_VIEW

        imageView_motivation = (ImageView) findViewById(R.id.imageView_motivation);
        int size = 5;
        list = new ArrayList<>(size);
        for (int i = 1; i <= size; i++) {
            list.add(i);
        }
        random = new Random();
        getQuote();

        // ^this chunk of code creates an ArrayList of integers 1 through 'size' inclusive, creates
        // a new Random object, and calls the getQuote() method.
    }

    // GET_QUOTE METHOD

    public void getQuote(){
        index = random.nextInt(list.size());
        imageNum = list.remove(index);
        imageName = categoryLowerCase + imageNum;
        imageView_motivation.setImageResource(getResources().getIdentifier(imageName,
                "drawable", getPackageName()));
    }

    // ^the getQuote() method removes a random integer from the ArrayList and assigns it to
    // 'imageNum', then concatenates the string of the current category name (all lowercase) with
    // imageNum to get the filename of the quote to display.


    // ANOTHER_QUOTE METHOD

    public void anotherQuote(View v){
        if (list.size() > 0) {
            getQuote();
        } else {
            imageView_motivation.setImageResource(R.drawable.nomorequotes);
        }
    }

    // ^this is the onClick method of the button_anotherQuote, which calls the getQuote() method if
    // there are still integers in the ArrayList (i.e. there are still unseen quotes in the current
    // category), else displays an image saying 'no more quotes'.


    // CATEGORY_CHANGE METHOD

    public void categoryChange(View v){
        finish();
    }

    // ^this is the onClick method of the button_categoryChange, which simply calls the finish()
    // method on the current activity to return to the previous activity.
}