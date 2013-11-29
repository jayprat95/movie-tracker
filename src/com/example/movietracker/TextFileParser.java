package com.example.movietracker;

import java.io.FileOutputStream;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.io.File;
import android.content.Context;
import java.io.OutputStreamWriter;
import java.io.FileWriter;
import java.io.OutputStream;
import java.util.List;
import java.util.Arrays;
import java.io.BufferedReader;
import java.io.Reader;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.io.IOException;
import android.content.res.AssetManager;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class TextFileParser
{
    // ~Fields................................................................
    private AssetManager      assetManager;
    private Context           context;
    private ArrayList<Movie>  movies;

    private String[]          lists = { "watched", "toWatch", "favorite" };
    private String            watchedString;
    private String            toWatchString;
    private String            favoriteString;
    private ArrayList<String> watchedTitles;
    private ArrayList<String> toWatchTitles;
    private ArrayList<String> favoriteTitles;


    // ~Methods...............................................................

    public TextFileParser(AssetManager am, Context con)
    {
        // Initialize lists of movies
        watchedTitles = new ArrayList<String>();
        toWatchTitles = new ArrayList<String>();
        favoriteTitles = new ArrayList<String>();
        watchedString = "";
        toWatchString = "";
        favoriteString = "";

        assetManager = am;
        context = con;

    }


    private ArrayList<String> getWatchedList()
    {
        return watchedTitles;
    }


    private ArrayList<String> getToWatchList()
    {
        return toWatchTitles;
    }


    private ArrayList<String> getFavoriteList()
    {
        return favoriteTitles;
    }

    public ArrayList<String> getList(String filename) {
        if (filename.equals("watched")) {
            return this.getWatchedList();
        }
        else if (filename.equals("toWatch")) {
            return this.getToWatchList();
        }
        else if (filename.equals("favorite")) {
            return this.getFavoriteList();
        }
        System.out.println("INVALID SYTAX LIST NAME");
        return null;
    }


    private String getStringFromList(ArrayList<String> list)
    {
        StringBuilder sb = new StringBuilder();
        if (list.size() == 0)
        {
            return "";
        }
        for (String title : list)
        {
            sb.append(title + ",");
        }

        String returnString = sb.toString();
        return returnString.substring(0, returnString.length() - 1);

    }


    // ----------------------------------------------------------
    /**
     * This method stores a list of titles in internal memory.
     * "Internal Memory...STORED_toWatch.txt"
     *
     * @param moviesToSet
     *            List of titles to store
     * @param listname
     *            Either "toWatch", "watched", "favorite"
     */
    public void setMovieList(ArrayList<String> moviesToSet, String listname)
    {
        // Create output stream with spot in internal memory.
        FileOutputStream fos = null;
        try
        {
            fos =
                context.openFileOutput(
                    "STORED_toWatch.txt",
                    Context.MODE_PRIVATE);
        }
        catch (FileNotFoundException e)
        {
            System.out.println("Cannot access/find file. Writing");
            e.printStackTrace();
        }

        // Write list of names passed in to file in bytes.
        try
        {
            fos.write(getStringFromList(moviesToSet).getBytes());
        }
        catch (IOException e)
        {
            System.out.println("Could not write from output stream");
            e.printStackTrace();
        }

    }


    // ----------------------------------------------------------
    /**
     * This method updates the "watchedString, toWatchString, and
     * favoriteString" with the text from file.
     *
     * @param filename
     *            the filename of list type to retrieve.
     */
    public void getStringFromFiles(String filename)
    {
        // Create output stream with spot in internal memory.
        FileInputStream fis = null;
        try
        {
            fis = context.openFileInput("STORED_" + filename + ".txt");
        }
        catch (FileNotFoundException e)
        {
            System.out.println("Cannot access/find file. Reading");
            e.printStackTrace();
            return;
        }

        if (fis == null) {
            return;
        }
        // Initialize reading variables
        int k = 0;
        StringBuilder builder = new StringBuilder();
        // Read bytes from file and append to builder.
        try
        {
            while ((k = fis.read()) != -1)
            {
                builder.append((char)k);
            }
        }
        catch (IOException e)
        {
            System.out.println("Could not read from input stream");
            e.printStackTrace();
        }

        String contents = builder.toString();

        // Store file contents in correct variable
        if (filename.equals("toWatch"))
        {
            this.toWatchString = contents;
        }
        else if (filename.equals("watched"))
        {
            this.watchedString = contents;
        }
        else if (filename.equals("filename"))
        {
            this.favoriteString = contents;
        }
        else
        {
            System.out.println("INVALID FILENAME");
        }

    }


    // ----------------------------------------------------------
    /**
     * This method converts all the strings pulled from files into appropriate
     * lists.
     */
    public void parseStringsToStringList(String filename)
    {
        // Create delimiter and parse file into a String list for all lists.
        String delimiter = "[,]";

        // Parse watched list
        if ((filename.equals("watched")) && (watchedString.length() > 0))
        {
            List<String> watchedTemp =
                Arrays.asList(watchedString.split(delimiter));
            for (String movie : watchedTemp)
            {
                if (movie != null)
                {
                    watchedTitles.add(movie);
                }
            }
        }

        // Parse toWatch list
        if ((filename.equals("toWatch")) && (toWatchString.length() > 0))
        {
            List<String> toWatchTemp =
                Arrays.asList(toWatchString.split(delimiter));
            for (String movie : toWatchTemp)
            {
                if (movie != null)
                {
                    toWatchTitles.add(movie);
                }
            }
        }

        // Parse favorite list.
        if ((filename.equals("favorite")) && (favoriteString.length() > 0))
        {
            List<String> favoriteTemp =
                Arrays.asList(favoriteString.split(delimiter));
            for (String movie : favoriteTemp)
            {
                if (movie != null)
                {
                    favoriteTitles.add(movie);
                }
            }
        }
    }
}
