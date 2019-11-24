package travel.essense;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.io.Serializable;

@JacksonXmlRootElement(localName = "order")
public class Order implements Serializable {

    public Order(int id, Client client, Resort resort, int price){
        this.id = id;
        this.client = client;
        this.resort = resort;
        this.price = price;
    }

    public Order(){

    }
    @JacksonXmlProperty(isAttribute=true)
    private int id;
    private Client client;
    private Resort resort;
    public int price;

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Resort getResort() {
        return resort;
    }

    public void setResort(Resort resort) {
        this.resort = resort;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }


    public String toString() {
        return "Order ID: " + id + " Client: " + client.toString() + " Resort" + resort.toString() +
               " Price: " + price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
