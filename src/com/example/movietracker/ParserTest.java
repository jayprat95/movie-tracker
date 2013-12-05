package com.example.movietracker;

import android.content.Context;
import android.test.ActivityTestCase;
import android.test.ActivityInstrumentationTestCase2;
import android.content.res.AssetManager;
import junit.framework.TestCase;

// -------------------------------------------------------------------------
/**
 *  Write a one-sentence summary of your class here.
 *  Follow it with additional details about its purpose, what abstraction
 *  it represents, and how to use it.
 *
 *  @author jayanthprathipati
 *  @version Dec 4, 2013
 */

public class ParserTest
    extends ActivityTestCase
{

    // ----------------------------------------------------------
    //gets the JSON from the
    private AssetManager assets;
    private Parser parse;
    final Context ctx =  getInstrumentation().getTargetContext();
    protected void setUp()
        throws Exception
    {
        super.setUp();
        assets = ctx.getResources().getAssets();
        parse = new Parser(assets);
    }



    /**
     * Test method for JsonToMovies()
     */
    public void testJsonToMovies()
    {
        fail("Not yet implemented");
    }


    /**
     * Test method for {@link com.example.movietracker.Parser#getMovies()}.
     */
    public void testGetMovies()
    {
        fail("Not yet implemented");
    }


    /**
     * Test method for {@link com.example.movietracker.Parser#hasMovie(java.lang.String)}.
     */
    public void testHasMovie()
    {
        fail("Not yet implemented");
    }


    /**
     * Test method for {@link com.example.movietracker.Parser#getMovieFromTitle(java.lang.String)}.
     */
    public void testGetMovieFromTitle()
    {
        fail("Not yet implemented");
    }


    /**
     * Test method for {@link com.example.movietracker.Parser#getTitlesList()}.
     */
    public void testGetTitlesList()
    {
        fail("Not yet implemented");
    }

}
