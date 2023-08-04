package rocha.andre.streaming.calculo;

import rocha.andre.streaming.models.Movie;
import rocha.andre.streaming.models.Serie;

public class CalculateTime {
    private static int totalTime;

    public int getTotaltime() {
        return totalTime;
    }

    public void includeMovie(Movie movie) {
        totalTime += movie.totalMinutes();
    }

    public void includeSerie(Serie serie) {
        totalTime += serie.totalMinutes();
    }

}
