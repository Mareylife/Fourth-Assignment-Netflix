package org.example;

import java.util.ArrayList;

class User {
    private String username;
    private String password;

    private ArrayList<TVShow> favTvShow ;

    private ArrayList<TVShow> watchedTvShow;

    public User(String username,String password){
        this.username = username;
        this.password = password;
    }

    /*
     * The user should contain username password.
     * The user should contain an ArrayList of favorite shows and watch history.
     * FUNCTION: the user should have a function to watch a show and add it to watch history.
     *  *** NOTE: All search functions in user are for searching in favorite shows ***
     */

    public void Watch(TVShow tvShow)
    {
        watchedTvShow.add(tvShow);
    }


    public ArrayList<TVShow> searchByTitle(String title) {
        ArrayList<TVShow> searchResult = new ArrayList<>();

        for (int i = 0; i < favTvShow.size(); i++) {
            if(favTvShow.get(i).getTitle().contains(title))
            {
                searchResult.add(favTvShow.get(i));
            }
        }
        return searchResult;
    }
    public ArrayList<TVShow> searchByGenre(String genre) {
        ArrayList<TVShow> searchResult = new ArrayList<>();

        for (int i = 0; i < favTvShow.size(); i++) {
            if(favTvShow.get(i).getGenre().equals(genre))
            {
                searchResult.add(favTvShow.get(i));
            }
        }
        return searchResult;
    }
    public ArrayList<TVShow> searchByReleaseYear(int year) {
        ArrayList<TVShow> searchResult = new ArrayList<>();

        for (int i = 0; i < favTvShow.size(); i++) {
            if(favTvShow.get(i).getReleaseYear() == year)
            {
                searchResult.add(favTvShow.get(i));
            }
        }
        return searchResult;
    }
    public void addToFavorites(TVShow show) {
        favTvShow.add(show);
    }
    public void viewFavorites() {
        System.out.println(favTvShow);
    }
    public void viewWatchedHistory(){
        System.out.println(watchedTvShow);
    }
    public ArrayList<ArrayList<TVShow>> getRecommendations(NetflixService tvShowList) {
        //base on fav(genre) and watched
        ArrayList<String> genreOfFav = new ArrayList<>();
        for (int i = 0; i < favTvShow.size(); i++) {
            genreOfFav.add(favTvShow.get(i).getGenre());
        }
        ArrayList<String> genreOfWatched = new ArrayList<>();
        for (int i = 0; i < watchedTvShow.size(); i++) {
            genreOfWatched.add(watchedTvShow.get(i).getGenre());
        }
        genreOfWatched.addAll(genreOfFav);

        ArrayList<ArrayList<TVShow>> recommendation = new ArrayList<>();
        for (int i = 0; i < genreOfWatched.size(); i++) {
            recommendation.add(tvShowList.searchByGenre(genreOfWatched.get(i)));
        }
        return recommendation;

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
