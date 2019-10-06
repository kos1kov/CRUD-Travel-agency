package travel.essense;

import java.io.Serializable;

public class Hotel implements Serializable {
    public Hotel(String name, int stars){

        this.name = name;
        this.stars = stars;
    }
    private String name;
    private boolean allInclusive;
    private int stars;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public String print() {
        return " Hotel name: " + name + " Stars: " + stars;
    }
}
