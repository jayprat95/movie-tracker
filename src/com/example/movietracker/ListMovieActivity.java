package com.example.movietracker;

import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView;
import android.content.Context;
import java.util.HashMap;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.content.Intent;
import android.view.MenuItem;
import android.view.View;
import android.content.res.AssetManager;
import java.util.List;
import android.os.Bundle;
import java.util.ArrayList;

import android.app.ActionBar;
import android.app.Activity;

/**
 * This class displays lists of movie titles. When a title is clicked it pulls
 * up that movie in a detailed view.
 * 
 * @author F-16
 * 
 */
public class ListMovieActivity extends Activity {
	// ~Fields............................................................
	private AssetManager assetManager;
	private Intent currentIntent;
	private String listname;
	private Parser jsonParser;
	private TextFileParser textParser;
	private ArrayList<Movie> movies;

	// ~Fields............................................................
	private ArrayList<String> toWatch;
	private ArrayList<String> watched;
	private ArrayList<String> favorite;

	// ~Methods...........................................................

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// Initialize the lists
		toWatch = new ArrayList<String>();
		watched = new ArrayList<String>();
		favorite = new ArrayList<String>();

		super.onCreate(savedInstanceState);
		assetManager = this.getAssets();
		setContentView(R.layout.list_movie_view);

