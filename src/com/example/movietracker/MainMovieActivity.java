package com.example.movietracker;

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

        Button button1 = (Button)findViewById(R.id.button1);

        button1.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v)
            {

                Intent intent =
                    new Intent(
                        getApplicationContext(),
                        DetailedMovieActivity.class);
                startActivity(intent);

            }
        });

    }
}
