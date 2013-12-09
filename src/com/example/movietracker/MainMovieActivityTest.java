package com.example.movietracker;

import android.app.Activity;
import android.widget.Button;
import android.app.Instrumentation.ActivityMonitor;
import android.view.View;
import android.widget.EditText;
import android.test.ActivityInstrumentationTestCase2;

// -------------------------------------------------------------------------
/**
 * This class tests the Main Movie Activity in order to ensure that it is
 * working properly. This class extends the ActivityInstrumentationTestCase2 so
 * that we can call individual elements in the Activity, such as any of the
 * buttons and test them as we please.
 *
 *  @author Jayanth Prathipati (jayanth)
 *  @author Oliver Ebeling-Koning (odek)
 *  @author Linsay Boylan (lindsb7)
 *  @version 2013.12.08
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
     *
     * @param activityClass
     *            is the mainMovie activity
     */
    public MainMovieActivityTest(Class<MainMovieActivity> activityClass)
    {
        super(activityClass);
    }

    // ~Fields................................................................
    // creates a Main Movie Activity
    private MainMovieActivity mma;

    // Widgets
    // these are the 4 buttons that are on the main movie activity
    private Button            toWatchButton;
    private Button            watchedButton;
    private Button            favoriteButton;
    private Button            searchButton;


    /**
     * Sets up the test class
     */
    protected void setUp()
        throws Exception
    {
        super.setUp();
    }


    /**
     * Test method for onCreate, tests what happens when the activity is first
     * initialized
     */
    public void testOnCreateBundle()
    {
        // gets the activity
        mma = this.getActivity();
        // gets the textfield that is created and hidden on the main view
        EditText text = (EditText)mma.findViewById(R.id.searchText);
        // asserts that the EditText's visibility is being properly set
        assertEquals(View.GONE, text.getVisibility());
    }


    /**
     * Test method for SetUpListeners. This test method covers the case where
     * the toWatch button is clicked
     */
    public void testOnClickToWatch()
    {
        // gets the activity
        mma = this.getActivity();
        // gets the button on the activity
        toWatchButton = (Button)mma.findViewById(R.id.toWatch);
        /**
         * gets the activity monitor so we can monitor what changes when the
         * button is clicked
         */
        ActivityMonitor activityMonitor =
            getInstrumentation().addMonitor(
                ListMovieActivity.class.getName(),
                null,
                false);
        System.out.println(toWatchButton);
        // this try-catch block clicks the button necessary as per the test
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

        // gets the next activity, which would be the list of movies in this
        // case
        Activity nextActivity =
            getInstrumentation().waitForMonitorWithTimeout(
                activityMonitor,
                30000);
        // asserts that that list exists
        assertNotNull(nextActivity);
        // finishes that activity
        nextActivity.finish();
    }


    // ----------------------------------------------------------
    /**
     * Test method for SetUpListeners. This test method covers the case where
     * the watched button is clicked
     */
    public void testOnClickWatched()
    {
        // gets the activity

        mma = this.getActivity();
        // gets the button on the activity
        watchedButton = (Button)mma.findViewById(R.id.watched);
        /**
         * gets the activity monitor so we can monitor what changes when the
         * button is clicked
         */
        ActivityMonitor activityMonitor =
            getInstrumentation().addMonitor(
                ListMovieActivity.class.getName(),
                null,
                false);

        System.out.println(watchedButton);
        // this try-catch block clicks the button necessary as per the test

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
        // gets the next activity, which would be the list of movies in this
        // case
        Activity nextActivity =
            getInstrumentation().waitForMonitorWithTimeout(
                activityMonitor,
                30000);
        // asserts that that list exists
        assertNotNull(nextActivity);
        // finishes that activity
        nextActivity.finish();
    }


    // ----------------------------------------------------------
    /**
     * Test method for SetUpListeners. This test method covers the case where
     * the favorite button is clicked
     */
    public void testOnClickFavorite()
    {
        // gets the activity
        mma = this.getActivity();
        // gets the button on the activity
        favoriteButton = (Button)mma.findViewById(R.id.favorite);
        /**
         * gets the activity monitor so we can monitor what changes when the
         * button is clicked
         */
        ActivityMonitor activityMonitor =
            getInstrumentation().addMonitor(
                ListMovieActivity.class.getName(),
                null,
                false);
        System.out.println(favoriteButton);
        // this try-catch block clicks the button necessary as per the test
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
        // gets the next activity, which would be the list of movies in this
        // case
        Activity nextActivity =
            getInstrumentation().waitForMonitorWithTimeout(
                activityMonitor,
                30000);
        // asserts that that list exists
        assertNotNull(nextActivity);
        // finishes that activity
        nextActivity.finish();
    }


    // ----------------------------------------------------------
    /**
     * Test method for SetUpListeners. This test method covers the case where
     * the all movies button is clicked
     */
    public void testOnClickSearch()
    {
        // gets the activity
        mma = this.getActivity();
        // gets the button on the activity
        searchButton = (Button)mma.findViewById(R.id.searchButton);
        /**
         * gets the activity monitor so we can monitor what changes when the
         * button is clicked
         */
        ActivityMonitor activityMonitor =
            getInstrumentation().addMonitor(
                ListMovieActivity.class.getName(),
                null,
                false);
        System.out.println(searchButton);
        // this try-catch block clicks the button necessary as per the test
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
        // gets the next activity, which would be the list of movies in this
        // case
        Activity nextActivity =
            getInstrumentation().waitForMonitorWithTimeout(
                activityMonitor,
                30000);
        // asserts that that list exists
        assertNotNull(nextActivity);
        // finishes that activity
        nextActivity.finish();
    }

}
