package com.example.movietracker;

import android.app.Activity;
import android.content.Intent;
import android.widget.ImageView;
import android.widget.Button;
import android.widget.TextView;
import junit.framework.TestCase;
import android.test.*;
import android.app.Instrumentation;

// -------------------------------------------------------------------------
/**
 * Write a one-sentence summary of your class here. Follow it with additional
 * details about its purpose, what abstraction it represents, and how to use it.
 *
 * @author jayanthprathipati
 * @version Dec 4, 2013
 */

public class DetailedMovieActivityTest
    extends ActivityInstrumentationTestCase2<DetailedMovieActivity>
{
    public DetailedMovieActivityTest() {
       super("com.DetailedMovieActivity", DetailedMovieActivity.class);
    }


    public DetailedMovieActivityTest(Class<DetailedMovieActivity> activityClass)
    {
        super(activityClass);
        // TODO Auto-generated constructor stub
    }


    // ~Fields................................................................
    private DetailedMovieActivity  dma;
    private Intent intent;
    private Instrumentation mInstrumentation;

    // Widgets
    private TextView  title;
    private TextView  plotSimple;
    private TextView  directors;
    private TextView  actors;
    private TextView  releaseDate;
    private Button    watchedButton;
    private Button    favoriteButton;
    private Button    toWatchButton;
    private ImageView watchedCheckBox;
    private ImageView favoriteCheckBox;
    private ImageView toWatchCheckBox;
    private ImageView pictureImdb;


    // ----------------------------------------------------------
    protected void setUp()
        throws Exception
    {
        super.setUp();

        this.mInstrumentation = getInstrumentation();

        intent = new Intent();
        intent =
            new Intent(mInstrumentation.getContext(),
                DetailedMovieActivity.class);
        // Pass all details to intents before starting
        String item = "movie";
        intent.putExtra("movieTitle", item);
        ParcelableImplementation[] parcelableArray =
            {
                new ParcelableImplementation("t"),
                new ParcelableImplementation("p"),
                new ParcelableImplementation("t"),
                new ParcelableImplementation("d"),
                new ParcelableImplementation("a"),
                new ParcelableImplementation("r"),
                new ParcelableImplementation("u"),
                new ParcelableImplementation("20130812"),
                new ParcelableImplementation(Float
                    .toString(5)),
                new ParcelableImplementation(Float
                    .toString(5)),
                new ParcelableImplementation("http://ia.media-imdb.com/images/M/MV5BMTQwNTU3MTE4NF5BMl5BanBnXkFtZTcwOTgxNDM2Mg@@._V1_SX214_.jpg"),
                new ParcelableImplementation("c") };
        intent.putExtra("movieData", parcelableArray);

        setActivityIntent(intent);
        dma = this.getActivity();
        System.out.println(dma);



        // Get all buttons

        title = (TextView)dma.findViewById(R.id.title);
        plotSimple = (TextView)dma.findViewById(R.id.plotSimple);
        directors = (TextView)dma.findViewById(R.id.directors);
        actors = (TextView)dma.findViewById(R.id.actors);
        releaseDate = (TextView)dma.findViewById(R.id.releaseDate);
        watchedButton = (Button)dma.findViewById(R.id.watchedButton);
        toWatchButton = (Button)dma.findViewById(R.id.toWatchButton);
        favoriteButton = (Button)dma.findViewById(R.id.favoriteButton);
        watchedCheckBox = (ImageView)dma.findViewById(R.id.watchedCheckBox);
        toWatchCheckBox = (ImageView)dma.findViewById(R.id.toWatchCheckBox);
        favoriteCheckBox = (ImageView)dma.findViewById(R.id.favoriteCheckBox);
        pictureImdb = (ImageView)dma.findViewById(R.id.pictureImdb);

    }


    /**
     * Test method for
     * {@link com.example.movietracker.DetailedMovieActivity#onBackPressed()}.
     */
    public void testOnBackPressed()
    {
        fail("Not yet implemented");
    }


    /**
     * Test method for
     * {@link com.example.movietracker.DetailedMovieActivity#onCreate(android.os.Bundle)}
     * .
     */
    public void testOnCreateBundle()
    {
    	assertEquals(dma.getTitle(), title.getText());
    }


    /**
     * Test method for
     * {@link com.example.movietracker.DetailedMovieActivity#setupListeners()}.
     */
    public void testSetupListeners()
    {
        fail("Not yet implemented");
    }


    public void testCheckBoxes() {
     // Checking boxes
        assertFalse(watchedCheckBox.isShown());
        assertFalse(toWatchCheckBox.isShown());
        assertFalse(favoriteCheckBox.isShown());
        try
        {
            runTestOnUiThread(new Runnable() { public void run() { watchedButton.performClick(); } });
            runTestOnUiThread(new Runnable() { public void run() { toWatchButton.performClick(); } });
            runTestOnUiThread(new Runnable() { public void run() { favoriteButton.performClick(); } });
        }
        catch (Throwable e)
        {
            System.out.println("Could not click button");
            e.printStackTrace();
        }
        assertTrue(watchedCheckBox.isShown());
        assertTrue(toWatchCheckBox.isShown());
        assertTrue(favoriteCheckBox.isShown());

        // Unchecking
        try
        {
            runTestOnUiThread(new Runnable() { public void run() { watchedButton.performClick(); } });
            runTestOnUiThread(new Runnable() { public void run() { toWatchButton.performClick(); } });
            runTestOnUiThread(new Runnable() { public void run() { favoriteButton.performClick(); } });
        }
        catch (Throwable e)
        {
            System.out.println("Could not click button");
            e.printStackTrace();
        }
        assertFalse(watchedCheckBox.isShown());
        assertFalse(toWatchCheckBox.isShown());
        assertFalse(favoriteCheckBox.isShown());
    }
    
    public void testFieldWidgets() {
    	assertEquals("t", title.getText());
    	assertEquals("p", plotSimple.getText());
    	assertEquals("Directed by: d", directors.getText());
    	assertEquals("Actors: a", actors.getText());
    	assertEquals("Released on: 12/08/2013", releaseDate.getText());
    	System.out.println(pictureImdb.getDrawable());
    }
}
