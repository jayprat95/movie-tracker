package com.example.movietracker;

import android.os.Parcel;
import junit.framework.TestCase;


// -------------------------------------------------------------------------
/**
 *  Write a one-sentence summary of your class here.
 *  Follow it with additional details about its purpose, what abstraction
 *  it represents, and how to use it.
 * 
 *  @author Jayanth Prathipati (jayanth)
 *  @author Oliver Ebeling-Koning (odek)
 *  @author Linsay Boylan (lindsb7)
 *  @version 2013.12.08
 */

public class ParcelableImplementationTest
    extends TestCase
{

    private ParcelableImplementation pi;
    private String                   toMove;


    // ----------------------------------------------------------
    protected void setUp()
        throws Exception
    {
        super.setUp();
        toMove = "test";
        pi = new ParcelableImplementation(toMove);
    }


    /**
     * Test method for
     * {@link com.example.movietracker.ParcelableImplementation#ParcelableImplementation(java.lang.String)}
     * .
     */
    public void testParcelableImplementation()
    {
        assertEquals("test", pi.getString());
    }


    /**
     * Test method for
     * {@link com.example.movietracker.ParcelableImplementation#describeContents()}
     * .
     */
    public void testDescribeContents()
    {
        assertEquals(0, pi.describeContents());
    }


    /**
     * Test method for
     * {@link com.example.movietracker.ParcelableImplementation#writeToParcel(android.os.Parcel, int)}
     * .
     */
    public void testWriteToParcel()
    {
        fail("Not yet implemented");
    }


    /**
     * Test method for
     * {@link com.example.movietracker.ParcelableImplementation#getString()}.
     */
    public void testGetString()
    {
        toMove = "move";
        pi = new ParcelableImplementation(toMove);
        assertEquals("move", pi.getString());
    }


    /**
     * Test method for
     * {@link com.example.movietracker.ParcelableImplementation#stringArrayToString(java.lang.String[])}
     * .
     */
    public void testStringArrayToString()
    {
        fail("Not yet implemented");
    }

}
