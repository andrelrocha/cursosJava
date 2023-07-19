public class Movie {
    private String name;
    private int yrOfRelease;
    private String genre;
    private String director;
    private String[] cast;
    private double rating;
    private int duration;
    private boolean isAvailable;

    static int totalMinutes = 0;
    

    public Movie(String name, int yrOfRelease, int duration) {
        this.name = name;
        this.yrOfRelease = yrOfRelease;

        totalMinutes += duration;
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



    public void displayMovieSpecificities() {
        System.out.println("Name: " + this.name);
        System.out.println("Year of release: " + this.yrOfRelease);
        
        if (this.genre != null) {         
            System.out.println("Genre: " + this.genre);
        } 

        if (this.director != null) {
            System.out.println("Director: " + this.director);
        }

        if (this.cast != null) {
            System.out.println("Cast: ");
            for (String actor : this.cast) {
                System.out.println(actor);
            }
        }

        if (this.rating != 0) {
            System.out.println("Rating: " + this.rating);
        }

        if (this.duration != 0) {
            System.out.println("Duration: " + this.duration + " minutes");
        }

        if (this.isAvailable) {
            System.out.println("Available: Yes");
        } else {
            System.out.println("Available: No");
        }
    } 

    public static void totalMovies(Movie[] movies) {
        System.out.println("Total movies: " + movies.length);
    }

    public static void totalMinutes() {
        System.out.println("Total minutes: " + totalMinutes);
    }

}
