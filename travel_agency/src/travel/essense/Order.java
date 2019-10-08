package travel.essense;

import java.io.Serializable;
import java.time.LocalDate;

public class Order implements Serializable{
    public Order(Integer id, Client client, Country fromCountry, Country toCountry, LocalDate start, LocalDate end, Resort resort, Integer price, Transport transport){
        this.id = id;
        this.client = client;
        this.fromCountry = fromCountry;
        this.toCountry = toCountry;
        this.start = start;
        this.end = end;
        this.resort = resort;
        this.price = price;
        this.transport = transport;
    }
    private Integer id;
    private Client client;
    private Country fromCountry;
    private Country toCountry;
    private LocalDate  start;
    private LocalDate  end;
    private Resort resort;
    public Integer price;
    private Transport transport;

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Country getFromCountry() {
        return fromCountry;
    }

    public void setFromCountry(Country fromCountry) {
        this.fromCountry = fromCountry;
    }

    public Country getToCountry() {
        return toCountry;
    }

    public void setToCountry(Country toCountry) {
        this.toCountry = toCountry;
    }

    public Resort getResort() {
        return resort;
    }

    public void setResort(Resort resort) {
        this.resort = resort;
    }

    public Transport getTransport() {
        return transport;
    }

    public void setTransport(Transport transport) {
        this.transport = transport;
    }

    public LocalDate getStart() {
        return start;
    }

    public void setStart(LocalDate start) {
        this.start = start;
    }

    public LocalDate getEnd() {
        return end;
    }

    public void setEnd(LocalDate end) {
        this.end = end;
    }

    public String print() {
        return "ID: " + id + " Client: " + client.print() + " From" + fromCountry.print()+ " To" + toCountry.print() +
               " Date start: " + start.toString() + " Date end: " + end.toString() + " Resort" + resort.print() +
               " Price: " + price + " Transport " + transport.print();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
