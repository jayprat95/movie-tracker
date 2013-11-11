package com.example.movietracker;

import java.lang.Object;
import java.lang.String;
import org.json.*;
import org.json.simple.parser.JSONParser;
import java.io.FileReader;

public class Parser
{

    //~Fields--------------------------------------------------------
    private String stringToParse;

    //~Methods-------------------------------------------------------

    /**
     * This is the constructor for the parser that extracts data
     * from the imdb database.
     */
    public Parser(String inputString) {

        stringToParse = inputString;
    }

    public JSONObject createJSONObjectFromJSONArray(JSONArray array) {
        // empty
        return new JSONObject();
    }

    private JSONArray pullJSONDataToJSONArray(String fileLocation) {
        JSONParser parser = new JSONParser();
        JSONArray array = (JSONArray) parser.parse(new FileReader("drive.json"));

    }

    public String getStringToParse() {
        return stringToParse;
    }
}
