package travel.data;

import travel.essense.Order;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OrderHandler implements Serializable {
    public OrderHandler(){

    }
    private List<Order> orders = new ArrayList<Order>();

    public List<Order> getOrders() {
        return orders;
    }

    public void addOrder(Order order)  {

        this.orders.add(order);
    }

    public void removeOrder(int id)  {

        this.orders.remove(id-1);
    }

    public List<Order> findByClient(String secondName){
        return orders.stream().filter(order -> secondName.equals(order.getClient().getLastName())).collect(Collectors.toList());
    }
    public String print(Order order) {
        return " Order: " + order.print();
    }

    public void printAllOrders(){
        for (var order : orders) {
            System.out.println(this.print(order));
        }
    }
}
