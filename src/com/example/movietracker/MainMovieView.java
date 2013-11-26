package com.example.movietracker;

import com.google.gson.Gson;
import android.widget.*;
import java.util.*;
import java.io.UnsupportedEncodingException;
import android.content.res.AssetManager;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

import org.json.JSONException;
import org.json.JSONObject;

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

    private List<Movie> list;
    private List<String> titles;

    private Parser parser;

    // Widget Fields
    private TextView titleText;
    private TextView directorsText;
    private EditText searchField;
    private Button search;




    // ~Methods............................................................

    public void initialize() {
        list = new ArrayList<Movie>();
        titles = new ArrayList<String>();

        System.out.println("Generating parser");
        parser = new Parser(assetManager);

        // load all movies from assets
        String[] files = null;
        try {
            files = assetManager.list("file:///android_asset");
        }
        catch (IOException exception) {
            // No Files Located In Assets
            System.out.println("No Files Located In Assets");
            exception.printStackTrace();
        }

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

}
