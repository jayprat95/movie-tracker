package com.example.movietracker;

import android.widget.TextView;
import android.os.Parcelable;
import android.content.Context;
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
    private String movieString;
    private Parcelable[] movieDataParcelable;
    private ParcelableImplementation movieData;

    private Movie theMovie;

    // ~Fields for Widgets
    private TextView title;
    private TextView plotSimple;
    private TextView type;
    //private TextView title;
    //private TextView title;
    //private TextView title;
    //private TextView title;
    //private TextView title;
    //private TextView title;
    //private TextView title;
    //private TextView title;



    // ~Methods...........................................................



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        assetManager = this.getAssets();
        setContentView(R.layout.detailed_movie_view);

        // Get extra parameter of the movie name.
        currentIntent = getIntent();
        movieString = currentIntent.getStringExtra("movie");
        movieDataParcelable = currentIntent.getParcelableArrayExtra("movieData");

        // ******** Get all data passed in and set Texts.*******

        // New piece of Data: Title
        // Convert movie data to custom parcelable class.
        movieData = (ParcelableImplementation)movieDataParcelable[0];
        title = new TextView(this);
        title = (TextView)findViewById(R.id.title);
        title.setText(movieData.getString());

        // New piece of Data:
        // Convert movie data to custom parcelable class.
        movieData = (ParcelableImplementation)movieDataParcelable[1];
        plotSimple = new TextView(this);
        plotSimple = (TextView)findViewById(R.id.plotSimple);
        plotSimple.setText(movieData.getString());

        // New piece of Data: Title
        // Convert movie data to custom parcelable class.
        movieData = (ParcelableImplementation)movieDataParcelable[2];
        type = new TextView(this);
        type = (TextView)findViewById(R.id.type);
        type.setText(movieData.getString());
    }


}
