package com.example.movietracker;

import java.io.IOException;
import org.json.JSONException;
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

    public void testPullJSONDataToJSONObject() {
        System.out.println("hello");
        org.json.JSONObject testObject = null;
        try
        {
            testObject = parser.pullJSONDataToJSONObject("drive.json");
        }
        catch (JSONException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (IOException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(testObject == null);
        System.out.println(testObject.toString());

        assertTrue(testObject != null);
    }
}
