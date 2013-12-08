package com.example.movietracker;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * This class implements Parcelable and is used to store strings. It is used to
 * pass movie data between activities.
 * 
 * @author F-16
 * 
 */
public class ParcelableImplementation implements Parcelable {
	// ~Fields........................................
	private String stringToMove;

	// ~Methods..........................................
	/**
	 * This is a constructor and holds the string to store.
	 * @param t the string to store
	 */
	public ParcelableImplementation(String t) {
		this.stringToMove = t;
	}

	/**
	 * These are implemented methods from the Parcelable class
	 */
	public static final Parcelable.Creator<ParcelableImplementation> CREATOR = 
			new Parcelable.Creator<ParcelableImplementation>() {
		/**
		 * Convert from the string to store to a parcel.
		 */
		public ParcelableImplementation createFromParcel(Parcel in) {
			String s = in.readString();
			return new ParcelableImplementation(s);
		}

		public ParcelableImplementation[] newArray(int size) {
			return new ParcelableImplementation[size];
		}
	};

	/**
	 * This method overrides the Parcelable describeContents
	 */
	@Override
	public int describeContents() {
		return 0;
	}

	/**
	 * This method overrides the writeToParcel inorder to store
	 * the string
	 */
	@Override
	public void writeToParcel(Parcel out, int flags) {
		out.writeString(stringToMove);
	}


	/**
	 * This method is used to get the string passed in back out
	 */
	public String getString() {
		return this.stringToMove;
	}

	/**
	 * This method enables this Parcelable Implementation to 
	 * store an array of movie data.
	 * It turns the array into one string while moving activities.
	 * @param stringArray the array to store
	 * @return the single string that needs to be stored
	 */
	public String stringArrayToString(String[] stringArray) {
		StringBuilder sb = new StringBuilder();
		if (stringArray.length < 1) {
			return "";
		}
		// concatenate all strings with "," as a delimiter
		for (String ss : stringArray) {
			sb.append(ss + ", ");
		}
		String returnString = sb.toString();
		return returnString.substring(0, returnString.length() - 2);

	}

}
