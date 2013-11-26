package com.example.movietracker;

import android.os.Bundle;
import android.app.Activity;

public class DrawerLayout extends Activity
{

    public DrawerLayout() {
        super();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_movie_view);


    }
}
