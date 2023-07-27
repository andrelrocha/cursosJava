package rocha.andre.streaming.models;

import rocha.andre.streaming.calculo.Classifiable;

public class Movie extends Content implements Classifiable {
    public void rateMovie(double rating) {
        setRating(rating);
    }

    public Movie(String name, int yrOfRelease, int duration) {
        super(name, yrOfRelease, duration);
    }

    @Override
    public int getClassification() {
        return 0;
    }
}
