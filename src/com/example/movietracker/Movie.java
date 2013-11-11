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
    private String simplePlot;
    private String title;
    private String director;
    private String actor;
    private String linkUrl;
    private String rating;
    private String imgUrl;
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
        return simplePlot;
    }
    // ----------------------------------------------------------
    /**
     * sets a one sentence plot summary of any movie
     * @param simplePlot is the simple plot summary that will be set
     */
    public void setSimplePlot(String simplePlot)
    {
        this.simplePlot = simplePlot;
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
    public String getRating()
    {
        return rating;
    }
    // ----------------------------------------------------------
    /**
     * sets the rating of film
     * @param rating is the rating associated with this film
     */
    public void setRating(String rating)
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

}
