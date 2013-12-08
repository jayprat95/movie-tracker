package com.example.movietracker;

import android.app.Activity;
import android.content.Intent;
import android.widget.ImageView;
import android.widget.Button;
import android.widget.TextView;
import junit.framework.TestCase;
import android.test.*;
import android.app.Instrumentation;

// -------------------------------------------------------------------------
/**
 * This method tests the DetailedMovieActivity. It performs normal activities on
 * the detailed view.
 * 
 * @author jayanth
 * @version Dec 4, 2013
 */

public class DetailedMovieActivityTest extends
		ActivityInstrumentationTestCase2<DetailedMovieActivity> {
	@SuppressWarnings("deprecation")
	public DetailedMovieActivityTest() {
		super("com.DetailedMovieActivity", DetailedMovieActivity.class);
	}

	public DetailedMovieActivityTest(Class<DetailedMovieActivity> activityClass) {
		super(activityClass);
	}

	// ~Fields................................................................
	private DetailedMovieActivity dma;
	private Intent intent;
	private Instrumentation mInstrumentation;

	// Widgets
	private TextView title;
	private TextView plotSimple;
	private TextView directors;
	private TextView actors;
	private TextView releaseDate;
	private Button watchedButton;
	private Button favoriteButton;
	private Button toWatchButton;
	private ImageView watchedCheckBox;
	private ImageView favoriteCheckBox;
	private ImageView toWatchCheckBox;
	private ImageView pictureImdb;

	// ----------------------------------------------------------
	protected void setUp() throws Exception {
		super.setUp();

		// Simulate the activity being called from the previous activity
		this.mInstrumentation = getInstrumentation();
		intent = new Intent();
		intent = new Intent(mInstrumentation.getContext(),
				DetailedMovieActivity.class);
		// Pass all details to intents before starting
		String item = "movie";
		intent.putExtra("movieTitle", item);
		ParcelableImplementation[] parcelableArray = {
				new ParcelableImplementation("t"),
				new ParcelableImplementation("p"),
				new ParcelableImplementation("t"),
				new ParcelableImplementation("d"),
				new ParcelableImplementation("a"),
				new ParcelableImplementation("60 min"),
				new ParcelableImplementation("u"),
				new ParcelableImplementation("20130812"),
				new ParcelableImplementation(Float.toString(5)),
				new ParcelableImplementation(Float.toString(5)),
				new ParcelableImplementation(
						"http://ia.media-imdb.com/images/M/MV5BMT"
								+ "QwNTU3MTE4NF5BMl5BanBnXkFtZTcwOT"
								+ "gxNDM2Mg@@._V1_SX214_.jpg"),
				new ParcelableImplementation("c") };
		intent.putExtra("movieData", parcelableArray);
		setActivityIntent(intent);
		dma = this.getActivity();

		// Get all buttons
		title = (TextView) dma.findViewById(R.id.title);
		plotSimple = (TextView) dma.findViewById(R.id.plotSimple);
		directors = (TextView) dma.findViewById(R.id.directors);
		actors = (TextView) dma.findViewById(R.id.actors);
		releaseDate = (TextView) dma.findViewById(R.id.releaseDate);
		watchedButton = (Button) dma.findViewById(R.id.watchedButton);
		toWatchButton = (Button) dma.findViewById(R.id.toWatchButton);
		favoriteButton = (Button) dma.findViewById(R.id.favoriteButton);
		watchedCheckBox = (ImageView) dma.findViewById(R.id.watchedCheckBox);
		toWatchCheckBox = (ImageView) dma.findViewById(R.id.toWatchCheckBox);
		favoriteCheckBox = (ImageView) dma.findViewById(R.id.favoriteCheckBox);
		pictureImdb = (ImageView) dma.findViewById(R.id.pictureImdb);

	}

	/**
	 * Test method for the setting up of the activity
	 * {@link com.example.movietracker.DetailedMovieActivity#onCreate(android.os.Bundle)}
	 * .
	 */
	public void testOnCreateBundle() {
		assertEquals(dma.getTitle(), "Movie");
	}

	/**
	 * This method checks adding and removing from lists by checking the boxes.
	 */
	public void testCheckBoxes() {
		// Checking boxes
		assertFalse(watchedCheckBox.isShown());
		assertFalse(toWatchCheckBox.isShown());
		assertFalse(favoriteCheckBox.isShown());
		try {
			runTestOnUiThread(new Runnable() {
				public void run() {
					watchedButton.performClick();
				}
			});
			runTestOnUiThread(new Runnable() {
				public void run() {
					toWatchButton.performClick();
				}
			});
			runTestOnUiThread(new Runnable() {
				public void run() {
					favoriteButton.performClick();
				}
			});
		} catch (Throwable e) {
			System.out.println("Could not click button");
			e.printStackTrace();
		}
		assertTrue(watchedCheckBox.isShown());
		assertTrue(toWatchCheckBox.isShown());
		assertTrue(favoriteCheckBox.isShown());

		// Unchecking
		try {
			runTestOnUiThread(new Runnable() {
				public void run() {
					watchedButton.performClick();
				}
			});
			runTestOnUiThread(new Runnable() {
				public void run() {
					toWatchButton.performClick();
				}
			});
			runTestOnUiThread(new Runnable() {
				public void run() {
					favoriteButton.performClick();
				}
			});
		} catch (Throwable e) {
			System.out.println("Could not click button");
			e.printStackTrace();
		}
		assertFalse(watchedCheckBox.isShown());
		assertFalse(toWatchCheckBox.isShown());
		assertFalse(favoriteCheckBox.isShown());
	}

	/**
	 * This method checks some of the text vies to make sure they are pulling
	 * correctly.
	 */
	public void testFieldWidgets() {
		assertEquals("t", title.getText());
		assertEquals("p", plotSimple.getText());
		assertEquals("Directed by: d", directors.getText());
		assertEquals("Released on: 12/08/2013", releaseDate.getText());
	}
}
