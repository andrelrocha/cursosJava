import rocha.andre.streaming.models.Audio;
import rocha.andre.streaming.models.MyFavorites;
import rocha.andre.streaming.models.Podcast;

public class MainAudio {
    public static void main(String[] args) {
        Audio newAudio = new Audio("Joji", 3);
        Podcast newPodcast = new Podcast("Podcast do Joji", 3);

        for (int i = 0; i < 1100; i++) {
            newAudio.play();
            newPodcast.play();
        }

        for (int i = 0; i < 150; i++) {
            newAudio.like();
            newPodcast.like();
        }

        MyFavorites favorites = new MyFavorites();
        favorites.include(newAudio);
        favorites.include(newPodcast);

    }
}