		// Setup button on title bar
		ActionBar actionBar = getActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);

		// Get extra parameter of the list name passed in.
		currentIntent = getIntent();
		listname = currentIntent.getStringExtra("listname");

		// Pull data for all movies in assets folder
		System.out.println("Generating parser and parsing...");
		jsonParser = new Parser(assetManager);
		movies = jsonParser.getMovies();

		this.updateLists();

		this.setTitleCorrectly();

	}

	/**
	 * // ---------------------------------------------------------------------
	 * This is an adapter class for the list view of movies. This is a custom
	 * adapter for handling the interaction with the list of movies in the view.
	 * 
	 * @author Oliver
	 * @version Nov 30, 2013
	 */
	private class StableArrayAdapter extends ArrayAdapter<String> {
		// Create hashmap to associate the title of movie with a position in
		// list.
		HashMap<String, Integer> mIdMap = new HashMap<String, Integer>();

		// Create adapter for interacting with the titles
		public StableArrayAdapter(Context context, int textViewResourceId,
				List<String> strings) {
			super(context, textViewResourceId, strings);
			// Add all the titles to the map
			if ((strings != null) && (strings.size() > 0)) {
				for (int ii = 0; ii < strings.size(); ii++) {
					mIdMap.put(strings.get(ii), ii);
				}
			}
		}

	}

	/**
	 * Custom listener for the listview of movies. This is used to get all the
	 * movies and listen for which is clicked.
	 * 
	 * @author F-16
	 * 
	 */
	private class OnItemClickListenerImplementation implements
			OnItemClickListener {
		ArrayList<Movie> m;

		/**
		 * This method stores the movies
		 * 
		 * @param moviesToField
		 *            the movies to store in the field
		 */
		public OnItemClickListenerImplementation(ArrayList<Movie> moviesToField) {
			m = moviesToField;
		}

		/**
		 * This method is called when a movie is clicked on.
		 */
		public void onItemClick(AdapterView<?> av, View v, int i, long l) {
			onItemClick(av, v, i, l);
		}

	}

	/**
	 * This method gets the list of movie titles for the list of the button that
	 * was clicked. (Gets all titles for the listview to display)
	 */
	public void pullMoviesFromListFile() {

		// Pull movies from list from file.
		textParser = new TextFileParser(this.getBaseContext());
		textParser.getStringFromFiles(listname);
		// Get correct list
		if (listname.equals("toWatch")) {
			toWatch = textParser.getList(listname);
		} else if (listname.equals("watched")) {
			watched = textParser.getList(listname);
		} else if (listname.equals("favorite")) {
			favorite = textParser.getList(listname);
		} else if (listname.equals("search")) {
			favorite = jsonParser.getTitlesList();
		}

	}

	/**
	 * This method sets up the whole listview display. Getting movies to list
	 * and setting up a listener
	 */
	public void setupListView() {
		// Get listview from layout
		final ListView listView = (ListView) findViewById(R.id.listView);
		// set correct list to pass to adapter to display in view
		ArrayList<String> arrayAdapterList = jsonParser.getTitlesList();
		if (listname.equals("watched")) {
			arrayAdapterList = watched;
		}
		if (listname.equals("toWatch")) {
			arrayAdapterList = toWatch;
		}
		if (listname.equals("favorite")) {
			arrayAdapterList = favorite;
		}
		// Initialize and set adapter for interacting with the listview.
		final StableArrayAdapter adapter = new StableArrayAdapter(this,
				android.R.layout.simple_list_item_1, arrayAdapterList);
		listView.setAdapter(adapter);

		// Setup custom listener for the list of movies
		listView.setOnItemClickListener(new OnItemClickListenerImplementation(
				this.movies) {
			// **Start up movie activity if a movie was clicked on
			@Override
			public void onItemClick(AdapterView<?> parent, final View view,
					int position, long id) {
				// Get the movie title that was clicked
				final String item = (String) parent.getItemAtPosition(position);
				// Start intent for details of movie clicked
				Intent intent = new Intent(getApplicationContext(),
						DetailedMovieActivity.class);
				// Get movie object that has the same title as the one clicked
				Movie movieToDetail = jsonParser.getMovieFromTitle(item);
				// Pass all details to intents before starting
				intent.putExtra("movieTitle", item);
				// Create parcel to pass to next activity
				ParcelableImplementation[] parcelableArray = {
						new ParcelableImplementation(movieToDetail.getTitle()),
						new ParcelableImplementation(movieToDetail
								.getSimplePlot()),
						new ParcelableImplementation(movieToDetail.getType()),
						new ParcelableImplementation(
								stringArrayToString(movieToDetail
										.getDirectors())),
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

				// If a special list then expect a result upon exit.
				// The result is to update the list incase a movie was removed
				// from the list
				if ((listname.equals("toWatch"))
						|| (listname.equals("watched") || (listname
								.equals("favorite")))) {
					startActivityForResult(intent, 0);
				} else {
					startActivity(intent);
				}
			}

			/**
			 * Helper method for passing string arrays into detailed view
			 * Turns string array into long string
			 * @param stringArray the array to convert
			 * @return the single, long string
			 */
			private String stringArrayToString(String[] stringArray) {
				StringBuilder sb = new StringBuilder();
				if (stringArray.length < 1) {
					return "";
				}
				// Concatenate the string elements
				for (String ss : stringArray) {
					sb.append(ss + ", ");
				}
				String returnString = sb.toString();
				return returnString.substring(0, returnString.length() - 2);

			}
		});
	}

	// _________________________________________________________________________

	/**
	 * This method is called when the movie detailed view is exited.
	 * It analyzes the result and determines whether to update the listview
	 */
	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		System.out.println(resultCode);
		boolean[] update = data.getBooleanArrayExtra("update");
		if (update[0]) {
			this.updateLists();
		}
	}

	// Make title of lists in action bar look pretty
	public void setTitleCorrectly() {
		if (listname.equals("watched")) {
			setTitle("Watched List");
		} else if (listname.equals("toWatch")) {
			setTitle("Want To Watch List");
		} else if (listname.equals("favorite")) {
			setTitle("Favorite List");
		} else {
			setTitle("All Movie List");
		}
	}

	// Pull the movies for the list again and setup the listview again
	// with the new list of movies.
	public void updateLists() {
		// Get movies for this list from internal memory
		this.pullMoviesFromListFile();

		// ListView Setup and Control
		this.setupListView();
	}

	/**
	 * This method is called when the onscreen back button is clicked.
	 * It 
	 */
	public boolean onOptionsItemSelected(MenuItem item) {
		Intent myIntent = new Intent(getApplicationContext(),
				MainMovieActivity.class);
		startActivity(myIntent);
		return true;
	}
}
