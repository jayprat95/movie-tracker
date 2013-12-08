package com.example.movietracker;

import android.app.Activity;
import android.widget.Button;
import android.app.Instrumentation.ActivityMonitor;
import android.view.View;
import android.widget.EditText;
import android.app.Instrumentation;
import android.content.Intent;
import android.test.ActivityInstrumentationTestCase2;
import junit.framework.TestCase;

// -------------------------------------------------------------------------
/**
 * Write a one-sentence summary of your class here. Follow it with additional
 * details about its purpose, what abstraction it represents, and how to use it.
 *
 * @author jayanthprathipati
 * @version Dec 4, 2013
 */

public class MainMovieActivityTest
    extends ActivityInstrumentationTestCase2<MainMovieActivity>
{

    // ----------------------------------------------------------
    @SuppressWarnings("deprecation")
    public MainMovieActivityTest()
    {
        super("com.MainMovieActivity", MainMovieActivity.class);
    }


    public MainMovieActivityTest(Class<MainMovieActivity> activityClass)
    {
        super(activityClass);
    }

    // ~Fields................................................................
    private MainMovieActivity mma;
    private Intent            intent;
    private Instrumentation   mInstrumentation;


    protected void setUp()
        throws Exception
    {
        super.setUp();
        this.mInstrumentation = getInstrumentation();
        intent = new Intent();
        setActivityIntent(intent);
        mma = this.getActivity();
    }


    /**
     * Test method for onCreate
     */
    public void testOnCreateBundle()
    {
        EditText text = (EditText)mma.findViewById(R.id.searchText);
        assertEquals(View.GONE, text.getVisibility());
    }


    /**
     * Test method for setupListeners
     */
    public void testOnClickToWatch()
    {
        final Button toWatchButton =
            (Button)mma.findViewById(R.id.toWatch);
        Instrumentation mInstrumentationToWatch = getInstrumentation();
        Intent intentToWatch = new Intent();
        intentToWatch =
            new Intent(
                mInstrumentationToWatch.getContext(),
                MainMovieActivity.class);
        intentToWatch.putExtra("listname", "toWatch");
        setActivityIntent(intentToWatch);
        ActivityMonitor activityMonitor =
            getInstrumentation().addMonitor(
                MainMovieActivity.class.getName(),
                null,
                false);
        MainMovieActivity myActivity = getActivity();
        try
        {
            runTestOnUiThread(new Runnable() {
                public void run()
                {
                    toWatchButton.performClick();
                }
            });
        }
        catch (Throwable e)
        {
            System.out.println("Couldnt click button");
            e.printStackTrace();
        }

        Activity nextActivity =
            getInstrumentation().waitForMonitorWithTimeout(
                activityMonitor,
                30000);
        assertNotNull(nextActivity);
        nextActivity.finish();
    }
    public void testOnClickWatched()
    {
        final Button watched =
            (Button)mma.findViewById(R.id.watched);
        Instrumentation mInstrumentationToWatch = getInstrumentation();
        Intent intentWatched = new Intent();
        intentWatched =
            new Intent(
                mInstrumentationToWatch.getContext(),
                MainMovieActivity.class);
        intentWatched.putExtra("listname", "watched");
        setActivityIntent(intentWatched);
        ActivityMonitor activityMonitor =
            getInstrumentation().addMonitor(
                MainMovieActivity.class.getName(),
                null,
                false);
        MainMovieActivity myActivity = getActivity();
        try
        {
            runTestOnUiThread(new Runnable() {
                public void run()
                {
                    watched.performClick();
                }
            });
        }
        catch (Throwable e)
        {
            System.out.println("Couldnt click button");
            e.printStackTrace();
        }

        Activity nextActivity =
            getInstrumentation().waitForMonitorWithTimeout(
                activityMonitor,
                30000);
        assertNotNull(nextActivity);
        nextActivity.finish();
    }
    public void testOnClickFavorite()
    {
        final Button favorite =
            (Button)mma.findViewById(R.id.favorite);
        Instrumentation mInstrumentationToWatch = getInstrumentation();
        Intent intentFavorite = new Intent();
        intentFavorite =
            new Intent(
                mInstrumentationToWatch.getContext(),
                MainMovieActivity.class);
        intentFavorite.putExtra("listname", "favorite");
        setActivityIntent(intentFavorite);
        ActivityMonitor activityMonitor =
            getInstrumentation().addMonitor(
                MainMovieActivity.class.getName(),
                null,
                false);
        MainMovieActivity myActivity = getActivity();
        try
        {
            runTestOnUiThread(new Runnable() {
                public void run()
                {
                    favorite.performClick();
                }
            });
        }
        catch (Throwable e)
        {
            System.out.println("Couldnt click button");
            e.printStackTrace();
        }

        Activity nextActivity =
            getInstrumentation().waitForMonitorWithTimeout(
                activityMonitor,
                30000);
        assertNotNull(nextActivity);
        nextActivity.finish();
    }

    public void testOnClickSearch()
    {
        final Button search =
            (Button)mma.findViewById(R.id.searchButton);
        Instrumentation mInstrumentationToWatch = getInstrumentation();
        Intent intentSearch = new Intent();
        intentSearch =
            new Intent(
                mInstrumentationToWatch.getContext(),
                MainMovieActivity.class);
        intentSearch.putExtra("listname", "searchButton");
        setActivityIntent(intentSearch);
        ActivityMonitor activityMonitor =
            getInstrumentation().addMonitor(
                MainMovieActivity.class.getName(),
                null,
                false);
        MainMovieActivity myActivity = getActivity();
        try
        {
            runTestOnUiThread(new Runnable() {
                public void run()
                {
                    search.performClick();
                }
            });
        }
        catch (Throwable e)
        {
            System.out.println("Couldnt click button");
            e.printStackTrace();
        }

        Activity nextActivity =
            getInstrumentation().waitForMonitorWithTimeout(
                activityMonitor,
                30000);
        assertNotNull(nextActivity);
        nextActivity.finish();
    }


}
