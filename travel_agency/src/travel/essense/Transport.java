package travel.essense;

import java.io.Serializable;

public class Transport implements Serializable {
    public Transport(String type){
        this.type = type;
    }
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String print() {
        return " Name: " + type;
    }
}
