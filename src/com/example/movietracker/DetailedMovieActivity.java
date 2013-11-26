package com.example.movietracker;

import android.content.Intent;
import android.content.res.AssetManager;
import java.util.List;
import android.os.Bundle;
import java.util.ArrayList;
import android.app.Activity;

public class DetailedMovieActivity extends Activity
{
    // ~Fields............................................................
    private AssetManager assetManager;

    private Intent currentIntent;
    private String movie;


    // ~Methods...........................................................



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        assetManager = this.getAssets();
        setContentView(R.layout.detailed_movie_view);

        // Get extra parameter of the movie name.
        currentIntent = getIntent();
        movie = currentIntent.getStringExtra("movie");

    }
}
