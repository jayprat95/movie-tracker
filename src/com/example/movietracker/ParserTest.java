package com.example.movietracker;

import java.util.ArrayList;
import android.content.Context;
import android.test.ActivityTestCase;
import android.content.res.AssetManager;

// -------------------------------------------------------------------------
/**
 *  Write a one-sentence summary of your class here.
 *  Follow it with additional details about its purpose, what abstraction
 *  it represents, and how to use it.
 *
 *  @author jayanthprathipati
 *  @version Dec 4, 2013
 */

public class ParserTest extends ActivityTestCase
{

    // ----------------------------------------------------------
    //gets the JSON from the
    private AssetManager assets;
    private Parser parse;
    Context ctx;
    protected void setUp() throws Exception
    {
        super.setUp();
        ctx = getInstrumentation().getTargetContext();
        assets = ctx.getResources().getAssets();
        parse = new Parser(assets);
    }



    /**
     * Test method for JsonToMovies()
     */
    public void testJsonToMovies()
    {
        Movie drive = parse.jsonToMovies("drive.json");
        assertEquals("Drive", drive.getTitle());

    }


    /**
     * Test method for getMovies()
     */
    public void testGetMovies()
    {
        ArrayList<Movie> list = parse.getMovies();
        assertNotNull(list);
        assertFalse(list.isEmpty());
    }


    /**
     * Test method for {@link com.example.movietracker.Parser#hasMovie(java.lang.String)}.
     */
    public void testHasMovie()
    {
       assertTrue(parse.hasMovie("Drive"));
       assertFalse(parse.hasMovie("Romeo and Juliet"));
    }


    /**
     * Test method for {@link com.example.movietracker.Parser#getMovieFromTitle(java.lang.String)}.
     */
    public void testGetMovieFromTitle()
    {
       Movie drive = parse.getMovieFromTitle("Drive");
       assertEquals("Drive", drive.getTitle());
       assertNull(parse.getMovieFromTitle("Romeo and Juliet"));
    }


    /**
     * Test method for {@link com.example.movietracker.Parser#getTitlesList()}.
     */
    public void testGetTitlesList()
    {
        ArrayList<String> list = parse.getTitlesList();
        assertNotNull(list);
        assertFalse(list.isEmpty());
    }

}
