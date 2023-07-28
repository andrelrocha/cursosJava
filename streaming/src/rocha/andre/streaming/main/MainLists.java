package rocha.andre.streaming.main;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

import rocha.andre.streaming.models.Content;
import rocha.andre.streaming.models.Movie;
import rocha.andre.streaming.models.Serie;

public class MainLists {
    public static void main(String[] args) {
        Movie newMovie = new Movie("Zodiac", 2007, 157);
        Movie newMovie2 = new Movie("Inception", 2010, 148);
        Movie newMovie3 = new Movie("Madarin", 2013, 130);

        Serie newSerie = new Serie("The Sopranos", 1999, 6, 86, 4);


        ArrayList<Movie> movies = new ArrayList<Movie>();
        movies.add(newMovie);
        movies.add(newMovie2);
        movies.add(newMovie3);

        ArrayList<Content> contents = new ArrayList<Content>();
        contents.add(newMovie);
        contents.add(newMovie2);
        contents.add(newMovie3);
        contents.add(newSerie);

        //ORDENANDO VALORES EM UM ARRAYLIST PERSONALIZADO {CONFERIR EM CONTENT.JAVA}
        contents.forEach(content -> {
            System.out.println(content.getName());
        });
        Collections.sort(contents);
        contents.forEach(content -> {
            System.out.println(content.getName());
        });


        //LOOP FOR EACH E CASTING
        contents.forEach( (content) -> {
            //content.displayContentSpecificities();

            if(content instanceof Movie movie && movie.getClassification() > 2.0) {
                //casting para movie para recuperar seus métodos
                //Movie movie = (Movie) content;
                System.out.println("Director: " + movie.getDirector());
            } else if(content instanceof Serie) {
                Serie serie = (Serie) content;
                System.out.println("Number of Seasons: " + serie.getNumOfSeasons());
            }
        });


        //ORDENANDO VALORES EM ARRAY
        ArrayList<String> searchForArtist = new ArrayList<>();
        searchForArtist.add("Robert Downey Jr.");
        searchForArtist.add("Chris Evans");
        searchForArtist.add("Mark Ruffalo");
        System.out.println(searchForArtist);
        Collections.sort(searchForArtist);
        System.out.println(searchForArtist);


        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(9);
        numbers.add(2);
        numbers.add(4);
        System.out.println(numbers);
        Collections.sort(numbers);
        System.out.println(numbers);

    }
}
