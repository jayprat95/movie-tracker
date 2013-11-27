package com.example.movietracker;

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
    private ArrayList<Movie>  movies;

    private String[]          lists = { "watched", "toWatch", "favorite" };
    private String            watchedString;
    private String            toWatchString;
    private String            favoriteString;
    private ArrayList<String> watchedTitles;
    private ArrayList<String> toWatchTitles;
    private ArrayList<String> favoriteTitles;


    // ~Methods...............................................................

    public TextFileParser(AssetManager am)
    {
        watchedTitles = new ArrayList<String>();
        toWatchTitles = new ArrayList<String>();
        favoriteTitles = new ArrayList<String>();

        assetManager = am;
        getStringsFromFiles();
        parseAllStrings();

    }


    public void setMovieList(ArrayList<Movie> moviesToAdd, String listname)
    {

    }


    public ArrayList<String> getWatchedList()
    {
        return watchedTitles;
    }


    public ArrayList<String> getToWatchList()
    {
        return toWatchTitles;
    }


    public ArrayList<String> getfavoriteList()
    {
        return favoriteTitles;
    }


    public void getStringsFromFiles()
    {
        for (String list : lists)
        {
            InputStream inputStream = null;
            try
            {
                inputStream = assetManager.open("STORED_" + list + ".txt");
            }
            catch (IOException e)
            {
                System.out.println("No stored lists in assets");
                e.printStackTrace();
            }

            BufferedReader bufferedReader = null;
            StringBuilder builder = new StringBuilder();

            String currentLine;
            try
            {

                bufferedReader =
                    new BufferedReader(new InputStreamReader(inputStream));
                while ((currentLine = bufferedReader.readLine()) != null)
                {
                    builder.append(currentLine);
                }

            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            finally
            {
                if (bufferedReader != null)
                {
                    try
                    {
                        bufferedReader.close();
                    }
                    catch (IOException e)
                    {
                        e.printStackTrace();
                    }
                }
            }
            String contents = builder.toString();

            if (list == "watched")
            {
                watchedString = contents;
            }
            else if (list == "toWatch")
            {
                toWatchString = contents;
            }
            else if (list == "favorite")
            {
                favoriteString = contents;
            }
        }
    }


    public void parseAllStrings()
    {
        String delimiter = "[,]";
        List<String> watchedTemp =
            Arrays.asList(watchedString.split(delimiter));
        for (String movie : watchedTemp)
        {
            if (movie != null)
            {
                watchedTitles.add(movie);
            }
        }
        List<String> toWatchTemp =
            Arrays.asList(toWatchString.split(delimiter));
        for (String movie : toWatchTemp)
        {
            if (movie != null)
            {
                toWatchTitles.add(movie);
            }
        }
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
