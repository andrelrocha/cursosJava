package rocha.andre.streaming.models;

public class Audio {
    private String title;
    private double duration;
    private int totalPlays;
    private int totalLikes;
    private double rating;

    public Audio(String title, double duration) {
        this.title = title;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public int getTotalPlays() {
        return totalPlays;
    }

    public void setTotalPlays(int totalPlays) {
        this.totalPlays = totalPlays;
    }

    public int getLikes() {
        return totalLikes;
    }

    public double getRating() {
        return rating;
    }

    public void like() {
        this.totalLikes++;
    }

    public void rate(double rating) {
        this.rating = rating;
    }

    public void play() {

    }


}
