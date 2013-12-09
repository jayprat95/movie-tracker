package com.example.movietracker;

import android.widget.ListView;
import android.app.Activity;
import android.app.Instrumentation;
import android.app.Instrumentation.ActivityMonitor;
import android.content.Intent;
import android.test.ActivityInstrumentationTestCase2;

// -------------------------------------------------------------------------
/**
 * Write a one-sentence summary of your class here. Follow it with additional
 * details about its purpose, what abstraction it represents, and how to use it.
 * 
 *  @author Jayanth Prathipati (jayanth)
 *  @author Oliver Ebeling-Koning (odek)
 *  @author Linsay Boylan (lindsb7)
 *  @version 2013.12.08
 */

public class ListMovieActivityTest extends
		ActivityInstrumentationTestCase2<ListMovieActivity> {

	@SuppressWarnings("deprecation")
	public ListMovieActivityTest() {
		super("com.ListMovieActivity", ListMovieActivity.class);
	}

	public ListMovieActivityTest(Class<ListMovieActivity> activityClass) {
		super(activityClass);
	}

	// ~Fields................................................................
	private ListMovieActivity lmaWatched;
	private ListMovieActivity lmaToWatch;
	private ListMovieActivity lmaFavorite;
	private ListMovieActivity lmaSearch;
	private Intent intentWatched;
	private Intent intentToWatch;
	private Intent intentFavorite;
	private Intent intentSearch;
	private Instrumentation mInstrumentationWatched;
	private Instrumentation mInstrumentationToWatch;
	private Instrumentation mInstrumentationFavorite;
	private Instrumentation mInstrumentationSearch;

	// Widget fields
	private ListView listViewWatched;
	private ListView listViewToWatch;
	private ListView listViewFavorite;
	private ListView listViewSearch;

	// ----------------------------------------------------------
	protected void setUp() throws Exception {
		super.setUp();

		// ***Setup three activities***
		this.mInstrumentationWatched = getInstrumentation();
		intentWatched = new Intent();
		intentWatched = new Intent(mInstrumentationWatched.getContext(),
				ListMovieActivity.class);
		intentWatched.putExtra("listname", "watched");
		// ***
		this.mInstrumentationToWatch = getInstrumentation();
		intentToWatch = new Intent();
		intentToWatch = new Intent(mInstrumentationToWatch.getContext(),
				ListMovieActivity.class);
		intentToWatch.putExtra("listname", "toWatch");
		// ***
		this.mInstrumentationFavorite = getInstrumentation();
		intentFavorite = new Intent();
		intentFavorite = new Intent(mInstrumentationFavorite.getContext(),
				ListMovieActivity.class);
		intentFavorite.putExtra("listname", "favorite");
		// ***
		this.mInstrumentationSearch = getInstrumentation();
		intentSearch = new Intent();
		intentSearch = new Intent(mInstrumentationSearch.getContext(),
				ListMovieActivity.class);
		intentSearch.putExtra("listname", "search");
	}

	/**
	 * Test method for
	 * {@link com.example.movietracker.ListMovieActivity#onCreate(android.os.Bundle)}
	 * .
	 */
	public void testOnCreateBundleWatched() {
		setActivityIntent(intentWatched);
		lmaWatched = this.getActivity();
		listViewWatched = (ListView) lmaWatched.findViewById(R.id.listView);
		assertEquals(listViewWatched.getCount(), 0);
	}

	/**
	 * Test method for
	 * {@link com.example.movietracker.ListMovieActivity#onCreate(android.os.Bundle)}
	 * .
	 */
	public void testOnCreateBundleToWatch() {
		setActivityIntent(intentToWatch);
		lmaToWatch = this.getActivity();
		listViewToWatch = (ListView) lmaToWatch.findViewById(R.id.listView);
		assertEquals(listViewToWatch.getCount(), 0);
	}

	/**
	 * Test method for
	 * {@link com.example.movietracker.ListMovieActivity#onCreate(android.os.Bundle)}
	 * .
	 */
	public void testOnCreateBundleFavorite() {
		setActivityIntent(intentFavorite);
		lmaFavorite = this.getActivity();
		listViewFavorite = (ListView) lmaFavorite.findViewById(R.id.listView);
		assertEquals(listViewFavorite.getCount(), 0);
	}

	/**
	 * Test method for
	 * {@link com.example.movietracker.ListMovieActivity#onCreate(android.os.Bundle)}
	 * .
	 */
	public void testOnCreateBundleSearch() {
		setActivityIntent(intentSearch);
		lmaSearch = this.getActivity();
		listViewSearch = (ListView) lmaSearch.findViewById(R.id.listView);
		assertEquals(listViewSearch.getCount(), 10);
	}

	public void testClickOnMovie() {
		// Setup
		setActivityIntent(intentSearch);
		lmaSearch = this.getActivity();
		listViewSearch = (ListView) lmaSearch.findViewById(R.id.listView);

		ActivityMonitor activityMonitor = getInstrumentation().addMonitor(
				DetailedMovieActivity.class.getName(), null, false);
		try {
			runTestOnUiThread(new Runnable() {
				public void run() {
					listViewSearch.performItemClick(
							listViewSearch.getChildAt(0), 0,
							listViewSearch.getItemIdAtPosition(0));
				}
			});
		} catch (Throwable e) {
			System.out.println("Couldnt click movie");
			e.printStackTrace();
		}

		Activity nextActivity = getInstrumentation().waitForMonitorWithTimeout(
				activityMonitor, 30000);
		assertNotNull(nextActivity);
		nextActivity.finish();
	}

	public void testClickOnMovieNone() {
		// Setup
		setActivityIntent(intentWatched);
		lmaWatched = this.getActivity();
		listViewWatched = (ListView) lmaWatched.findViewById(R.id.listView);
		assertEquals(listViewWatched.getChildCount(), 0);

	}

}
