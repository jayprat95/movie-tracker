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
    private Button    watchedButton;
    private Button    favoriteButton;
    private Button    toWatchButton;
    private ImageView watchedCheckBox;
    private ImageView favoriteCheckBox;
    private ImageView toWatchCheckBox;


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
                new ParcelableImplementation(Integer
                    .toString(05050505)),
                new ParcelableImplementation(Float
                    .toString(5)),
                new ParcelableImplementation(Float
                    .toString(5)),
                new ParcelableImplementation("i"),
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
        watchedButton = (Button)dma.findViewById(R.id.watchedButton);
        toWatchButton = (Button)dma.findViewById(R.id.toWatchButton);
        favoriteButton = (Button)dma.findViewById(R.id.favoriteButton);
        watchedCheckBox = (ImageView)dma.findViewById(R.id.watchedCheckBox);
        toWatchCheckBox = (ImageView)dma.findViewById(R.id.toWatchCheckBox);
        favoriteCheckBox = (ImageView)dma.findViewById(R.id.favoriteCheckBox);

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
        System.out.println(watchedCheckBox == null);
        assertFalse(watchedCheckBox.isShown());
        try
        {
            runTestOnUiThread(new Runnable() { public void run() { watchedButton.performClick(); } });
        }
        catch (Throwable e)
        {
            System.out.println("Could not click button");
            e.printStackTrace();
        }
        assertTrue(watchedCheckBox.isShown());
    }


    /**
     * Test method for
     * {@link com.example.movietracker.DetailedMovieActivity#setupListeners()}.
     */
    public void testSetupListeners()
    {
        fail("Not yet implemented");
    }

}
