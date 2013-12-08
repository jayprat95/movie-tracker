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
 * This class tests the Main Movie Activity in order to ensure that it is
 * working properly. This class extends the ActivityInstrumentationTestCase2
 * so that we can call individual elements in the Activity, such as any of the
 * buttons and test them as we please.
 *
 * @author jayanth
 * @version Dec 4, 2013
 */

public class MainMovieActivityTest
    extends ActivityInstrumentationTestCase2<MainMovieActivity>
{

    // ----------------------------------------------------------

    // ----------------------------------------------------------
    /**
     * Create a new MainMovieActivityTest object.
     */
    @SuppressWarnings("deprecation")
    public MainMovieActivityTest()
    {
        super("com.MainMovieActivity", MainMovieActivity.class);
    }


    // ----------------------------------------------------------
    /**
     * Create a new MainMovieActivityTest object.
     * @param activityClass is the mainMovie activity
     */
    public MainMovieActivityTest(Class<MainMovieActivity> activityClass)
    {
        super(activityClass);
    }

    // ~Fields................................................................
    private MainMovieActivity mma;
    private Intent            intent;
    private Instrumentation   mInstrumentation;

    //Widgets
    Button toWatchButton;
    Button watchedButton;
    Button favoriteButton;
    Button searchButton;


    protected void setUp()
        throws Exception
    {
        super.setUp();
        this.mInstrumentation = getInstrumentation();
        //intent = new Intent();
        //setActivityIntent(intent);
        //mma = this.getActivity();
    }


    /**
     * Test method for onCreate
     */
    public void testOnCreateBundle()
    {
        mma = this.getActivity();
        EditText text = (EditText)mma.findViewById(R.id.searchText);
        assertEquals(View.GONE, text.getVisibility());
    }


    /**
     * Test method for setupListeners
     */
    public void testOnClickToWatch()
    {
    	mma = this.getActivity();
        toWatchButton =
            (Button)mma.findViewById(R.id.toWatch);
        ActivityMonitor activityMonitor =
            getInstrumentation().addMonitor(
                ListMovieActivity.class.getName(),
                null,
                false);
        System.out.println(toWatchButton);
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
        mma = this.getActivity();
        watchedButton =
            (Button)mma.findViewById(R.id.watched);
        ActivityMonitor activityMonitor =
            getInstrumentation().addMonitor(
                ListMovieActivity.class.getName(),
                null,
                false);
        System.out.println(watchedButton);
        try
        {
            runTestOnUiThread(new Runnable() {
                public void run()
                {
                    watchedButton.performClick();
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
        mma = this.getActivity();
        favoriteButton =
            (Button)mma.findViewById(R.id.favorite);
        ActivityMonitor activityMonitor =
            getInstrumentation().addMonitor(
                ListMovieActivity.class.getName(),
                null,
                false);
        System.out.println(favoriteButton);
        try
        {
            runTestOnUiThread(new Runnable() {
                public void run()
                {
                    favoriteButton.performClick();
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
        mma = this.getActivity();
        searchButton =
            (Button)mma.findViewById(R.id.searchButton);
        ActivityMonitor activityMonitor =
            getInstrumentation().addMonitor(
                ListMovieActivity.class.getName(),
                null,
                false);
        System.out.println(searchButton);
        try
        {
            runTestOnUiThread(new Runnable() {
                public void run()
                {
                    searchButton.performClick();
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
