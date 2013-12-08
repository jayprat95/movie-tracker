package com.example.movietracker;

import android.widget.RatingBar;
import java.io.IOException;
import android.graphics.BitmapFactory;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.URLConnection;
import java.net.URL;
import android.graphics.Bitmap;
import android.widget.ImageView;
import android.text.method.ScrollingMovementMethod;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Parcelable;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import java.util.ArrayList;

import android.app.ActionBar;
import android.app.Activity;

/**
 * This class displays details of a movie.
 * The class has the ability to add and remove the 
 * movie from stored lists.
 * @author F-16
 *
 */
public class DetailedMovieActivity extends Activity {
	
	// ~Fields............................................................
	private AssetManager assetManager;
	private Intent currentIntent;
	private String movieString;
	private Parcelable[] movieDataParcelable;
	private ParcelableImplementation movieData;
	private TextFileParser textParser;
	private TextFileParser updateMarksParser;
	private Movie theMovie;
	private boolean updateList[];
	// ~~~Fields for Widgets
	private TextView title;
	private TextView plotSimple;
	private TextView type;
	private TextView directors;
	private TextView actors;
	private TextView runtime;


	// ~Methods...........................................................

	/**
	 * This method sets up the activity. It initializes and sets up
	 * listeners, variables, and texts.
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// Initialize signal to update lists after exiting movie
		updateList = new boolean[1];
		updateList[0] = false;

		super.onCreate(savedInstanceState);
		assetManager = this.getAssets();
		setContentView(R.layout.detailed_movie_view);
		
		// Setup button on action bar
        ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        this.getAllMovieDataPassedIn();
        
		this.setupListeners();

		this.updateCheckMarks();

		this.setTitle(this.formatTitle());
	}

	/**
	 * This method sets up the listeners for when a button is clicked
	 * It then writes to internal memory with the textParser when a 
	 * button is clicked. A toast is also displayed.
	 */
	public void setupListeners() {

		// Open TextFileParser for adding or removing movies from buttons.
		textParser = new TextFileParser(this.getBaseContext());

		// ....................................................................
		// Adding movie to list watched
		Button watched = (Button) findViewById(R.id.watchedButton);
		watched.setOnClickListener(new Button.OnClickListener() {
			@Override
			public void onClick(View v) {
				updateList[0] = true;

				textParser.getStringFromFiles("watched");
				ArrayList<String> temp = textParser.getList("watched");
				// Adding movie from list
				if ((temp != null) && (!(temp.contains(movieString)))) {
					temp.add(movieString);
					DetailedMovieActivity.this.displayToast("Adding " + movieString + "\nto \"Watched\" List");
					textParser.setMovieList(temp, "watched");
				}
				// Removing movie from list
				else if ((temp != null) && (temp.contains(movieString))) {
					temp.remove(movieString);
					DetailedMovieActivity.this.displayToast("Removing " + movieString + "\nto \"Watched\" List");
					textParser.setMovieList(temp, "watched");
				}

				// update the checkmarks if it was added to the list
				DetailedMovieActivity.this.updateCheckMarks();
			}
		});

		// Adding movie to list favorite
		Button toWatch = (Button) findViewById(R.id.toWatchButton);
		toWatch.setOnClickListener(new Button.OnClickListener() {
			@Override
			public void onClick(View v) {
				updateList[0] = true;

				textParser.getStringFromFiles("toWatch");
				ArrayList<String> temp = textParser.getList("toWatch");
				// Adding movie from list
				if ((temp != null) && (!(temp.contains(movieString)))) {
					temp.add(movieString);
					DetailedMovieActivity.this.displayToast("Adding " + movieString + "\nto \"Want to watch\" List");
					textParser.setMovieList(temp, "toWatch");
				}
				// Removing movie from list
				else if ((temp != null) && (temp.contains(movieString))) {
					temp.remove(movieString);
					DetailedMovieActivity.this.displayToast("Removing " + movieString + "\nto \"Want to watch\" List");
					textParser.setMovieList(temp, "toWatch");
				}

				// update the checkmarks if it was added to the list
				DetailedMovieActivity.this.updateCheckMarks();
			}
		});

		// Adding movie to list favorite
		Button favorite = (Button) findViewById(R.id.favoriteButton);
		favorite.setOnClickListener(new Button.OnClickListener() {
			@Override
			public void onClick(View v) {
				updateList[0] = true;

				textParser.getStringFromFiles("favorite");
				ArrayList<String> temp = textParser.getList("favorite");
				// Adding movie from list
				if ((temp != null) && (!(temp.contains(movieString)))) {
					temp.add(movieString);
					DetailedMovieActivity.this.displayToast("Adding " + movieString + "\nto \"Favorite\" List");
					textParser.setMovieList(temp, "favorite");
				}
				// Removing movie from list
				else if ((temp != null) && (temp.contains(movieString))) {
					temp.remove(movieString);
					DetailedMovieActivity.this.displayToast("Removing " + movieString + "\nto \"Favorite\" List");
					textParser.setMovieList(temp, "favorite");
				}

				// update the checkmarks if it was added to the list
				DetailedMovieActivity.this.updateCheckMarks();
			}
		});

	}

