package com.example.boxchangecolor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    // Current background color
    private int mColor;
    // Text view to display both count and color
    private TextView mShowCountTextView;

    // Key for current color
    private final String COLOR_KEY = "color";

    // Shared preferences object
    private SharedPreferences mPreferences;

    // Name of shared preferences file
    private String sharedPrefFile =
            "com.example.android.hellosharedprefs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views, color, preferences
        mShowCountTextView = findViewById(R.id.count_textview);
        mColor = ContextCompat.getColor( this,
                                         R.color.default_background);

        mPreferences = getSharedPreferences(sharedPrefFile, MODE_PRIVATE);

        // Restore preferences
        mColor = mPreferences.getInt(COLOR_KEY, mColor);
        mShowCountTextView.setBackgroundColor(mColor);
        /*final CountDownTimer countDownTimer = new CountDownTimer(60000, 1000)
        {

            public void onTick(long millisUntilFinished) {
                x = millisUntilFinished/1000;
                if ( 5< x ){
                    mShowCountTextView.setBackgroundColor(Color.parseColor("#32e76b"));

                }
                else{
                    mShowCountTextView.setBackgroundColor(Color.parseColor("FFE9DD33"));

                }*/

        /*new CountDownTimer(5000, 50) {

            @Override
            public void onTick(long arg0) {
                // TODO Auto-generated method stub
            }
            @Override
            public void onFinish() {
                mShowCountTextView.setBackgroundColor(Color.RED);
            }
        }.start();*/

        /*mShowCountTextView.postDelayed(new Runnable() {
            @Override
            public void run() {
                mShowCountTextView.setBackgroundColor( Color.GREEN);
            }
        }, 5000);*/
    }
    /**
     * Handles the onClick for the background color buttons.  Gets background
     * color of the button that was clicked, and sets the TextView background
     * to that color.
     *
     * @param view The view (Button) that was clicked.
     */
    public void changeBackground(View view) {

        //int color = ((ColorDrawable) view.getBackground()).getColor();
        //mShowCountTextView.setBackgroundColor(Color.parseColor("#32e76b"));
        //mColor = Color.parseColor("#32e76b");

        new CountDownTimer(5000, 1000) {

            @Override
            public void onTick(long arg0) {
                // TODO Auto-generated method stub
            }
            @Override
            public void onFinish() {
                mShowCountTextView.setBackgroundColor(Color.parseColor("#32e76b"));
            }
        }.start();

    }

    /**
     * Handles the onClick for the Reset button.  Resets the global count and
     * background variables to the defaults and resets the views to those
     * default values.
     *
     * @param view The view (Button) that was clicked.
     */
    @SuppressLint("ResourceAsColor")
    public void reset(View view) {

        // Reset color
        mColor = ContextCompat.getColor(this,
                                        R.color.default_background);
        mShowCountTextView.setBackgroundColor(mColor);

        // Clear preferences
        SharedPreferences.Editor preferencesEditor = mPreferences.edit();
        preferencesEditor.clear();
        preferencesEditor.apply();
    }
}