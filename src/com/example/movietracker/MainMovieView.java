package com.example.movietracker;

import android.support.v4.widget.DrawerLayout;
import android.widget.*;
import java.util.*;
import android.content.res.AssetManager;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

// -------------------------------------------------------------------------
/**
 *  This is the main view class.
 *  It also contains a parser that pull from json files in assets.
 *
 *  @author jayanthprathipati
 *  @author oliverebeling-koning
 *  @author linsayboylan
 *  @version Nov 15, 2013
 */




public class MainMovieView extends Activity
{
    // ~Fields............................................................
    private AssetManager assetManager;

    private List<Movie> movies;

    private Parser parser;

    // Widget Fields
    private TextView titleText;
    private TextView directorsText;
    private EditText searchField;
    private Button search;


    // Testing menu fields
    private String[] mPlanetTitles;
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;



    // ~Methods............................................................

    public void initialize() {
        movies = new ArrayList<Movie>();

        System.out.println("Generating parser and parsing...");
        parser = new Parser(assetManager);
        movies = parser.getMovies();
    }



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        assetManager = this.getAssets();
        setContentView(R.layout.activity_main_movie_view);
        this.initialize();


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_movie_view, menu);
        return true;
    }






    // Widget Methods............................................
/*
    public void searchClicked() {
        System.out.println("clicked Search");
        this.searchFieldEditingDone();
    }

    public void searchFieldEditingDone() {
        System.out.println("Done Editing");
        Boolean contained = false;
        for (String title : this.titles) {
            if (searchField.getText().toString().equals(title)) {
                // successful search for title.
                contained = true;
                System.out.println("Found movie after entering search");
            }
        }

        Boolean notSet = true;
        for (int ii = 0; ii < list.size(); ii++) {
            String currentTitle = searchField.getText().toString();
            if (list.get(ii).getTitle().equals(currentTitle)) {
                System.out.println("Updating movie texts");
                titleText.setText(list.get(ii).getTitle());
                directorsText.setText(list.get(ii).getDirectors()[0] + ", " + list.get(ii).getDirectors()[1]);
                break;
            }
        }
    }
    */

}
