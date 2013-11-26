package com.example.movietracker;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.io.IOException;
import android.content.res.AssetManager;
import java.util.*;

// -------------------------------------------------------------------------
/**
 * Write a one-sentence summary of your class here. Follow it with additional
 * details about its purpose, what abstraction it represents, and how to use it.
 *
 * @author jayanthprathipati
 * @author oliverebeling-koning
 * @author linsayboylan
 * @version Nov 15, 2013
 */

public class Parser
{

// ~Fields.....................................................................
    private AssetManager assetManager;
    private List<String> filenames;
    private List<Movie> movies;


// ~Methods....................................................................

    // ----------------------------------------------------------
    /**
     * Create a new Parser object. This pulls all the .json files from
     * the assets folder and converts them to a movies list.
     * @param am the assetmanager from the view
     */
    public Parser(AssetManager am)
    {
        assetManager = am;
        filenames = new ArrayList<String>();
        try
        {
            // For all asset files, if it is a json file then add to list
            for (String file : assetManager.list("")) {
                if (file.length() > 5) {
                    if (file.substring(file.length() - 5, file.length()).equals(".json")) {
                        System.out.println("Adding " + file.toString() + " to movies");
                        filenames.add(file);
                    }
                }
            }
        }
        catch (IOException e)
        {
            System.out.println("*No files or readable files in assets*");
            e.printStackTrace();
        }

        // Parse all the json files pulled from assets into movie files
        movies = new ArrayList<Movie>();
        for (String file : this.filenames) {
            movies.add(this.jsonToMovies(file));
            System.out.println("Converted " + file.toString() + " to a movie");
        }



    }


    // ----------------------------------------------------------
    /**
     * This method takes a filename and parses that json file into
     * a movie object.
     * @param fileName
     * @return movie The movie created from file name passed in
     */
    public Movie jsonToMovies(String fileName)
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
        /*
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
        */

        // return new movie created.
        return response[0];
    }

    // ----------------------------------------------------------
    /**
     * This method returns all the movie objects.
     * @return movies
     */
    public List<Movie> getMovies() {
        return this.movies;
    }

}
