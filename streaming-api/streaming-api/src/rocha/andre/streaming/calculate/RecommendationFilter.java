package rocha.andre.streaming.calculate;

public class RecommendationFilter {
    private String recommendation;

    public void filter(Ratable ratable) {
        if (ratable.getRating() >= 4) {
            System.out.println("It's among the current favorites!");
        } else if (ratable.getRating() >= 2) {
            System.out.println("Highly rated at the moment!");
        } else {
            System.out.println("Add it to your watchlist for later!");
        }
    }
}
