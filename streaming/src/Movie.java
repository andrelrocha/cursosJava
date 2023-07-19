public class Movie {
    private String name;
    private int yrOfRelease;
    private String genre;
    private String director;
    private String[] cast;
    private double rating;
    private int duration;
    private boolean isAvailable;
    

    public Movie(String name, int yrOfRelease) {
        this.name = name;
        this.yrOfRelease = yrOfRelease;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setCast(String[] cast) {
        this.cast = cast;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setIsAvailabe(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }
}
