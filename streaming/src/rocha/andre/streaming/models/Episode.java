package rocha.andre.streaming.models;

import rocha.andre.streaming.calculo.Classifiable;

public class Episode implements Classifiable {
    private int number;
    private String name;
    private Serie serie;
    private int totalMinutes;

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public Serie getSerie() {
        return serie;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setSerie(Serie serie) {
        this.serie = serie;
    }

    public void setTotalMinutes(int totalMinutes) {
        this.totalMinutes = totalMinutes;
    }

    public int getTotalMinutes() {
        return totalMinutes;
    }

    @Override
    public int getClassification() {
        if (totalMinutes > 250) {
            return 4;
        } else if (totalMinutes > 120) {
            return 3;
        } else if (totalMinutes > 60) {
            return 2;
        } else if (totalMinutes > 30) {
            return 1;
        } else {
            return 0;
        }
    }
}
