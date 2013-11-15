package com.example.movietracker;

// -------------------------------------------------------------------------
/**
 *  Write a one-sentence summary of your class here.
 *  Follow it with additional details about its purpose, what abstraction
 *  it represents, and how to use it.
 *
 *  @author jayanthprathipati
 *  @version Nov 10, 2013
 */

public class Movie
{
    private String plot_simple;
    private String title;
    private String director;
    private String actor;
    private String linkUrl;
    private float rating;
    private String imgUrl;
    private float rating_count;
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
    public String getDirector()
    {
        return director;
    }
    // ----------------------------------------------------------
    /**
     * sets the director
     * @param director
     */
    public void setDirector(String director)
    {
        this.director = director;
    }
    // ----------------------------------------------------------
    /**
     * gets the actors in the film
     * @return returns the actors in this film
     */
    public String getActor()
    {
        return actor;
    }
    // ----------------------------------------------------------
    /**
     * sets the actors associated with this film
     * @param actor is the string representation of the actors
     */
    public void setActor(String actor)
    {
        this.actor = actor;
    }
    // ----------------------------------------------------------
    /**
     * This is the imdb link associated with this film
     * @return returns the string representation for this url
     */
    public String getLinkUrl()
    {
        return linkUrl;
    }
    // ----------------------------------------------------------
    /**
     * sets the imdb link associated with this flm
     * @param linkUrl is the link that will be set
     */
    public void setLinkUrl(String linkUrl)
    {
        this.linkUrl = linkUrl;
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
     * @return returns a url for the poster image for this movie
     */
    public String getImgUrl()
    {
        return imgUrl;
    }
    // ----------------------------------------------------------
    /**
     * sets the image url for this movie
     * @param imgUrl is the url for the poster image
     */
    public void setImgUrl(String imgUrl)
    {
        this.imgUrl = imgUrl;
    }
    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     * @return
     */
    public float getRatingCount()
    {
        return rating_count;
    }
    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     * @param ratingCount
     */
    public void setRatingCount(int ratingCount)
    {
        this.rating_count = rating_count;
    }



}
