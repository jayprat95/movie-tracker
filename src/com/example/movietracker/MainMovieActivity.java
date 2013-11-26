package com.example.movietracker;

import java.util.Arrays;
import android.widget.EditText;
import android.widget.Button;
import android.view.View;
import android.content.Intent;
import android.content.res.AssetManager;
import java.util.List;
import android.os.Bundle;
import java.util.ArrayList;
import android.app.Activity;

public class MainMovieActivity
    extends Activity
{
    // ~Fields............................................................
    private AssetManager assetManager;
    private List<Movie>  movies;
    private Parser       parser;

    // ~Methods...........................................................

    public void initialize()
    {
        movies = new ArrayList<Movie>();

        // Collect and parse all movies in assets folder
        System.out.println("Generating parser and parsing...");
        parser = new Parser(assetManager);
        movies = parser.getMovies();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        assetManager = this.getAssets();
        setContentView(R.layout.activity_main_movie_view);
        initialize();

        // Watch buttons for opening up different views.
        setupListeners();

    }

    public void setupListeners() {
        Button watched = (Button)findViewById(R.id.watched);
        watched.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent =
                    new Intent(
                        getApplicationContext(),
                        ListMovieActivity.class);
                intent.putExtra("listName", "watched");
                startActivity(intent);
            }
        });

        Button toWatch = (Button)findViewById(R.id.toWatch);
        toWatch.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent =
                    new Intent(
                        getApplicationContext(),
                        ListMovieActivity.class);
                intent.putExtra("listName", "toWatch");
                startActivity(intent);
            }
        });

        Button favorite = (Button)findViewById(R.id.favorite);
        favorite.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent =
                    new Intent(
                        getApplicationContext(),
                        ListMovieActivity.class);
                intent.putExtra("listName", "favorite");
                startActivity(intent);
            }
        });

        Button searchButton = (Button)findViewById(R.id.searchButton);
        searchButton.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent =
                    new Intent(
                        getApplicationContext(),
                        ListMovieActivity.class);
                intent.putExtra("listName", "searchButton");
                startActivity(intent);
            }
        });


    }
}
