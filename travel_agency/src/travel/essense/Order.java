package travel.essense;

import com.sun.jdi.connect.Transport;

import java.io.Serializable;

public class Order implements Serializable{

    public Order(Integer id, Client client, Resort resort, Integer price){
        this.id = id;
        this.client = client;
        this.resort = resort;
        this.price = price;
    }

    public Order(){

    }
    private Integer id;
    private Client client;
    private Resort resort;
    public Integer price;

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


    public String print() {
        return "Order ID: " + id + " Client: " + client.toString() + " Resort" + resort.print() +
               " Price: " + price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
