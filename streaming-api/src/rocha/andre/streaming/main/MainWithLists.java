package rocha.andre.streaming.main;

import rocha.andre.streaming.models.Movie;
import rocha.andre.streaming.models.Serie;
import rocha.andre.streaming.models.Title;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class MainWithLists {
    public static void main(String[] args) {
        Movie myMovie = new Movie("The Godfather", 1970);
        myMovie.rate(9);
        Movie anotherMovie = new Movie("Avatar", 2023);
        anotherMovie.rate(6);
        var paulosMovie = new Movie("Dogville", 2003);
        paulosMovie.rate(10);
        Serie lost = new Serie("Lost", 2000);

        Movie f1 = paulosMovie;

        ArrayList<Title> list = new ArrayList<>();
        list.add(paulosMovie);
        list.add(myMovie);
        list.add(anotherMovie);
        list.add(lost);
        for (Title item : list) {
            System.out.println(item.getName());
            if (item instanceof Movie movie && movie.getRating() > 2) {
                System.out.println("Rating: " + movie.getRating());
            }
        }

        List<String> searchByArtist = new LinkedList<>();
        searchByArtist.add("Adam Sandler");
        searchByArtist.add("Paulo");
        searchByArtist.add("Jacqueline");
        System.out.println(searchByArtist);

        Collections.sort(searchByArtist);
        System.out.println("After sorting");
        System.out.println(searchByArtist);
        System.out.println("Sorted list of titles");
        Collections.sort(list);
        System.out.println(list);
        list.sort(Comparator.comparing(Title::getReleaseYear));
        System.out.println("Sorting by release year");
        System.out.println(list);
    }
}
