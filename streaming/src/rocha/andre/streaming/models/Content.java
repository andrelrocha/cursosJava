package rocha.andre.streaming.models;

public class Content implements Comparable<Content> {
    private String name;
    private int yrOfRelease;
    private String genre;
    private String director;
    private String[] cast;
    private double rating;
    private int duration;
    private boolean isAvailable;

    static int totalMinutes = 0;


    public Content(String name, int yrOfRelease, int duration) {
        this.name = name;
        this.yrOfRelease = yrOfRelease;

        totalMinutes += duration;
    }

    public int getDuration() {
        return duration;
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

    public void displayContentSpecificities() {
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

    public static void totalContents(Content[] contents) {
        System.out.println("Total contents: " + contents.length);
    }

    public int totalMinutes() {
        return totalMinutes;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public int compareTo(Content otherContent) {
        return this.getName().compareTo(otherContent.getName());
    }
}
