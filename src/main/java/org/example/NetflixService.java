package org.example;

import java.util.ArrayList;
import java.util.Objects;

class NetflixService {
    User currentUser;
    public ArrayList<User> users  = new ArrayList<>();
    public ArrayList<TVShow> tvShows = new ArrayList<>();
    public ArrayList<Movie> movies = new ArrayList<>();
    public NetflixService()
    {
        //movies
        //Fantasy
        Movie HarryPotter1 = new Movie("Harry Potter and the Sorcerer's Stone", "Fantasy", 2001, 7.6, 143);
        Movie HarryPotter2 = new Movie("Harry Potter and the Chamber of Secrets", "Fantasy", 2002, 7.4,161);
        Movie HarryPotter3 = new Movie("Harry Potter and the Prisoner of Azkaban", "Fantasy", 2004,7.9,142);
        Movie HarryPotter4 = new Movie("Harry Potter and the Goblet of Fire", "Fantasy", 2005,7.9, 157);
        Movie HarryPotter5 = new Movie("Harry Potter and the Order of the Phoenix","Fantasy",2007,7.5,138);
        Movie HarryPotter6 = new Movie("Harry Potter and the Half-Blood Prince","Fantasy",2009,7.6,155);
        Movie HarryPotter7 = new Movie("Harry Potter and the Deathly Hallows: Part 1","Fantasy",2010,7.7,146);
        Movie HarryPotter8 = new Movie("Harry Potter and the Deathly Hallows: Part 2","Fantasy",2011,8.1,130);

        //Horror
        Movie Annabelle = new Movie("Annabelle", "Horror",2014,5.4,99);
        Movie GetOut = new Movie("Get Out","Horror",2017,7.7,104);
        Movie TheConjuring = new Movie("The Conjuring", "Horror",2013,7.5,112);
        Movie TheConjuring2 = new Movie("The Conjuring 2", "Horror", 2016,7.3,134);

        //Comedy
        Movie PussInBoots = new Movie("Puss in Boots: The Last Wish","Comedy",2022,7.9,102);
        Movie TheMenu = new Movie("The Menu","Comedy",2022,7.2,107);
        Movie WeAreTheMillers = new Movie("We Are The Millers" ,"Comedy",2013,7.0,190);

        //Sci-Fi
        Movie Interstellar = new Movie("Interstellar", "Sci-Fi",2014,8.6,169);
        Movie Dune = new Movie("Dune","Sci-Fi",2021,8.0,155);
        Movie HungerGames = new Movie("Hunger Games","Sci-Fi",2012,7.2,142);

        //Tv Show
        //Fantasy
        TVShow StrangerThings = new TVShow("Stranger Things","Fantasy",2014,8.7,51);
        TVShow Wednesday = new TVShow("Wednesday","Fantasy",2022,8.1,45);
        TVShow Lucifer = new TVShow("Lucifer", "Fantasy",2016,8.1,42);
        TVShow Witcher = new TVShow("The Witcher","Fantasy",2019,8.1,60);
        TVShow Vampire = new TVShow("The Vampire Diaries","Fantasy",2009,7.7,43);

        //Action
        TVShow GameOfThrones = new TVShow("Game Of Thrones","Action",2019,9.2,57);
        TVShow AttackOnTitan = new TVShow("Attack On Titan","Action",2013,9.0,24);
        TVShow TheLastOfUs = new TVShow("The Last Of Us","Action",2023,8.9,50);

        //Comedy
        TVShow Friends = new TVShow("Friends","Comedy",1994,8.9,2);
        TVShow BigBangTheory = new TVShow("The BigBang Theory","Comedy",2007,8.2,22);
        TVShow HowIMetYourMother = new TVShow("How I Met Your Mother", "Comedy",2005,8.3, 22);
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
                        System.err.println("password isn't correct ! ");
                        return false;
                    }
                }
                else {
                    System.err.println("this username doesn't exist");
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

