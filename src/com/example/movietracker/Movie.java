package com.example.movietracker;

import java.io.Serializable;
import java.util.Map;

// -------------------------------------------------------------------------
/**
 *  Write a one-sentence summary of your class here.
 *  Follow it with additional details about its purpose, what abstraction
 *  it represents, and how to use it.
 *
 *  @author jayanthprathipati
 *  @author oliverebeling-koning
 *  @author linsayboylan
 *  @version Nov 15, 2013
 */

public class Movie implements Serializable
{
    private String plot_simple;
    private String title;
    private String type;
    private String[] directors;
    private String[] actors;
    private String[] runtime;
    private String imdb_url;
    private int release_date;
    private float rating;
    private float rating_count;
    private Map<String, String> poster;
    // ----------------------------------------------------------
    /**
     * Create a new Movie object.
     */
    public Movie()
    {

    }
    // ----------------------------------------------------------
    /**
     * gets a one sentence plot summary of any movie
     * @return returns the plot summary
     */
    public String getSimplePlot()
    {
        return plot_simple;
    }
    // ----------------------------------------------------------
    /**
     * sets a one sentence plot summary of any movie
     * @param plot_simple is the simple plot summary that will be set
     */
    public void setSimplePlot(String plot_simple)
    {
        this.plot_simple = plot_simple;
    }
    // ----------------------------------------------------------
    /**
     * Gets the title of the film
     * @return returns the title
     */
    public String getTitle()
    {
        return title;
    }
    // ----------------------------------------------------------
    /**
     * Sets the title of the film
     * @param title is the title that will be set
     */
    public void setTitle(String title)
    {
        this.title = title;
    }
    // ----------------------------------------------------------
    /**
     * Gets the director of the film
     * @return returns string representing the director
     */
    public String[] getDirectors()
    {
        return directors;
    }
    // ----------------------------------------------------------
    /**
     * sets the directors
     * @param directors
     */
    public void setDirectors(String[] directors)
    {
        this.directors = directors;
    }
    // ----------------------------------------------------------
    /**
     * gets the actors in the film
     * @return returns the actors in this film
     */
    public String[] getActors()
    {
        return actors;
    }
    // ----------------------------------------------------------
    /**
     * sets the actors associated with this film
     * @param actors is the string representation of the actors
     */
    public void setActor(String[] actors)
    {
        this.actors = actors;
    }
    // ----------------------------------------------------------
    /**
     * This is the imdb link associated with this film
     * @return returns the string representation for this url
     */
    public String getImdb_url()
    {
        return imdb_url;
    }
    // ----------------------------------------------------------
    /**
     * sets the imdb link associated with this flm
     * @param imdb_url is the link that will be set
     */
    public void setImdb_url(String imdb_url)
    {
        this.imdb_url = imdb_url;
    }
    // ----------------------------------------------------------
    /**
     * gets the rating of this movie
     * @return returns the rating of this film
     */
    public float getRating()
    {
        return rating;
    }
    // ----------------------------------------------------------
    /**
     * sets the rating of film
     * @param rating is the rating associated with this film
     */
    public void setRating(int rating)
    {
        this.rating = rating;
    }
    // ----------------------------------------------------------
    /**
     * gets the image url for this movie
     * @return the year it was released
     */
    public int getRelease_date()
    {
        return release_date;
    }
    // ----------------------------------------------------------
    /**
     * sets the image url for this movie
     * @param release_date the year it was released
     */
    public void setRelease_date(int release_date)
    {
        this.release_date = release_date;
    }
    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     * @return the rating count
     */
    public float getRatingCount()
    {
        return rating_count;
    }
    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     * @param rating_count the count of ratings to store
     */
    public void setRatingCount(int rating_count)
    {
        this.rating_count = rating_count;
    }
    /**
     * Place a description of your method here.
     * @return the movie length
     */
    public String[] getRuntime()
    {
        return runtime;
    }
    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     * @param runtime the movie length
     */
    public void setRuntime(String[] runtime)
    {
        this.runtime = runtime;
    }


    /**
     * Place a description of your method here.
     * @return the poster url
     */
    public Map<String, String> getPoster()
    {
        return poster;
    }
    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     * @param poster poster url
     */
    public void setPoster(Map<String, String> poster)
    {
        this.poster = poster;
    }

    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     * @return the type (M, PG, PG13)
     */
    public String getType()
    {
        return type;
    }
    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     * @param type the type
     */
    public void setType(String type)
    {
        this.type = type;
    }



}
