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
    private TextFileParser    textParser;
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

        // Get extra parameter of the list name passed in.
        currentIntent = getIntent();
        listname = currentIntent.getStringExtra("listname");

        // Set text on screen dynamically
//        textView1 = new TextView(this);
//        textView1 = (TextView)findViewById(R.id.textView1);
//        textView1.setText(listname + " is the name of the view");

        // Pull data for all movies in assets folder
        System.out.println("Generating parser and parsing...");
        jsonParser = new Parser(assetManager);
        movies = jsonParser.getMovies();

        this.updateLists();

    }


    /**
     * // ----------------------------------------------------------------------
     * --- /** This is an adapter class for the list view of movies. This is a
     * custom adapter for handling the interaction with the list of movies in
     * the view.
     *
     * @author Oliver
     * @version Nov 30, 2013
     */
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
            if ((strings != null) && (strings.size() > 0))
            {
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


        public OnItemClickListenerImplementation(ArrayList<Movie> moviesToField)
        {
            m = moviesToField;
        }


        public void onItemClick(AdapterView<?> av, View v, int i, long l)
        {
            onItemClick(av, v, i, l);
        }


        public ArrayList<Movie> getMoviesInClick()
        {
            return m;
        }

    }


    public void pullMoviesFromListFile()
    {

        // Pull movies from list from file.
        textParser =
            new TextFileParser(this.assetManager, this.getBaseContext());
        textParser.getStringFromFiles(listname);
        if (listname.equals("toWatch"))
        {
            toWatch = textParser.getList(listname);
        }
        else if (listname.equals("watched"))
        {
            watched = textParser.getList(listname);
        }
        else if (listname.equals("favorite"))
        {
            favorite = textParser.getList(listname);
        }
        else if (listname.equals("search"))
        {
            favorite = jsonParser.getTitlesList();
        }

    }


    public void setupListView()
    {
        final ListView listView = (ListView)findViewById(R.id.listView);

        // set correct list to pass to adapter to display in view
        ArrayList<String> arrayAdapterList = jsonParser.getTitlesList();
        if (listname.equals("watched"))
        {
            arrayAdapterList = watched;
        }
        if (listname.equals("toWatch"))
        {
            arrayAdapterList = toWatch;
        }
        if (listname.equals("favorite"))
        {
            arrayAdapterList = favorite;
        }
        final StableArrayAdapter adapter =
            new StableArrayAdapter(
                this,
                android.R.layout.simple_list_item_1,
                arrayAdapterList);
        listView.setAdapter(adapter);
        // Setup listener for the list of movies
        listView.setOnItemClickListener(new OnItemClickListenerImplementation(
            this.movies) {
            @Override
            public void onItemClick(
                AdapterView<?> parent,
                final View view,
                int position,
                long id)
            {
                final String item = (String)parent.getItemAtPosition(position);
                // Start intent for details of movie clicked
                Intent intent =
                    new Intent(
                        getApplicationContext(),
                        DetailedMovieActivity.class);
                // Pass all details to intents before starting
                Movie movieToDetail = jsonParser.getMovieFromTitle(item);
                intent.putExtra("movieTitle", item);
                ParcelableImplementation[] parcelableArray =
                    {
                        new ParcelableImplementation(movieToDetail.getTitle()),
                        new ParcelableImplementation(movieToDetail
                            .getSimplePlot()),
                        new ParcelableImplementation(movieToDetail.getType()),
                        new ParcelableImplementation(
                            stringArrayToString(movieToDetail.getDirectors())),
                        new ParcelableImplementation(
                            stringArrayToString(movieToDetail.getActors())),
                        new ParcelableImplementation(
                            stringArrayToString(movieToDetail.getRuntime())),
                        new ParcelableImplementation(movieToDetail
                            .getImdb_url()),
                        new ParcelableImplementation(Integer
                            .toString(movieToDetail.getRelease_date())),
                        new ParcelableImplementation(Float
                            .toString(movieToDetail.getRating())),
                        new ParcelableImplementation(Float
                            .toString(movieToDetail.getRatingCount())),
                        new ParcelableImplementation(movieToDetail.getPoster()
                            .get("imdb")),
                        new ParcelableImplementation(movieToDetail.getPoster()
                            .get("cover")) };
                intent.putExtra("movieData", parcelableArray);

                if ((listname.equals("toWatch")) || (listname.equals("watched") || (listname.equals("favorite")))) {
                startActivityForResult(intent, 0);
                }
                else {
                    startActivity(intent);
                }
            }



            // Helper method for passing string arrays into detailed view
            // Turns string array into readable string
            private String stringArrayToString(String[] stringArray)
            {
                StringBuilder sb = new StringBuilder();
                if (stringArray.length < 1)
                {
                    return "";
                }
                for (String ss : stringArray)
                {
                    sb.append(ss + ", ");
                }
                String returnString = sb.toString();
                return returnString.substring(0, returnString.length() - 2);

            }
        });
    }
    //_________________________________________________________________________



    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        System.out.println(resultCode);
        boolean[] update = data.getBooleanArrayExtra("update");
        System.out.println(update + "........");
        if (update[0]) {
            this.updateLists();
        }
    }

    public void updateLists() {
        // Get movies for this list from internal memory
        this.pullMoviesFromListFile();

        // ListView Setup and Control
        this.setupListView();
    }

}
