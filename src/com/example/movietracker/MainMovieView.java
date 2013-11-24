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


    // Widget Fields
    private TextView titleText;
    private TextView directorsText;
    private EditText searchField;
    private Button search;




    // ~Methods............................................................

    public void initialize() {
        list = new ArrayList<Movie>();
        titles = new ArrayList<String>();

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

        for (String movieFile : files) {
            if (movieFile != null) {
                // Make a movie object then run get JSON fields.
                Movie newMovie = getJsonFromAssets(movieFile);
                list.add(newMovie);
                titles.add(newMovie.getTitle());
            }
        }

    }



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
     * @return movie The movie created from file name passed in
     */
    public Movie getJsonFromAssets(String fileName)
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

        // Print out desired topics from json file
        System.out.println(response[0].getRating());
        System.out.println(response[0].getRatingCount());
        System.out.println(response[0].getSimplePlot());
        System.out.println(response[0].getDirectors()[0]);
        System.out.println(response[0].getTitle());
        System.out.println(response[0].getActors()[0]);
        System.out.println(response[0].getPoster().get("imdb"));
        System.out.println(response[0].getRuntime()[0]);
        System.out.println(response[0].getType());
        System.out.println(response[0].getImdb_url());
        System.out.println(response[0].getRelease_date());

        // return new movie created.
        return response[0];
    }


    public void testGetJsonFromAssets() throws JSONException
    {
        getJsonFromAssets("drive.json");
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
