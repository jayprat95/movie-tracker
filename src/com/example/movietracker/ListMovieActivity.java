package com.example.movietracker;

import android.widget.AdapterView.OnItemClickListener;
import android.os.Parcel;
import android.os.Parcelable;
import android.widget.AdapterView;
import android.content.Context;
import java.util.HashMap;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.content.res.AssetManager;
import java.util.List;
import android.os.Bundle;
import java.util.ArrayList;
import android.app.Activity;

public class ListMovieActivity
    extends Activity
{
    // ~Fields............................................................
    private AssetManager      assetManager;
    private Intent            currentIntent;
    private String            listname;
    private Parser            jsonParser;
    private ArrayList<Movie>  movies;

    private TextView          textView1;

    // ~Fields............................................................
    private ArrayList<String> toWatch;
    private ArrayList<String> watched;
    private ArrayList<String> favorite;


    // ~Methods...........................................................

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        toWatch = new ArrayList<String>();
        watched = new ArrayList<String>();
        favorite = new ArrayList<String>();

        super.onCreate(savedInstanceState);
        assetManager = this.getAssets();
        setContentView(R.layout.list_movie_view);

        // Get extra parameter of the movie name passed in.
        currentIntent = getIntent();
        listname = currentIntent.getStringExtra("listname");

        // Set text on screen dynamically
        textView1 = new TextView(this);
        textView1 = (TextView)findViewById(R.id.textView1);
        textView1.setText(listname + " is the name of the view");

        // /******************TESTING
        // Collect and parse all movies in assets folder
        System.out.println("Generating parser and parsing...");
        jsonParser = new Parser(assetManager);
        movies = jsonParser.getMovies();
        // /******************TESTING

        // Pull movies from list from file.
        TextFileParser textParser =
            new TextFileParser(this.assetManager, this.getBaseContext());
        textParser.getStringFromFiles(listname);
        textParser.parseStringsToStringList(listname);
        ArrayList<String> titles = textParser.getList(listname);

        // ************ATTEMPT AT LISTING MOVIES**********************
        final ListView listView = (ListView)findViewById(R.id.listView);
        // Final parameter of this adapter should be the correct list to display.
        final StableArrayAdapter adapter =
            new StableArrayAdapter(
                this,
                android.R.layout.simple_list_item_1,
                jsonParser.getTitlesList());
        listView.setAdapter(adapter);

        listView
            .setOnItemClickListener(new OnItemClickListenerImplementation(this.movies) {
                @Override
                public void onItemClick(
                    AdapterView<?> parent,
                    final View view,
                    int position,
                    long id)
                {
                    final String item =
                        (String)parent.getItemAtPosition(position);
                    Intent intent =
                        new Intent(
                            getApplicationContext(),
                            DetailedMovieActivity.class);

                    Movie movieToDetail = jsonParser.getMovieFromTitle(item);
                    intent.putExtra("movieTitle", item);
                    ParcelableImplementation[] parcelableArray =
                        { new ParcelableImplementation(movieToDetail.getTitle()),
                            new ParcelableImplementation(movieToDetail.getSimplePlot()), new ParcelableImplementation(movieToDetail.getType()), new ParcelableImplementation(movieToDetail.getTitle()), new ParcelableImplementation(movieToDetail.getTitle()), new ParcelableImplementation(movieToDetail.getTitle()), new ParcelableImplementation(movieToDetail.getTitle()), new ParcelableImplementation(movieToDetail.getTitle()), new ParcelableImplementation(movieToDetail.getTitle()), new ParcelableImplementation(movieToDetail.getTitle()), new ParcelableImplementation(movieToDetail.getTitle()) };
                    intent.putExtra("movieData", parcelableArray);

                    startActivity(intent);
                }
            });

    }


    private class StableArrayAdapter
        extends ArrayAdapter<String>
    {
        HashMap<String, Integer> mIdMap = new HashMap<String, Integer>();


        public StableArrayAdapter(
            Context context,
            int textViewResourceId,
            List<String> strings)
        {
            super(context, textViewResourceId, strings);
            if ((strings != null) && (strings.size() > 0)) {
            for (int ii = 0; ii < strings.size(); ii++)
            {
                mIdMap.put(strings.get(ii), ii);
            }
            }
        }

    }

    private class OnItemClickListenerImplementation
        implements OnItemClickListener
    {
        ArrayList<Movie> m;

        public OnItemClickListenerImplementation (ArrayList<Movie> moviesToField) {
            m = moviesToField;
        }



        public void onItemClick(
            AdapterView<?> av,
            View v,
            int i,
            long l)
        {
            onItemClick(av, v, i, l);
        }



        public ArrayList<Movie> getMoviesInClick() {
            return m;
        }


    }
}
