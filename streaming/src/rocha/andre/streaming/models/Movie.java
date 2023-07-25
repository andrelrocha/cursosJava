package rocha.andre.streaming.models;

public class Movie extends Content {
    public void rateMovie(double rating) {
        setRating(rating);
    }

    public Movie(String name, int yrOfRelease, int duration) {
        super(name, yrOfRelease, duration);
    }
}
