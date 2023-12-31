package rocha.andre.streaming.models;

public class Serie extends Content {
    private int numOfEpisodes;
    private int numOfSeasons;
    private int durationEpisodes;

    public Serie(String name, int yrOfRelease, int duration, int numOfEpisodes, int numOfSeasons) {
        super(name, yrOfRelease, duration);
        this.numOfEpisodes = numOfEpisodes;
        this.numOfSeasons = numOfSeasons;
    }

    public void setNumOfEpisodes(int numOfEpisodes) {
        this.numOfEpisodes = numOfEpisodes;
    }

    public void setNumOfSeasons(int numOfSeasons) {
        this.numOfSeasons = numOfSeasons;
    }

    public void setDurationEpisodes(int durationEpisodes) {
        this.durationEpisodes = durationEpisodes;
    }

    public void displaySeriesSpecificities() {
        displayContentSpecificities();
        System.out.println("Number of Episodes: " + numOfEpisodes);
        System.out.println("Number of Seasons: " + numOfSeasons);
        System.out.println("Duration of Episodes: " + durationEpisodes);
    }


    @Override
    public int totalMinutes() {
        return numOfEpisodes * durationEpisodes;
    }

    public String getNumOfSeasons() {
        return null;
    }

}
