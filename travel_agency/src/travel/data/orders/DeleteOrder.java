package travel.data.orders;

import travel.essense.Order;

import java.util.List;

public class DeleteOrder {
    public static void removeOrder(List<Order> orders, int id)  {
        orders.remove(id-1);
    }
}
