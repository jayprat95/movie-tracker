package com.example.movietracker;

import java.io.IOException;
import java.util.ArrayList;
import java.io.InputStreamReader;
import android.util.JsonReader;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class MainMovieView
    extends Activity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        try
        {
            testMovieJsonReader();
        }
        catch (IOException e)
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
     *
     * @throws IOException
     */
    public void testMovieJsonReader()
        throws IOException
    {
        MovieJsonReader test = new MovieJsonReader();

        JsonReader reader =
            new JsonReader(new InputStreamReader(
                getAssets().open("drive.json"),
                "UTF-8"));
        try
        {
            ArrayList<Movie> list = test.getMovieFromStream(reader);
            Movie i = list.get(0);
            System.out.println(i.getActor());

        }
        finally
        {
            reader.close();
        }
    }

}
