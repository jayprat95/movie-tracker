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

public class MainMovieActivity
    extends Activity
{
    // ~Fields............................................................
    private AssetManager assetManager;

    // ~Methods...........................................................

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        assetManager = this.getAssets();
        setContentView(R.layout.activity_main_movie_view);
        this.setActivityBackgroundColor(Color.BLUE);


        EditText text = (EditText)findViewById(R.id.searchText);

        text.setFocusable(false);
        text.setVisibility(View.GONE);
        // Watch buttons for opening up different views.
        setupListeners();

    }

    // ----------------------------------------------------------
    /**
     * This method creates the listeners for the four buttons. They each
     * start a new activity via creating an intent.
     */
    public void setupListeners() {

        Button watched = (Button)findViewById(R.id.watched);
        watched.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent =
                    new Intent(
                        getApplicationContext(),
                        ListMovieActivity.class);
                intent.putExtra("listname", "watched");
                startActivity(intent);
            }
        });

        Button toWatch = (Button)findViewById(R.id.toWatch);
        toWatch.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent =
                    new Intent(
                        getApplicationContext(),
                        ListMovieActivity.class);
                intent.putExtra("listname", "toWatch");
                startActivity(intent);
            }
        });

        Button favorite = (Button)findViewById(R.id.favorite);
        favorite.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent =
                    new Intent(
                        getApplicationContext(),
                        ListMovieActivity.class);
                intent.putExtra("listname", "favorite");
                startActivity(intent);
            }
        });

        Button searchButton = (Button)findViewById(R.id.searchButton);
        searchButton.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent =
                    new Intent(
                        getApplicationContext(),
                        ListMovieActivity.class);
                intent.putExtra("listname", "searchButton");
                startActivity(intent);
            }
        });


    }
    
    public void setActivityBackgroundColor(int color) {
        View view = this.getWindow().getDecorView();
        view.setBackgroundColor (color);
    }

}
