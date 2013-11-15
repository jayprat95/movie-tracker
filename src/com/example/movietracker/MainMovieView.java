package com.example.movietracker;

import com.google.gson.Gson;
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
import java.util.*;


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
        assetManager = this.getAssets();
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
    public void getJsonFromAssets(String fileName)
    {
        // Create stream and reader for parsing.
        BufferedReader reader = null;
        InputStream inputStream = null;

        // Try to open a stream from the specified file
        try
        {
            inputStream = assetManager.open(fileName);
        }
        catch (IOException e1)
        {
            System.out.println("cannot open drive.json");
            e1.printStackTrace();
        }

        // Try to create the reader from the open stream to the file.
        try
        {
            reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
        }
        catch (UnsupportedEncodingException e)
        {
            System.out.println("cannot create bufferedReader from input stream");
            e.printStackTrace();
        }

        // Create Gson object to parse JSON.
        Gson gson = new Gson();

        // Parse JSON into a Movie Array. **This is an array of one** "Tricky"
        Movie[] response = gson.fromJson(reader, Movie[].class);

        System.out.println(response[0].getRating());
        System.out.println(response[0].getRatingCount());
        System.out.println(response[0].getSimplePlot());
        //System.out.println(response[0].getDirector());
        //System.out.println(response[0].getTitle());
        //System.out.println(response[0].getActor());
        //System.out.println(response[0].getLinkUrl());
        //System.out.println(response[0].getImgUrl());

    }


    public void testGetJsonFromAssets() throws JSONException
    {
        getJsonFromAssets("drive.json");

    }

}
