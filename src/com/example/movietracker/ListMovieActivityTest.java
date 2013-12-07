package com.example.movietracker;

import android.widget.ListView;
import android.widget.TextView;
import android.app.Instrumentation;
import android.content.Intent;
import android.test.ActivityInstrumentationTestCase2;
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

public class ListMovieActivityTest
    extends ActivityInstrumentationTestCase2<ListMovieActivity>
{

    public ListMovieActivityTest() {
        super("com.ListMovieActivity", ListMovieActivity.class);
     }


     public ListMovieActivityTest(Class<ListMovieActivity> activityClass)
     {
         super(activityClass);
         // TODO Auto-generated constructor stub
     }

     // ~Fields................................................................
     private ListMovieActivity  lma;
     private Intent intent;
     private ListView listView;
     private Instrumentation mInstrumentation;
    // ----------------------------------------------------------
    protected void setUp()
        throws Exception
    {
        super.setUp();

        this.mInstrumentation = getInstrumentation();
        intent = new Intent();
        intent =
            new Intent(mInstrumentation.getContext(),
                ListMovieActivity.class);
        intent.putExtra("listname", "watched");
        setActivityIntent(intent);
        lma = this.getActivity();
        listView = (ListView)lma.findViewById(R.id.listView);

    }


    /**
     * Test method for {@link com.example.movietracker.ListMovieActivity#onCreate(android.os.Bundle)}.
     */
    public void testOnCreateBundle()
    {

    }


    /**
     * Test method for {@link com.example.movietracker.ListMovieActivity#pullMoviesFromListFile()}.
     */
    public void testPullMoviesFromListFile()
    {
        fail("Not yet implemented");
    }


    /**
     * Test method for {@link com.example.movietracker.ListMovieActivity#setupListView()}.
     */
    public void testSetupListView()
    {
        fail("Not yet implemented");
    }


    /**
     * Test method for {@link com.example.movietracker.ListMovieActivity#onActivityResult(int, int, android.content.Intent)}.
     */
    public void testOnActivityResultIntIntIntent()
    {
        fail("Not yet implemented");
    }


    /**
     * Test method for {@link com.example.movietracker.ListMovieActivity#updateLists()}.
     */
    public void testUpdateLists()
    {
        fail("Not yet implemented");
    }

}
