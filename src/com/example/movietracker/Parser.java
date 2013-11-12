package com.example.movietracker;

import java.io.IOException;
import org.json.JSONException;
import org.json.JSONArray;
import android.app.Activity;
import org.apache.http.ParseException;
import java.lang.Object;
import java.lang.String;
import org.json.*;
import org.json.simple.parser.*;
import java.io.*;

// Import Exceptions.
import java.io.FileNotFoundException;

public class Parser extends Activity
{

    //~Fields--------------------------------------------------------
    private JSONObject jsonObject;

    //~Methods-------------------------------------------------------

    /**
     * This is the constructor for the parser that extracts data
     * from the imdb database.
     */
    public Parser() {

        this.jsonObject = null;
    }


    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     * @param fileLocation
     * @return
     * @throws JSONException
     * @throws IOException
     */
    public JSONObject pullJSONDataToJSONObject(String fileLocation) throws JSONException, IOException {
        org.json.simple.parser.JSONParser parser = new JSONParser();
        BufferedReader bufferedReader = null;

        InputStream is = getAssets().open("drive.json");
        int size = is.available();
        byte[] buffer = new byte[size];
        is.read(buffer);
        is.close();
        String bufferString = new String(buffer);

        try {
            JSONArray jsonArray = new JSONArray(bufferString);
            JSONObject obj = jsonArray.optJSONObject(0);
            this.jsonObject = obj;

        }
        catch (ParseException exception2) {
            exception2.printStackTrace();
        }

        return this.jsonObject;
    }
}
