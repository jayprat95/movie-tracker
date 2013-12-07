package com.example.movietracker;

import android.widget.ImageView;
import android.widget.Button;
import android.widget.TextView;
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

public class DetailedMovieActivityTest
    extends TestCase
{

    // ~Fields................................................................
    private DetailedMovieActivity dma;
    private TextView                 title;
    private TextView                 plotSimple;
    private TextView                 type;
    private TextView                 directors;
    private TextView                 actors;
    private Button watchedButton;
    private Button favoriteButton;
    private Button toWatchButton;
    private ImageView watchedCheckBox;
    private ImageView favoriteCheckBox;
    private ImageView toWatchCheckBox;






    // ----------------------------------------------------------
    protected void setUp()
        throws Exception
    {
        super.setUp();
        dma = new DetailedMovieActivity();
    }


    /**
     * Test method for {@link com.example.movietracker.DetailedMovieActivity#onBackPressed()}.
     */
    public void testOnBackPressed()
    {
        fail("Not yet implemented");
    }


    /**
     * Test method for {@link com.example.movietracker.DetailedMovieActivity#onCreate(android.os.Bundle)}.
     */
    public void testOnCreateBundle()
    {
        System.out.println(watchedCheckBox == null);
        assertFalse(watchedCheckBox.isShown());
        watchedButton.performClick();
        assertTrue(watchedCheckBox.isShown());
    }


    /**
     * Test method for {@link com.example.movietracker.DetailedMovieActivity#setupListeners()}.
     */
    public void testSetupListeners()
    {
        fail("Not yet implemented");
    }



}
