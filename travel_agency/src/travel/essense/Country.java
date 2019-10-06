package travel.essense;

import java.io.Serializable;

public class Country implements Serializable {
    public Country(String name){
        this.name = name;
    }
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String print() {
        return " Country: " + name;
    }
}
