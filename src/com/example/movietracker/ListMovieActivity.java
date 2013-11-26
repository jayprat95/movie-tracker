package com.example.movietracker;

import android.widget.TextView;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.content.res.AssetManager;
import java.util.List;
import android.os.Bundle;
import java.util.ArrayList;
import android.app.Activity;

public class ListMovieActivity extends Activity
{
    // ~Fields............................................................
    private AssetManager assetManager;
    private Intent currentIntent;
    private String listName;

    private TextView textView1;



    // ~Methods...........................................................



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        assetManager = this.getAssets();
        setContentView(R.layout.list_movie_view);

        // Get extra parameter of the movie name.
        currentIntent = getIntent();
        listName = currentIntent.getStringExtra("listName");

        textView1 = new TextView(this);
        textView1 = (TextView)findViewById(R.id.textView1);
        textView1.setText(listName + " is the name of the view");


        // Setup listener for button and opening new view
        Button button1 = (Button)findViewById(R.id.watched);

        button1.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v)
            {

                Intent intent =
                    new Intent(
                        getApplicationContext(),
                        DetailedMovieActivity.class);
                intent.putExtra("Movie", "the movie from list");
                startActivity(intent);

            }
        });

    }
}
