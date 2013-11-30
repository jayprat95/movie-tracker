package com.example.movietracker;

import android.os.Parcel;
import android.os.Parcelable;

public class ParcelableImplementation implements Parcelable
{

    private String stringToMove;

    public ParcelableImplementation(String t) {
        this.stringToMove = t;
    }

    public static final Parcelable.Creator<ParcelableImplementation> CREATOR = new Parcelable.Creator<ParcelableImplementation>() {
        public ParcelableImplementation createFromParcel(Parcel in) {
            String s = in.readString();
            return new ParcelableImplementation(s);
        }
        public ParcelableImplementation[] newArray(int size) {
            return new ParcelableImplementation[size];
        }
    };

    @Override
    public int describeContents()
    {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void writeToParcel(Parcel out, int flags)
    {
        out.writeString(stringToMove);
    }

    private ParcelableImplementation(Parcel in) {
        this.stringToMove = in.readString();
    }

    public String getString() {
        return this.stringToMove;
    }




    public String stringArrayToString(String[] stringArray)
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

}
