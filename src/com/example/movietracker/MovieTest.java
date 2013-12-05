package com.example.movietracker;

import java.util.Map;
import java.util.HashMap;
import junit.framework.TestCase;

// -------------------------------------------------------------------------
/**
 *  This class tests the Movie data model to ensure that it meets project
 *  specifications
 *
 *  @author jayanth
 *  @version Dec 4, 2013
 */

public class MovieTest extends TestCase
{

    // ----------------------------------------------------------
    //field for testing purposes
    private Movie testMovie;
    protected void setUp()
    {
        testMovie = new Movie();
    }


    /**
     * Test method for getSimplePlot() and setSimplePlot()
     */
    public void testGetAndSetSimplePlot()
    {
        testMovie.setSimplePlot("Hello!");
        assertEquals("Hello!", testMovie.getSimplePlot());
    }


    /**
     * Test method for getting/setting the title
     */
    public void testGetAndSetTitle()
    {
        testMovie.setTitle("hi");
        assertEquals("hi", testMovie.getTitle());
    }

    /**
     * Test method for getDirectors and setDirectors
     */
    public void testGetAndSetDirectors()
    {
        String[] testArray = {"A", "B", "C"};
        testMovie.setDirectors(testArray);
        assertEquals("A", testMovie.getDirectors()[0]);
    }

    /**
     * Test method for get and set actors
     */
    public void testGetAndSetActors()
    {
        String[] testArray = {"A", "B", "C"};
        testMovie.setActor(testArray);
        assertEquals("A", testMovie.getActors()[0]);
    }

    /**
     * Test method for get and set Imdb Url
     */
    public void testGetAndSetImdb_url()
    {
        testMovie.setImdb_url("I");
        assertEquals("I", testMovie.getImdb_url());
    }

    /**
     * Test method for Get and Set Rating
     */
    public void testGetAndSetRating()
    {
        testMovie.setRating(5);
        assertEquals(5.0, testMovie.getRating(), 0.01);
    }


    /**
     * Test method for get & set the release date
     */
    public void testGetAndSetRelease_date()
    {
       testMovie.setRelease_date(5);
       assertEquals(5.0, testMovie.getRelease_date(), 0.01);
    }

    /**
     * Test method for get and set ratings count
     */
    public void testGetAndSetRatingCount()
    {
        testMovie.setRatingCount(10);
        assertEquals(10.0, testMovie.getRatingCount(), 0.01);
    }

    /**
     * Test method for get and set runTime
     */
    public void testGetAndSetRuntime()
    {
        String[] testArray = {"A", "B", "C"};
        testMovie.setRuntime(testArray);
        assertEquals("A", testMovie.getRuntime()[0]);
    }


    /**
     * Test method for get and set posters
     */
    public void testGetAndSetPoster()
    {
        Map<String, String> testMap = new HashMap<String, String>();
        testMap.put("H", "I");
        testMovie.setPoster(testMap);
        assertEquals("I", testMovie.getPoster().get("H"));
    }

    /**
     * Test method for get and set type
     */
    public void testGetAndSetType()
    {
        testMovie.setType("R");
        assertEquals("R", testMovie.getType());
    }

}
