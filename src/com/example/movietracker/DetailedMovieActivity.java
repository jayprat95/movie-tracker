package com.example.movietracker;

import android.widget.RatingBar;
import java.io.IOException;
import android.graphics.BitmapFactory;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.URLConnection;
import java.net.URL;
import android.graphics.Bitmap;
import android.net.Uri;
import android.widget.ImageView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.os.Parcelable;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import java.util.List;
import android.os.Bundle;
import java.util.ArrayList;
import android.app.Activity;

public class DetailedMovieActivity
    extends Activity
{
    // ~Fields............................................................
    private AssetManager             assetManager;

    private Intent                   currentIntent;
    private String                   movieString;
    private Parcelable[]             movieDataParcelable;
    private ParcelableImplementation movieData;

    private TextFileParser           textParser;

    private Movie                    theMovie;

    private boolean updateList[];

    // ~Fields for Widgets
    private TextView                 title;
    private TextView                 plotSimple;
    private TextView                 type;
    private TextView                 directors;
    private TextView                 actors;


    // private TextView title;
    // private TextView title;
    // private TextView title;
    // private TextView title;
    // private TextView title;
    // private TextView title;

    // ~Methods...........................................................

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        updateList = new boolean[1];
        updateList[0] = false;

        super.onCreate(savedInstanceState);
        assetManager = this.getAssets();
        setContentView(R.layout.detailed_movie_view);

        // Get extra parameter of the movie name.
        currentIntent = getIntent();
        movieString = currentIntent.getStringExtra("movieTitle");
        movieDataParcelable =
            currentIntent.getParcelableArrayExtra("movieData");
        RatingBar ratingsBar = (RatingBar)findViewById(R.id.movieRatings);
        ratingsBar.setEnabled(false);
        // ******** Get all data passed in and set Texts.*******

        // New piece of Data: Title
        // Convert movie data to custom parcelable class.
        movieData = (ParcelableImplementation)movieDataParcelable[0];
        title = new TextView(this);
        title = (TextView)findViewById(R.id.title);
        title.setText(movieData.getString());

        // New piece of Data: Simple Plot
        // Convert movie data to custom parcelable class.
        movieData = (ParcelableImplementation)movieDataParcelable[1];
        plotSimple = new TextView(this);
        plotSimple = (TextView)findViewById(R.id.plotSimple);
        plotSimple.setText(movieData.getString());

        // New piece of Data: Type
        // Convert movie data to custom parcelable class.
        movieData = (ParcelableImplementation)movieDataParcelable[2];
//        type = new TextView(this);
//        type = (TextView)findViewById(R.id.type);
//        type.setText(movieData.getString());

        // New piece of Data: Directors
        // Convert movie data to custom parcelable class.
        movieData = (ParcelableImplementation)movieDataParcelable[3];
        type = new TextView(this);
        type = (TextView)findViewById(R.id.directors);
        type.setText("Directed by: " + movieData.getString());

        // New piece of Data: Actors
        // Convert movie data to custom parcelable class.
        movieData = (ParcelableImplementation)movieDataParcelable[4];
        type = new TextView(this);
        type = (TextView)findViewById(R.id.actors);
        type.setText("Actors: " + movieData.getString());

        // New piece of Data: Runtime
        // Convert movie data to custom parcelable class.
        movieData = (ParcelableImplementation)movieDataParcelable[5];
        type = new TextView(this);
        // type = (TextView)findViewById(R.id.runtime);
        type.setText(movieData.getString());

        // New piece of Data: Imdb url
        // Convert movie data to custom parcelable class.
        movieData = (ParcelableImplementation)movieDataParcelable[6];
        type = new TextView(this);
        // type = (TextView)findViewById(R.id.imdb_url);
        type.setText(movieData.getString());

        // New piece of Data: Released Date
        // Convert movie data to custom parcelable class.
        movieData = (ParcelableImplementation)movieDataParcelable[7];
        type = new TextView(this);
        type = (TextView)findViewById(R.id.releaseDate);
        type.setText("Released on: " + parseDate(movieData.getString()));

        // New piece of Data: Rating
        // Convert movie data to custom parcelable class.
        movieData = (ParcelableImplementation)movieDataParcelable[8];
        type = new TextView(this);
        // type = (TextView)findViewById(R.id.rating);
        Float rating = Float.parseFloat(movieData.getString());
        ratingsBar.setRating(rating / 2);
        //type.setText(movieData.getString());

        // New piece of Data: Rating Count
        // Convert movie data to custom parcelable class.
        movieData = (ParcelableImplementation)movieDataParcelable[9];
        type = new TextView(this);
        // type = (TextView)findViewById(R.id.ratingCount);
        type.setText(movieData.getString());

        // New piece of Data: Picture url imdb
        // Convert movie data to custom parcelable class.
        movieData = (ParcelableImplementation)movieDataParcelable[10];
        ImageView iv = new ImageView(this);
        iv = (ImageView)findViewById(R.id.pictureImdb);

        iv.setImageBitmap(getImageBitmap(movieData.getString()));

        // New piece of Data: Picture url cover
        // Convert movie data to custom parcelable class.
        movieData = (ParcelableImplementation)movieDataParcelable[11];
        type = new TextView(this);
        // type = (TextView)findViewById(R.id.pictureCover;
        //type.setText(movieData.getString());


        this.setupListeners();
    }



    public void setupListeners()
    {

        // Open TextFileParser for adding from buttons.
        textParser = new TextFileParser(assetManager, this.getBaseContext());

        // ....................................................................
        // Adding movie to list watched
        Button watched = (Button)findViewById(R.id.watchedButton);
        watched.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                updateList[0] = true;

                textParser.getStringFromFiles("watched");
                ArrayList<String> temp = textParser.getList("watched");
                // Adding movie from list
                if ((temp != null) && (!(temp.contains(movieString))))
                {
                    temp.add(movieString);
                    textParser.setMovieList(temp, "watched");
                }
                // Removing movie from list
                else if ((temp != null) && (temp.contains(movieString)))
                {
                    temp.remove(movieString);
                    System.out.println("Removing " + movieString
                        + " from watched");
                    textParser.setMovieList(temp, "watched");
                }
            }
        });

        // Adding movie to list favorite
        Button toWatch = (Button)findViewById(R.id.toWatchButton);
        toWatch.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                updateList[0] = true;

                textParser.getStringFromFiles("toWatch");
                ArrayList<String> temp = textParser.getList("toWatch");
                // Adding movie from list
                if ((temp != null) && (!(temp.contains(movieString))))
                {
                    temp.add(movieString);
                    System.out.println("Adding " + movieString + " to toWatch");
                    textParser.setMovieList(temp, "toWatch");
                }
                // Removing movie from list
                else if ((temp != null) && (temp.contains(movieString)))
                {
                    temp.remove(movieString);
                    System.out.println("Removing " + movieString
                        + " from toWatch");
                    textParser.setMovieList(temp, "toWatch");
                }
            }
        });

        // Adding movie to list favorite
        Button favorite = (Button)findViewById(R.id.favoriteButton);
        favorite.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                updateList[0] = true;

                textParser.getStringFromFiles("favorite");
                ArrayList<String> temp = textParser.getList("favorite");
                // Adding movie from list
                if ((temp != null) && (!(temp.contains(movieString))))
                {
                    temp.add(movieString);
                    textParser.setMovieList(temp, "favorite");
                }
                // Removing movie from list
                else if ((temp != null) && (temp.contains(movieString)))
                {
                    temp.remove(movieString);
                    System.out.println("Removing " + movieString
                        + " from favorite");
                    textParser.setMovieList(temp, "favorite");
                }
            }
        });


    }


    // Convert date to readable format
    private String parseDate(String string)
    {
        if (string.length() != 8)
        {
            return "";
        }
        String year = string.substring(0, 4);
        String month = string.substring(4, 6);
        String day = string.substring(6, 8);
        return day + "/" + month + "/" + year;

    }


    private Bitmap getImageBitmap(String url) {
        Bitmap bm = null;
        try {
            URL aURL = new URL(url);
            URLConnection conn = aURL.openConnection();
            conn.connect();
            InputStream is = conn.getInputStream();
            BufferedInputStream bis = new BufferedInputStream(is);
            bm = BitmapFactory.decodeStream(bis);
            bis.close();
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bm;
    }

    /**
     * This method overrides the back button to let the list know whether to
     * update immediately because of changes.
     */
    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra("update", updateList);
        setResult(RESULT_OK, intent);
        finish();
    }
}