	/**
	 * This method converts a picture url to a bitmap to display.
	 * @param url the picture url
	 * @return the Bitmap created
	 */
	private Bitmap getImageBitmap(String url) {
		Bitmap bm = null;
		// Try to pull from the url
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
	 * This method updates the checkmarks if the movie was added
	 * to a list or removed from a list.
	 * The updating pulls the movies from internal memory and 
	 * hides the check if it is not found for that list.
	 */
	public void updateCheckMarks() {
		// Get connection to internal memory to check lists
		updateMarksParser = new TextFileParser(this.getBaseContext());

		// Update watched checkbox
		updateMarksParser.getStringFromFiles("watched");
		ArrayList<String> temp = updateMarksParser.getList("watched");
		ImageView watchedBox = new ImageView(this);
		watchedBox = (ImageView) findViewById(R.id.watchedCheckBox);
		if ((temp != null) && (temp.contains(movieString))) {
			watchedBox.setVisibility(View.VISIBLE);
		} else {
			watchedBox.setVisibility(View.INVISIBLE);
		}

		// Update toWatch checkbox
		updateMarksParser.getStringFromFiles("toWatch");
		temp = updateMarksParser.getList("toWatch");
		ImageView toWatchBox = new ImageView(this);
		toWatchBox = (ImageView) findViewById(R.id.toWatchCheckBox);
		if ((temp != null) && (temp.contains(movieString))) {
			toWatchBox.setVisibility(View.VISIBLE);
		} else {
			toWatchBox.setVisibility(View.INVISIBLE);
		}

		// Update favorite checkbox
		updateMarksParser.getStringFromFiles("favorite");
		temp = updateMarksParser.getList("favorite");
		ImageView favoriteBox = new ImageView(this);
		favoriteBox = (ImageView) findViewById(R.id.favoriteCheckBox);
		if ((temp != null) && (temp.contains(movieString))) {
			favoriteBox.setVisibility(View.VISIBLE);
		} else {
			favoriteBox.setVisibility(View.INVISIBLE);
		}

	}

	
	
	

	//.............................Formatting Methods......................
	/**
	 * This method formats the title. It just changes the first letter to 
	 * a capital.
	 * @return the capitalized title
	 */
	public String formatTitle() {
		if (movieString.length() < 2) {
			return movieString;
		}
		return this.movieString.substring(0, 1).toUpperCase()
				+ this.movieString.substring(1, movieString.length());
	}
	
	/**
	 * This method shows the runtime in hours and minutes instead
	 * of just minutes
	 * @param rt the string in minutes
	 * @return the string in hours and minutes
	 */
	public String formatRuntime(String rt) {
		int time = Integer.parseInt(rt.substring(0, rt.length() - 4));
		int hours = 0;
		if (time < 60) {
			return rt;
		}
		while (time >= 60) {
			hours++;
			time -= 60;
		}
		return Integer.toString(hours) + " hours " + Integer.toString(time) + " minutes";
		
	}

	/**
	 * This converts the release date to a readable format
	 * @param string the string of the release date
	 * @return the formatted release date
	 */
	private String formatDate(String string) {
		if (string.length() != 8) {
			return "";
		}
		String year = string.substring(0, 4);
		String month = string.substring(4, 6);
		String day = string.substring(6, 8);
		return day + "/" + month + "/" + year;

	}

	
	
	
	//.............................Navigation Methods......................
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
	
	/**
	 * This method decides the execution when the onscreen back button is clicked.
	 * It notifies the list to update or not
	 */
	public boolean onOptionsItemSelected(MenuItem item){
		// Create new intent to passback data.
	    Intent intent = new Intent(getApplicationContext(), ListMovieActivity.class);
	    intent.putExtra("update", updateList);
	    setResult(RESULT_OK, intent);
	    finish();
	    return true;

	}
	
	/**
	 * This method gets all the data for the movie to display from the list
	 * activity
	 */
	public void getAllMovieDataPassedIn() {
		// Get extra parameter of the movie name.
		currentIntent = getIntent();
		movieString = currentIntent.getStringExtra("movieTitle");
		movieDataParcelable = currentIntent
				.getParcelableArrayExtra("movieData");
		
		
		// ******** Get all data passed in and set Texts.*******

		// New piece of Data: Title
		// Convert movie data to custom parcelable class.
		movieData = (ParcelableImplementation) movieDataParcelable[0];
		title = new TextView(this);
		title = (TextView) findViewById(R.id.title);
		title.setText(movieData.getString());

		// New piece of Data: Simple Plot
		// Convert movie data to custom parcelable class.
		movieData = (ParcelableImplementation) movieDataParcelable[1];
		plotSimple = new TextView(this);
		plotSimple = (TextView) findViewById(R.id.plotSimple);
		plotSimple.setText(movieData.getString());

		// New piece of Data: Directors
		// Convert movie data to custom parcelable class.
		movieData = (ParcelableImplementation) movieDataParcelable[3];
		directors = new TextView(this);
		directors = (TextView) findViewById(R.id.directors);
		directors.setText("Directed by: " + movieData.getString());

		// New piece of Data: Actors
		// Convert movie data to custom parcelable class.
		movieData = (ParcelableImplementation) movieDataParcelable[4];
		actors = new TextView(this);
		actors = (TextView) findViewById(R.id.actors);
		actors.setText("Actors: " + movieData.getString());
		actors.setMovementMethod(new ScrollingMovementMethod());

		// New piece of Data: Runtime
		// Convert movie data to custom parcelable class.
		movieData = (ParcelableImplementation) movieDataParcelable[5];
		runtime = new TextView(this);
		runtime = (TextView)findViewById(R.id.runtime);
		runtime.setText(this.formatRuntime(movieData.getString()));

		// New piece of Data: Imdb url
		// Convert movie data to custom parcelable class.
		movieData = (ParcelableImplementation) movieDataParcelable[6];
		type = new TextView(this);
		// type = (TextView)findViewById(R.id.imdb_url);
		type.setText(movieData.getString());

		// New piece of Data: Released Date
		// Convert movie data to custom parcelable class.
		movieData = (ParcelableImplementation) movieDataParcelable[7];
		type = new TextView(this);
		type = (TextView) findViewById(R.id.releaseDate);
		type.setText("Released on: " + formatDate(movieData.getString()));

		// New piece of Data: Rating
		// Convert movie data to custom parcelable class.
		movieData = (ParcelableImplementation) movieDataParcelable[8];
		RatingBar ratingsBar = (RatingBar)findViewById(R.id.movieRatings);
		ratingsBar.setAlpha((float)0.4);
		ratingsBar.setEnabled(false);
		Float rating = Float.parseFloat(movieData.getString());
		ratingsBar.setRating(rating / 2);
		// type.setText(movieData.getString());

		// New piece of Data: Rating Count
		// Convert movie data to custom parcelable class.
		movieData = (ParcelableImplementation) movieDataParcelable[9];
		type = new TextView(this);
		// type = (TextView)findViewById(R.id.ratingCount);
		type.setText(movieData.getString());

		// New piece of Data: Picture url imdb
		// Convert movie data to custom parcelable class.
		movieData = (ParcelableImplementation) movieDataParcelable[10];
		ImageView iv = new ImageView(this);
		iv = (ImageView) findViewById(R.id.pictureImdb);

		iv.setImageBitmap(getImageBitmap(movieData.getString()));

		// New piece of Data: Picture url cover
		// Convert movie data to custom parcelable class.
		movieData = (ParcelableImplementation) movieDataParcelable[11];
		type = new TextView(this);
		// type = (TextView)findViewById(R.id.pictureCover;
		// type.setText(movieData.getString());

	}
	
	/**
	 * This method displays a toast pop up quickly
	 * @param string the text to show
	 */
	public void displayToast(String string) {
		Context context = getApplicationContext();
		CharSequence text = string;
		int duration = Toast.LENGTH_SHORT;
		Toast.makeText(context, text, duration).show();
	}

}
