package com.example.movietracker;

import java.io.IOException;
import org.apache.http.ParseException;
import java.lang.Object;
import java.lang.String;
import org.json.*;
import org.json.simple.parser.*;
import java.io.FileReader;

// Import Exceptions.
import java.io.FileNotFoundException;

public class Parser
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


    public JSONObject pullJSONDataToJSONObject(String fileLocation) {
        JSONParser parser = new JSONParser();

        try {
            FileReader fileReader = new FileReader("C:\\Users\\Oliver\\Dropbox\\Documents\\GitHub\\movie-tracker\\src\\com\\example\\movietracker\\drive.json");
            this.jsonObject = (JSONObject) parser.parse(fileReader);

        }
        catch (FileNotFoundException exception1) {
                exception1.printStackTrace();
        }
        catch (ParseException exception2) {
            exception2.printStackTrace();
        }
        catch (IOException exception3)
        {
            exception3.printStackTrace();
        }
        catch (org.json.simple.parser.ParseException exception4)
        {
            exception4.printStackTrace();
        }

        return this.jsonObject;
    }
}
