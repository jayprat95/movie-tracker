package com.example.movietracker;

import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import android.util.JsonReader;

public class MovieJsonReader
{

    public MovieJsonReader()
    {
        //empty
    }


    public ArrayList<Movie> getMovieFromStream(JsonReader reader) throws IOException
    {
        ArrayList<Movie> movies = new ArrayList<Movie>();
        reader.beginArray();
        while(reader.hasNext())
        {
            movies.add(readMovie(reader));
        }
        reader.endArray();
        return movies;
    }


    private Movie readMovie(JsonReader reader) throws IOException
    {
        Movie retMovie = new Movie();
        reader.beginObject();
        while(reader.hasNext())
        {
            String name = reader.nextName();
            if(name.equals("actors"))
            {
                retMovie.setActor(reader.nextString());
            }
        }
        reader.endObject();
        return retMovie;
    }

}
