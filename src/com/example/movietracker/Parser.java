package com.example.movietracker;

import java.io.Serializable;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.io.IOException;
import android.content.res.AssetManager;
import java.util.*;

// -------------------------------------------------------------------------
/**
 * This is a class that is used to parse json files in the assets folder into
 * movies. It also contains methods for searching the movies in the assets.
 * 
 * @author jayanthprathipati
 * @author oliverebeling-koning
 * @author linsayboylan
 * @version Nov 15, 2013
 */

public class Parser implements Serializable {

	/**
	 * The version of serialization in use
	 */
	private static final long serialVersionUID = 1L;
	
	// ~Fields.....................................................................
	private AssetManager assetManager;
	private List<String> filenames;
	private ArrayList<Movie> movies;
	private List<String> titles;

	// ~Methods....................................................................

	// ----------------------------------------------------------
	/**
	 * Create a new Parser object. This pulls all the .json files from the
	 * assets folder and converts them to a list of movie objects. It also
	 * creates a list of movie titles to make searching easier.
	 * 
	 * @param am
	 *            the assetmanager from the view
	 */
	public Parser(AssetManager am) {
		assetManager = am;
		filenames = new ArrayList<String>();
		titles = new ArrayList<String>();
		try {
			// For all asset files, if it is a json file then add to list
			for (String file : assetManager.list("")) {
				if (file.length() > 5) {
					// Add only json filenames to list
					if (file.substring(file.length() - 5, file.length())
							.equals(".json")) {
						filenames.add(file);
					}
				}
			}
		} catch (IOException e) {
			System.out.println("*No files or readable files in assets*");
			e.printStackTrace();
		}

		// Parse all the json files pulled from assets into movie objects
		movies = new ArrayList<Movie>();
		for (String file : this.filenames) {
			movies.add(this.jsonToMovies(file));
		}

		// Make easy list of titles to check through
		for (Movie movie : movies) {
			if (movies.size() > 0) {
				this.titles.add(movie.getTitle());
			}
		}

	}

	// ----------------------------------------------------------
	/**
	 * This method takes a filename and parses that json file into a movie
	 * object.
	 * 
	 * @param fileName
	 *            the name of the file to convert
	 * @return movie The movie created from file name passed in
	 */
	public Movie jsonToMovies(String fileName) {
		// Create stream and reader for parsing.
		BufferedReader reader = null;
		InputStream inputStream = null;

		// Try to open a stream from the specified file
		try {
			inputStream = assetManager.open(fileName);
		} catch (IOException e1) {
			System.out.println("cannot open drive.json");
			e1.printStackTrace();
		}

		// Try to create the reader from the open stream to the file.
		try {
			reader = new BufferedReader(new InputStreamReader(inputStream,
					"UTF-8"));
		} catch (UnsupportedEncodingException e) {
			System.out
					.println("cannot create bufferedReader from input stream");
			e.printStackTrace();
		}

		// Create Gson object to parse JSON.
		Gson gson = new Gson();

		// Parse JSON into a Movie Array. **This is an array of one** "Tricky"
		Movie[] response = gson.fromJson(reader, Movie[].class);

		// return new movie created.
		return response[0];
	}

	// ----------------------------------------------------------
	/**
	 * This method returns all the movie objects sorted alphabetically.
	 * 
	 * @return movies
	 */
	public ArrayList<Movie> getMovies() {

		return this.movies;
	}

	/**
	 * This method searches the movies pulled from assets for the title passed
	 * in.
	 * 
	 * @param title
	 *            the title to find
	 * @return if the title was found
	 */
	public boolean hasMovie(String title) {
		return titles.contains(title);
	}

	/**
	 * This method gets a movie object given a title
	 * 
	 * @param title
	 *            the title to find
	 * @return the movie object
	 */
	public Movie getMovieFromTitle(String title) {
		for (Movie movie : movies) {
			if (movie.getTitle().equals(title)) {
				return movie;
			}
		}
		// Movie not in list
		return null;
	}

	/**
	 * Getter for the list of titles of movies in the assets folder
	 * 
	 * @return the list of strings "titles"
	 */
	public ArrayList<String> getTitlesList() {
		if (titles.size() > 0) {
			return this.alphabetize((ArrayList<String>) titles);
		}
		return null;
	}

	/**
	 * This method is used to alphabetize the titles of movies
	 * @param theList the list of titles
	 * @return the sorted list of titles
	 */
	private ArrayList<String> alphabetize(ArrayList<String> theList) {
		Collections.sort(theList);
		return theList;
	}

}
