package travel.data.orders;


import travel.essense.Order;

import java.util.List;

public class DisplayOrder {
    public static void printAllOrders(List<Order> orders){
        for (var order : orders) {
            System.out.println(order.print());
        }
    }
}
