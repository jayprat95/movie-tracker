package com.example.movietracker;

import org.json.simple.JSONObject;
import junit.framework.TestCase;

public class ParserTest
    extends TestCase
{

    //~Fields----------------------------------------------
    private Parser parser;

    protected void setUp()
    {
        parser = new Parser();
    }

    private void testPullJSONDataToJSONObject() {
        System.out.println("hello");
        org.json.JSONObject testObject = parser.pullJSONDataToJSONObject("drive.json");
        System.out.println(testObject == null);
        System.out.println(testObject.toString());

        assertTrue(testObject instanceof Object);
    }
}
