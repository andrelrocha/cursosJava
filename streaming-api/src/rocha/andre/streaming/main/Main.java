package rocha.andre.streaming.main;

import rocha.andre.streaming.calculate.CalculateTime;
import rocha.andre.streaming.calculate.RecommendationFilter;
import rocha.andre.streaming.models.Episode;
import rocha.andre.streaming.models.Movie;
import rocha.andre.streaming.models.Serie;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Movie myMovie = new Movie("The Godfather", 1970);
        myMovie.setDurationInMinutes(180);
        System.out.println("Movie Duration: " + myMovie.getDurationInMinutes());

        myMovie.displayTechnicalSheet();
        myMovie.rate(8);
        myMovie.rate(5);
        myMovie.rate(10);
        System.out.println("Total ratings: " + myMovie.getTotalRatings());
        System.out.println(myMovie.getAverageRating());
//myMovie.sumOfRatings = 10;
//myMovie.totalRatings = 1;
//System.out.println(myMovie.getAverageRating());

        Serie lost = new Serie("Lost", 2000);
        lost.displayTechnicalSheet();
        lost.setSeasons(10);
        lost.setEpisodesPerSeason(10);
        lost.setMinutesPerEpisode(50);
        System.out.println("Duration to binge-watch Lost: " + lost.getDurationInMinutes());

        Movie anotherMovie = new Movie("Avatar", 2023);
        anotherMovie.setDurationInMinutes(200);

        CalculateTime calculator = new CalculateTime();
        calculator.add(myMovie);
        calculator.add(anotherMovie);
        calculator.add(lost);
        System.out.println(calculator.getTotalDuration());

        RecommendationFilter filter = new RecommendationFilter();
        filter.filter(myMovie);

        Episode episode = new Episode();
        episode.setNumber(1);
        episode.setSeries(lost);
        episode.setTotalViews(300);
        filter.filter(episode);

        var paulosMovie = new Movie("Dogville", 2003);
        paulosMovie.setDurationInMinutes(200);
        paulosMovie.rate(10);

        ArrayList<Movie> movieList = new ArrayList<>();
        movieList.add(paulosMovie);
        movieList.add(myMovie);
        movieList.add(anotherMovie);
        System.out.println("List size: " + movieList.size());
        System.out.println("First movie: " + movieList.get(0).getName());
        System.out.println(movieList);
        System.out.println("toString of the movie: " + movieList.get(0).toString());
    }
}