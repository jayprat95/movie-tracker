package com.example.movietracker;

import android.widget.ImageView;
import java.io.Serializable;
import android.os.Parcel;
import android.content.Context;
import java.util.Arrays;
import android.widget.EditText;
import android.widget.Button;
import android.view.View;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Color;
import java.util.List;
import android.os.Bundle;
import java.util.ArrayList;
import android.app.Activity;


// -------------------------------------------------------------------------
/**
 * This function represents the Main Splash Screen that is seen when a user
 * first executes the application. It sets up 4 buttons which link out to the
 * ListMovieActivity.
 *
 * @author jayanth
 * @version Dec 8, 2013
 */
public class MainMovieActivity
extends Activity
{
    // ~Fields............................................................
    /**
     * this class lets us get files from the assets folder, such as the JSON
     * files that we are using in order to get data about Movies for users
     */
    private AssetManager assetManager;


    // ~Methods...........................................................

    /**
     * This function is called as soon as this activity starts up.
     *
     * @param savedInstanceState
     *            is the instance of the application before this activity starts
     *            up.
     */
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        /**
         * gets the asset manager which allows us to access JSON movie files
         * from the assets folder
         */
        assetManager = this.getAssets();
        // get the view
        setContentView(R.layout.activity_main_movie_view);
        this.setActivityBackgroundColor(Color.BLUE);

        /**
         * search bar is not currently working, we are disabling it for a later
         * release.
         */
        EditText text = (EditText)findViewById(R.id.searchText);
        /**
         * hides the edit text and sets the it so that the edit text can't enter
         * text
         */
        text.setFocusable(false);
        text.setVisibility(View.GONE);
        // Watch buttons for opening up different views.
        setupListeners();

    }


    // ----------------------------------------------------------
    /**
     * This method creates the listeners for the four buttons. They each start a
     * new activity via creating an intent.
     */
    public void setupListeners()
    {

        // gets the button from the view
        Button watched = (Button)findViewById(R.id.watched);
        // creates a listener that listens for a touch on the button
        watched.setOnClickListener(new Button.OnClickListener() {
            @Override
            // function that will execute when watched button is clicked
            public void onClick(View v)
            {
                // executes the ListMovieActivity when this button is clicked
                Intent intent =
                    new Intent(getApplicationContext(),
                        ListMovieActivity.class);
                // tells the ListMovieActivity to use the "watched" list
                intent.putExtra("listname", "watched");
                // starts the ListMovieActivity with the intent that was created
                startActivity(intent);
            }
        });

        // gets the button from the view
        Button toWatch = (Button)findViewById(R.id.toWatch);
        // creates a listener that listens for a touch on the button
        toWatch.setOnClickListener(new Button.OnClickListener() {
            @Override
            // function that will execute when watched button is clicked
            public void onClick(View v)
            {
                // executes the ListMovieActivity when this button is clicked
                Intent intent =
                    new Intent(getApplicationContext(),
                        ListMovieActivity.class);
                // tells the ListMovieActivity to use the "toWatch" list
                intent.putExtra("listname", "toWatch");
                // starts the ListMovieActivity with the intent that was created
                startActivity(intent);
            }
        });
        // gets the button from the view
        Button favorite = (Button)findViewById(R.id.favorite);
        // creates a listener that listens for a touch on the button
        favorite.setOnClickListener(new Button.OnClickListener() {
            @Override
            // function that will execute when watched button is clicked
            public void onClick(View v)
            {
                // executes the ListMovieActivity when this button is clicked
                Intent intent =
                    new Intent(getApplicationContext(),
                        ListMovieActivity.class);
                // tells the ListMovieActivity to use the "favorite" list
                intent.putExtra("listname", "favorite");
                // starts the ListMovieActivity with the intent that was created
                startActivity(intent);
            }
        });
        // gets the button from the view
        Button searchButton = (Button)findViewById(R.id.searchButton);
        // creates a listener that listens for a touch on the button
        searchButton.setOnClickListener(new Button.OnClickListener() {
            @Override
            // function that will execute when watched button is clicked
            public void onClick(View v)
            {
                // executes the ListMovieActivity when this button is clicked
                Intent intent =
                    new Intent(getApplicationContext(),
                        ListMovieActivity.class);
                // tells the ListMovieActivity to use the "searchButton" list
                intent.putExtra("listname", "searchButton");
                // starts the ListMovieActivity with the intent that was created
                startActivity(intent);
            }
        });

    }


    // ----------------------------------------------------------
    /**
     * Sets the background color of an activity
     *
     * @param color
     *            is the color that will be set.
     */
    public void setActivityBackgroundColor(int color)
    {
        // gets the background window of this application
        View view = this.getWindow().getDecorView();
        // sets the color of that background
        view.setBackgroundColor(color);
    }
    

}
