package com.example.movietracker;

import android.app.Instrumentation;
import android.content.Context;
import android.content.res.AssetManager;
import android.test.ActivityTestCase;
import junit.framework.TestCase;

// -------------------------------------------------------------------------
/**
 *  This is a test class for the TextFileParser class.
 *  It tests the methods in the TextFileParser class.
 * 
 *  @author Jayanth Prathipati (jayanth)
 *  @author Oliver Ebeling-Koning (odek)
 *  @author Linsay Boylan (lindsb7)
 *  @version 2013.12.08
 */

public class TextFileParserTest
    extends ActivityTestCase
{
	// ~Fields..................................................
	private Context ctx;
	
	private TextFileParser tfp;

    // ----------------------------------------------------------
    protected void setUp()
        throws Exception
    {
        super.setUp();
        ctx = getInstrumentation().getTargetContext();
        tfp = new TextFileParser(ctx);
    }


    /**
     * Test method for {@link com.example.movietracker.TextFileParser#TextFileParser(android.content.res.AssetManager, android.content.Context)}.
     */
    public void testTextFileParser()
    {
        fail("Not yet implemented");
    }


    /**
     * Test method for {@link com.example.movietracker.TextFileParser#setMovieList(java.util.ArrayList, java.lang.String)}.
     */
    public void testSetMovieList()
    {
        fail("Not yet implemented");
    }


    /**
     * Test method for {@link com.example.movietracker.TextFileParser#getStringFromFiles(java.lang.String)}.
     */
    public void testGetStringFromFiles()
    {
        fail("Not yet implemented");
    }


    /**
     * Test method for {@link com.example.movietracker.TextFileParser#parseStringsToStringList(java.lang.String)}.
     */
    public void testParseStringsToStringList()
    {
        fail("Not yet implemented");
    }


    /**
     * Test method for {@link com.example.movietracker.TextFileParser#getList(java.lang.String)}.
     */
    public void testGetList()
    {
        fail("Not yet implemented");
    }

}
