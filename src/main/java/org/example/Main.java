package org.example;

import java.util.Scanner;

public class Main {
    //don't limit yourself to our template ***
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        NetflixService netflix = new NetflixService();
        boolean exit = false;
        boolean loginDone = false;
        do {
            int number = 0;
            while (runMenu(netflix,loginDone) == false)
            {
                runMenu(netflix,loginDone);
            }
            mainMenu();
            TVShow currentTvShow = null;
            do {
                number = input.nextInt();
                if (number == 1) {
                    System.out.println("Your search result will be based on :" + "\n" +
                            "1.Title" + "\n" + "2.Genre" + "\n" + "3.Year");
                    int number2 = input.nextInt();
                    if (netflix.tvShows.isEmpty()) {
                        System.err.println("List is empty!");
                    } else {
                        switch (number2) {
                            case (1):
                                System.out.println("please enter the name: ");
                                String name = input.next();
                                netflix.searchByTitle(name);
                                System.out.println("Enter the index of your desired movie");
                                int index = input.nextInt();
                                currentTvShow = netflix.searchByTitle(name).get(index);

                            case (2):
                                System.out.println("please enter the genre: ");
                                String genre = input.next();
                                netflix.searchByGenre(genre);
                                System.out.println("Enter the index of your desired movie");
                                index = input.nextInt();
                                currentTvShow = netflix.searchByGenre(genre).get(index);

                            case (3):
                                System.out.println("please enter the year: ");
                                int year = input.nextInt();
                                netflix.searchByReleaseYear(year);
                                System.out.println("Enter the index of your desired movie");
                                index = input.nextInt();
                                currentTvShow = netflix.searchByReleaseYear(year).get(index);
                        }

                        System.out.println("choose: " + "\n" + "1.Watch" + "\n" + "2.Add to favorite");
                        int choose = input.nextInt();
                        switch (choose) {
                            case (1):
                                netflix.currentUser.Watch(currentTvShow);
                            case (2):
                                netflix.currentUser.addToFavorites(currentTvShow);
                        }
                        System.out.println("Done! Let's go back yo main menu");
                    }

                }
                else if (number == 2) {
                    System.out.println("Your search result will be based on :" + "\n" +
                            "1.Title" + "\n" + "2.Genre" + "\n" + "3.Year");
                    int number2 = input.nextInt();
                    if (netflix.tvShows.isEmpty()) {
                        System.err.println("List is empty!");
                    } else {
                        switch (number2) {
                            case (1):
                                System.out.println("please enter the name: ");
                                String name = input.next();
                                netflix.currentUser.searchByTitle(name);
                                System.out.println("Enter the index of your desired movie");
                                int index = input.nextInt();
                                currentTvShow = netflix.currentUser.searchByTitle(name).get(index);

                            case (2):
                                System.out.println("please enter the genre: ");
                                String genre = input.next();
                                netflix.currentUser.searchByGenre(genre);
                                System.out.println("Enter the index of your desired movie");
                                index = input.nextInt();
                                currentTvShow = netflix.currentUser.searchByGenre(genre).get(index);

                            case (3):
                                System.out.println("please enter the year: ");
                                int year = input.nextInt();
                                netflix.currentUser.searchByReleaseYear(year);
                                System.out.println("Enter the index of your desired movie");
                                index = input.nextInt();
                                currentTvShow = netflix.currentUser.searchByReleaseYear(year).get(index);
                        }
                        System.out.println(" Wanna watch? Choose: 1.Yes! 2.No!");
                        int choose = input.nextInt();
                        switch (choose) {
                            case (1):
                                netflix.currentUser.Watch(currentTvShow);
                            case (2):
                                System.out.println("OK! Let's go back to main menu");
                        }
                    }

                }
                else if (number == 3) {
                    if (netflix.currentUser.favTvShow.isEmpty()) {
                        System.err.println("List is empty");
                    } else {
                        netflix.currentUser.viewFavorites();
                    }
                }
                else if (number == 4) {
                    if (netflix.currentUser.watchedTvShow.isEmpty()) {
                        System.err.println("List is empty");
                    } else {
                        netflix.currentUser.viewWatchedHistory();
                    }

                }
                else if (number == 5) {
                    System.out.println("Your username and password is: " + "\n" +
                            "Username: " + netflix.currentUser.getUsername() + "\n" +
                            "Password: " + netflix.currentUser.getPassword() + "\n" +
                            "Wanna change? " + "\n" +
                            "1.Yes" + "\n" +
                            "2.No");
                    int choose = input.nextInt();
                    switch (choose) {
                        case (1):
                            System.out.println("Please enter new username: ");
                            String username = input.next();
                            System.out.println("Please enter new password: ");
                            String password = input.next();
                            netflix.currentUser.setUsername(username);
                            netflix.currentUser.setPassword(password);
                        case (2):
                            break;
                    }
                }
                else if (number == 6) {
                    if (netflix.tvShows.isEmpty()) {
                        System.out.println("List is empty!");
                    } else {
                        netflix.currentUser.getRecommendations(netflix);
                    }
                }
                else if (number == 7) {
                    netflix.logout();
                    break;
                }
                mainMenu();
            }
            while (number != 8);
            if(number == 8)
            {
                exit = true;
            }
        }while (exit == false);
    }

    public static boolean runMenu(NetflixService netflix , boolean loginDone){
        Scanner input = new Scanner(System.in);
        System.out.println("<< NETFLIX >>");
        System.out.println("Enter 1 for sign up" + "\n" + "Enter 2 for login");
        int num = input.nextInt();
        if(num == 1)
        {
            System.out.println("Please enter username and password :");
            String username = input.next();
            String password = input.next();
            netflix.createAccount(username,password);
            System.out.println("Your account has been created! Welcome!");
            loginDone = true;
        }
        else if(num == 2)
        {
            System.out.println("Please enter username and password :");
            String username = input.next();
            String password = input.next();
            if(netflix.login(username,password)){
                System.out.println("You logged in successfully!");
                loginDone = true;
            }
            else {
                loginDone = false;
            }
        }
        else{
            loginDone = false;
        }
        return loginDone;
    }
    public static void mainMenu(){
        System.out.println("Now what you wanna do?" + "\n" +
                "1.Search Movie or TvShow " + "\n" +
                "2.Search in your favorite List" + "\n" +
                "3.Your favorite List" + "\n" +
                "4.Your watched history" + "\n" +
                "5.Your information" + "\n" +
                "6.Get recommendation " + "\n" +
                "7.logOut" + "\n" +
                "8.Exit");
    }
}
