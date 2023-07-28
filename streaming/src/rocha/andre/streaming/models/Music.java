package rocha.andre.streaming.models;

public class Music extends Audio {

    private String album;

    private String Singer;
    private String genre;

    public Music (String title, double duration) {
        super(title, duration);
    }


    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getSinger() {
        return Singer;
    }

    public void setSinger(String singer) {
        Singer = singer;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public double getRating() {
        if (this.getTotalPlays() > 1000) {
            return 10;
        } else {
            return 8;
        }
    }
}
