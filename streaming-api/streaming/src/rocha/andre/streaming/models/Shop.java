package rocha.andre.streaming.models;

public class Shop {

    private String description;
    private double value;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public boolean isLimitExceeded(double limit) {
        return this.value > limit;
    }

    public double getLimitLeft(double limit) {
        return limit - this.value;
    }
}
