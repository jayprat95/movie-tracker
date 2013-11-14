package com.example.movietracker;

import java.io.UnsupportedEncodingException;
import android.content.res.AssetManager;
import java.io.File;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.io.InputStreamReader;
import android.util.JsonReader;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import java.io.*;


import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ListView;

// -------------------------------------------------------------------------
/**
 *  Write a one-sentence summary of your class here.
 *  Follow it with additional details about its purpose, what abstraction
 *  it represents, and how to use it.
 *
 *  @author jayanth
 *  @version Nov 14, 2013
 */
public class MainMovieView extends Activity
{

    JSONObject jsonObject;
    InputStream is = null;
    String result = "";
    JSONObject jArray = null;
    AssetManager assetManager;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        assetManager = getAssets();
        try
        {
            testGetJsonFromAssets();
        }
        catch (JSONException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        setContentView(R.layout.activity_main_movie_view);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_movie_view, menu);
        return true;
    }




    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     * @param fileName
     * @return
     */
    public Movie getJsonFromAssets(String fileName)
    {
        try
        {
            is = assetManager.open(fileName);
        }
        catch (IOException e1)
        {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        JsonReader reader = null;
        try
        {
            reader = new JsonReader(new InputStreamReader(is, "UTF-8"));
        }
        catch (UnsupportedEncodingException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        Movie drive = null;
        try
        {
           drive  = readMovie(reader);
        }
        catch (IOException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println(drive.getRating() + "");
        System.out.println(drive.getRatingCount() + "");
        return drive;

    }

    public Movie readMovie(JsonReader reader) throws IOException {
        int rating = 0;
        int ratingCount = 0;
        Movie movie = new Movie();
        reader.beginObject();
        while (reader.hasNext()) {
          String name = reader.nextName();
          if (name.equals("rating_count")) {
            ratingCount = reader.nextInt();
          } else if (name.equals("rating")) {
            rating = reader.nextInt();

          } else {
            reader.skipValue();
          }
        }
        reader.endObject();
        movie.setRating(rating);
        movie.setRatingCount(ratingCount);
        return movie;
      }

    public void testGetJsonFromAssets() throws JSONException
    {
        Movie movie = getJsonFromAssets("drive.json");

    }


}
