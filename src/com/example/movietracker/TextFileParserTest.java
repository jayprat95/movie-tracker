package com.example.movietracker;

import java.util.ArrayList;

import android.content.Context;
import android.test.ActivityTestCase;

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
     * Test method for getStringFromFiles.
     */
    public void testGetStringFromFiles()
    {
        ArrayList<String> list = new ArrayList<String>();
        list.add("hello1");
        assertEquals("hello1", tfp.getStringFromListHelper(list));
        list.add("hello2");
        assertEquals("hello1,hello2", tfp.getStringFromListHelper(list));
    }

    /**
     * This method tests the alphabetize method
     */
    public void testAlphabetize() {
    	ArrayList<String> list = new ArrayList<String>();
        list.add("hello1");
        list.add("hello2");
        list.add("a");
        ArrayList<String> newList = tfp.alphabetize(list);
        assertEquals("a", newList.get(0));
        assertEquals("hello1", newList.get(1));
        assertEquals("hello2", newList.get(2));
    }

    }
