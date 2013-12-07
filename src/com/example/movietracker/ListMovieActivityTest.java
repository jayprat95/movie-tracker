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
     }

     // ~Fields................................................................
     private ListMovieActivity  lmaWatched;
     private ListMovieActivity  lmaToWatch;
     private ListMovieActivity  lmaFavorite;
     private Intent intentWatched;
     private Intent intentToWatch;
     private Intent intentFavorite;
     private Instrumentation mInstrumentationWatched;
     private Instrumentation mInstrumentationToWatch;
     private Instrumentation mInstrumentationFavorite;
     
     // Widget fields
     private ListView listViewWatched;
     private ListView listViewToWatch;
     private ListView listViewFavorite;
     
     
     
     
     
    // ----------------------------------------------------------
    protected void setUp()
        throws Exception
    {
        super.setUp();
        
        
        // ***Setup three activities***
        this.mInstrumentationWatched = getInstrumentation();
        intentWatched = new Intent();
        intentWatched =
            new Intent(mInstrumentationWatched.getContext(),
                ListMovieActivity.class);
        intentWatched.putExtra("listname", "watched");
        //***
        this.mInstrumentationToWatch = getInstrumentation();
        intentToWatch = new Intent();
        intentToWatch =
            new Intent(mInstrumentationToWatch.getContext(),
                ListMovieActivity.class);
        intentWatched.putExtra("listname", "toWatch");
        //***
        this.mInstrumentationFavorite = getInstrumentation();
        intentFavorite = new Intent();
        intentFavorite =
            new Intent(mInstrumentationFavorite.getContext(),
                ListMovieActivity.class);
        intentFavorite.putExtra("listname", "favorite");
    }


    /**
     * Test method for {@link com.example.movietracker.ListMovieActivity#onCreate(android.os.Bundle)}.
     */
    public void testOnCreateBundleWatched()
    {
        setActivityIntent(intentWatched);
        lmaWatched = this.getActivity();
        listViewWatched = (ListView)lmaWatched.findViewById(R.id.listView);
        assertEquals(listViewWatched.getCount(), 0);
        
        
    	
    	
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
