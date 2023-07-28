package rocha.andre.streaming.main;

import java.util.ArrayList;

import rocha.andre.streaming.calculo.CalculateTime;
import rocha.andre.streaming.calculo.RecommendationFilter;
import rocha.andre.streaming.models.Episode;
import rocha.andre.streaming.models.Movie;
import rocha.andre.streaming.models.Serie;


public class Main {
    public static void main(String[] args) {        
        Movie[] movies = new Movie[3];

        Movie movieBatman = new Movie("Batman Begins", 2005, 140);
        movieBatman.setDirector("Christopher Nolan");
        movieBatman.setGenre("Action");
        movieBatman.setCast(new String[] {"Christian Bale", "Michael Caine", "Liam Neeson", "Katie Holmes", "Gary Oldman", "Cillian Murphy", "Morgan Freeman", "Tom Wilkinson"});
        movieBatman.setRating(8.2);
        movies[0] = movieBatman;

        Movie movieAvengers = new Movie("Avengers: Endgame", 2019, 181);
        movieAvengers.setDirector("Anthony Russo");
        movieAvengers.setGenre("Action");
        movieAvengers.setCast(new String[] {"Robert Downey Jr.", "Chris Evans", "Mark Ruffalo", "Chris Hemsworth", "Scarlett Johansson", "Jeremy Renner", "Don Cheadle", "Paul Rudd", "Brie Larson", "Karen Gillan", "Danai Gurira", "Benedict Wong", "Jon Favreau", "Bradley Cooper", "Gwyneth Paltrow", "Josh Brolin"});
        movieAvengers.setRating(8.4);
        movieAvengers.setIsAvailabe(true);
        movies[1] = movieAvengers;

        Movie movieInception = new Movie("Inception", 2010, 148);
        movieInception.setDirector("Christopher Nolan");    
        movieInception.setGenre("Action");
        movieInception.setCast(new String[] {"Leonardo DiCaprio", "Joseph Gordon-Levitt", "Ellen Page", "Tom Hardy", "Ken Watanabe", "Dileep Rao", "Cillian Murphy", "Tom Berenger", "Marion Cotillard", "Pete Postlethwaite", "Michael Caine"});
        movieInception.setRating(8.8);
        movieInception.setIsAvailabe(true);
        movies[2] = movieInception;

        //forEach loop
        for(Movie movie : movies) {
            movie.displayContentSpecificities();
        }


        Serie serie = new Serie("The Office", 2011, 25, 24, 9);
        serie.setDurationEpisodes(25);

        CalculateTime calculateTime = new CalculateTime();
        calculateTime.includeMovie(movieInception);
        calculateTime.includeSerie(serie);

        serie.displaySeriesSpecificities();

        Episode episodeOfTheOffice = new Episode();
        episodeOfTheOffice.setTotalMinutes(serie.totalMinutes());
        int note = episodeOfTheOffice.getClassification();

        System.out.printf("The Office has a note of %d\n", note);

        RecommendationFilter recommendationFilter = new RecommendationFilter();
        recommendationFilter.filter(episodeOfTheOffice);

        System.out.printf("Recommendation: %s%n", recommendationFilter.getRecommendation());



        //lista dinâmica
        ArrayList<Movie> moviesArrayList = new ArrayList<Movie>();
        moviesArrayList.add(movieBatman);
        moviesArrayList.add(movieAvengers);
        moviesArrayList.add(movieInception);

        System.out.printf("first item on the list: %s%n", moviesArrayList.get(0).getName());

        //lista estática
        Movie[] moviesList = new Movie[3];
        moviesList[0] = movieBatman;
        moviesList[1] = movieAvengers;
        moviesList[2] = movieInception;

        for (Movie movie : moviesList) {
            movie.displayContentSpecificities();
        }
    }
}