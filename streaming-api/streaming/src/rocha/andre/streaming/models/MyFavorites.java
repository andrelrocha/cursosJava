package rocha.andre.streaming.models;

public class MyFavorites {
    public void include(Audio audio) {
        if (audio.getRating() >= 9) {
            System.out.printf("%s is considered a massive success\n", audio.getTitle());;
        } else {
            System.out.printf("%s is being enjoyed by everyone\n", audio.getTitle());
        }
    }
}
