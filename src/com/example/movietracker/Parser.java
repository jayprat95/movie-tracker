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
import com.google.gson.*;

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


    public String pullDataFromJson(String fileLocation) {
/*
        Reader reader;
        try {
            //reader = new InputStreamReader(JsonToJava.class.getResourceAsStream("/Server1.json"), "UTF-8");
        }
        catch (IOException e1)
        {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        */

            Gson gson = new Gson();
            String str = gson.fromJson("\"drive.json\"", String.class);
            System.out.println(str);
            //Movie p = gson.fromJson(reader, Movie.class);
            //System.out.println(p);

            return str;

    }


    }






    /*
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

    */
