package org.example;

import java.util.ArrayList;

class TVShow {
    private String title;
    private String genre;
    private int releaseYear;
    private double imdbScore;
    private double duration;

    //private ArrayList<String> cast;

    public TVShow(String title,String genre,int releaseYear,double imdbScore,int duration){
        this.title = title;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.imdbScore = imdbScore;
        this.duration = duration;
        //this.cast = cast;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public double getImdbScore() {
        return imdbScore;
    }

    public double getDuration() {
        return duration;
    }

    /*public ArrayList<String> getCast() {
        return cast;
    }*/


    /*
     *The TVShow should have a title , genre, release year, duration and a rating.
     *The TVShow should have an ArrayList of the cast.
     */

}
