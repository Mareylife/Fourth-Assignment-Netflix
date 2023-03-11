package org.example;

import java.util.ArrayList;
import java.util.Objects;

class NetflixService {
    User currentUser;
    public ArrayList<User> users;
    public ArrayList<TVShow> tvShows;
    public ArrayList<Movie> movies;
    public NetflixService()
    {
    }
    /*
     *The NetflixService should have an Arraylist of users, tv shows and movies.
     *The NetflixService should have a User object which represents current user.
     */

    public void addTVShow(TVShow tvShow){
        tvShows.add(tvShow);
    }

    public void addMovie(Movie movie){
        movies.add(movie);
    }

    public void createAccount(String username, String password) {
        if(users.contains(currentUser))
        {
            System.err.println("this username exist. please try again");
        }
        else {
            currentUser = new User(username,password);
            users.add(currentUser);
        }
    }

    public boolean login(String username, String password) {
        if(users.contains(currentUser))
        {
            for(int i = 0; i < users.size(); i++)
            {
                if(username.equals(users.get(i).getUsername()))
                {
                    if(password.equals(users.get(i).getPassword()))
                    {
                        return true;
                    }
                    else {
                        return false;
                    }
                }
                else {
                    return false;
                }
            }
        }
        else {
            System.err.println("this username doesn't exist");
            return false;
        }
        return false;
    }

    public void logout() {
        // Implement logout logic here
    }

    public ArrayList<TVShow> searchByTitle(String title) {
        ArrayList<TVShow> searchResult = new ArrayList<>();

        for (int i = 0; i < tvShows.size(); i++) {
            if(tvShows.get(i).getTitle().contains(title))
            {
                searchResult.add(tvShows.get(i));
            }
        }
        return searchResult;
    }

    public ArrayList<TVShow> searchByGenre(String genre) {
        ArrayList<TVShow> searchResult = new ArrayList<>();

        for (int i = 0; i < tvShows.size(); i++) {
            if(tvShows.get(i).getGenre().equals(genre))
            {
                searchResult.add(tvShows.get(i));
            }
        }
        return searchResult;
    }

    public ArrayList<TVShow> searchByReleaseYear(int year) {
        ArrayList<TVShow> searchResult = new ArrayList<>();

        for (int i = 0; i < tvShows.size(); i++) {
            if(tvShows.get(i).getReleaseYear() == year)
            {
                searchResult.add(tvShows.get(i));
            }
        }
        return searchResult;
    }


}

