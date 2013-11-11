package com.example.movietracker;

import java.lang.Object;
import java.lang.String;
import org.json.*;

public class Parser
{

    //~Fields--------------------------------------------------------
    private String stringToParse;
    private int size;

    //~Methods-------------------------------------------------------

    /**
     * This is the constructor for the parser that extracts data
     * from the imdb database.
     */
    public Parser(String inputString) {

        stringToParse = inputString;
    }

    public JSONObject createJSONObject() {
        JSONObject(this.getStringToParse());

    }


    public String getStringToParse() {
        return stringToParse;
    }
}
