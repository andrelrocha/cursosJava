package rocha.andre.streaming.calculate;

import rocha.andre.streaming.models.Movie;
import rocha.andre.streaming.models.Serie;
import rocha.andre.streaming.models.Title;

public class CalculateTime {
    private int totalDuration;

    public int getTotalDuration() {
        return this.totalDuration;
    }

    public void add(Title title) {
        System.out.println("Adding duration in minutes of " + title);
        this.totalDuration += title.getDurationInMinutes();
    }

//    public void add(Movie movie) {
//        this.totalDuration += movie.getDurationInMinutes();
//    }
//
//    public void add(Series series) {
//        this.totalDuration += series.getDurationInMinutes();
//    }
}
