package travel.essense;

import org.w3c.dom.Text;

import java.io.Serializable;

public class Resort implements Serializable {
    public Resort(String name, Hotel hotel ){

        this.name = name;
        this.hotel = hotel;
    }

    private String name;
    private Hotel hotel;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public String print() {
        return " name: " + name + " " + hotel.print();
    }
}
