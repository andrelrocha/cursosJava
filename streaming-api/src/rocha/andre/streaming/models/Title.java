package rocha.andre.streaming.models;


import com.google.gson.annotations.*;

public class Title implements Comparable<Title> {
    @SerializedName("Title")
    private String name;
    @SerializedName("Year")
    private int releaseYear;
    private boolean includedInPlan;
    private double sumOfRatings;
    private int totalRatings;
    private int durationInMinutes;

    public Title(String name, int releaseYear) {
        this.name = name;
        this.releaseYear = releaseYear;
    }

    public Title(TitleOmdb myTitleOmdb) {
        this.name = myTitleOmdb.title();
        this.releaseYear = Integer.valueOf(myTitleOmdb.year());
        this.durationInMinutes = Integer.valueOf(myTitleOmdb.runtime().substring(0,3));
    }

    public String getName() {
        return name;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public boolean isIncludedInPlan() {
        return includedInPlan;
    }

    public int getDurationInMinutes() {
        return durationInMinutes;
    }

    public int getTotalRatings() {
        return totalRatings;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public void setIncludedInPlan(boolean includedInPlan) {
        this.includedInPlan = includedInPlan;
    }

    public void setDurationInMinutes(int durationInMinutes) {
        this.durationInMinutes = durationInMinutes;
    }

    public void displayTechnicalSheet() {
        System.out.println("Movie Name: " + name);
        System.out.println("Release Year: " + releaseYear);
    }

    public void rate(double rating) {
        sumOfRatings += rating;
        totalRatings++;
    }

    public double getAverageRating() {
        return sumOfRatings / totalRatings;
    }

    @Override
    public String toString() {
        return "name=" + name + ",\n" +
                "ReleaseYear=" + releaseYear + ",\n" +
                "Duration=" + durationInMinutes;
    }

    @Override
    public int compareTo(Title otherTitle) {
        return this.getName().compareTo(otherTitle.getName());
    }
}
