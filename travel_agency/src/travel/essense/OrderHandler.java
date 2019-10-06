package travel.essense;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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

    public String print(Order order) {
        return " Order: " + order.print();
    }
}
