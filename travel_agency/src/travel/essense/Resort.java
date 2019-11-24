package travel.essense;

import org.w3c.dom.Text;

import java.io.Serializable;

public class Resort implements Serializable {

    public Resort(int id, String name, String hotelName, int stars ){
        this.id = id;
        this.name = name;
        this.hotelName = hotelName;
        this.stars = stars;
    }

    public Resort(){
    }

    private int id;
    private String name;
    private  int stars;
    private  String hotelName;

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

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String toString() {
        return "ID:" + id + " name: " + name + " " + " hotel: " + hotelName + " stars: " + stars;
    }

}
