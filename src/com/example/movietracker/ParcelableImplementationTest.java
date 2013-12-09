package com.example.movietracker;

import junit.framework.TestCase;

// -------------------------------------------------------------------------
/**
 * This class tests the Parcelable implementation class, which allows us to pick
 * and choose specific fields from the Movie JSON files, such as RunTime of the
 * film, or a list of actors in the film.
 * 
 * 
 * @author Jayanth Prathipati (jayanth)
 * @author Oliver Ebeling-Koning (odek)
 * @author Linsay Boylan (lindsb7)
 * @version 2013.12.08
 */

public class ParcelableImplementationTest extends TestCase {

	private ParcelableImplementation pi;
	private String toMove;

	// ----------------------------------------------------------
	/**
	 * The setup for the testing
	 */
	protected void setUp() throws Exception {
		super.setUp();
		toMove = "test";
		pi = new ParcelableImplementation(toMove);
	}

	/**
	 * Test method for ParcelableImplementation(}
	 */
	public void testParcelableImplementation() {
		assertEquals("test", pi.getString());
	}

	/**
	 * Test method for describeContents
	 */
	public void testDescribeContents() {
		assertEquals(0, pi.describeContents());
	}

	/**
	 * Test method for getString
	 */
	public void testGetString() {
		toMove = "move";
		pi = new ParcelableImplementation(toMove);
		// retrieve string and assert
		assertEquals("move", pi.getString());
	}

	/**
	 * Test method for stringArrayToString
	 */
	public void testStringArrayToString() {
		String[] string = new String[3];
		string[0] = "a";
		string[1] = "b";
		string[2] = "c";
		assertEquals(pi.stringArrayToString(string), "a, b, c");
		String[] string2 = new String[1];
		string2[0] = "a";
		assertEquals(pi.stringArrayToString(string2), "a");
	}

}
