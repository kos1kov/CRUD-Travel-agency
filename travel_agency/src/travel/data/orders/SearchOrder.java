package travel.data.orders;

import travel.essense.Order;

import java.util.List;

public class SearchOrder {
    public static void findByClient(List<Order> orders, String firstName, String secondName){
        orders.stream().filter(order -> secondName.equals(order.getClient().getLastName())
                && firstName.equals(order.getClient().getFirstName())).forEach((order) -> System.out.println(order.print()));
    }
}
