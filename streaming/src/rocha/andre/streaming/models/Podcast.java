package rocha.andre.streaming.models;

public class Podcast extends Audio {

    private String host;

    private String description;

    public Podcast(String title, double duration) {
        super(title, duration);
    }


    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    
}
