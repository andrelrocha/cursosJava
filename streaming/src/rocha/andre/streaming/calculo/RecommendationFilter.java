package rocha.andre.streaming.calculo;

public class RecommendationFilter {

    private String recommendation;

    public void filter(Classifiable classifiable) {
        if (classifiable.getClassification() > 3) {
            recommendation = "Watch it!";
        } else if (classifiable.getClassification() > 1) {
            recommendation = "Maybe you will like it";
        } else {
            recommendation = "Don't watch it!";
        }
    }

    public String getRecommendation() {
        return recommendation;
    }
}
