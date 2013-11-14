package com.example.movietracker;

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
    public JSONObject getJsonFromAssets(String fileName)
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
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    is, "iso-8859-1"), 8);
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            is.close();
            result = sb.toString();
        } catch (Exception e) {
            Log.e("log_tag", "Error converting result " + e.toString());
        }

        try {

            jArray = new JSONObject(result);
        } catch (JSONException e) {
            Log.e("log_tag", "Error parsing data " + e.toString());
        }

        return jArray;

    }

    public void testGetJsonFromAssets() throws JSONException
    {
        JSONObject obj = getJsonFromAssets("drive.json");
        System.out.println(obj.getString("rating_count"));
    }

}
