package travel.data.orders;

import travel.data.FileSerializer;
import travel.essense.Order;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrderHandler {

    public static FileSerializer fileSerializer = new FileSerializer<Order>();
    private static List<Order> orders = new ArrayList<Order>();
    public static void addOrder(Order order) throws IOException {
        if (orders.size() == 0){
            order.setId(0);
        }else {
            order.setId(orders.get(orders.size() - 1).getId() + 1);
        }
        orders.add(order);
        fileSerializer.saveFile(orders, "orders.xml");
    }

    public static void deleteOrder(int id) throws IOException {
        orders.remove(id);
        fileSerializer.saveFile(orders, "orders.xml");
    }

    public static void printAllOrders(){
        for (var order : orders) {
            System.out.println(order.toString());
        }
    }

    public static void getAllOrder() throws IOException, ClassNotFoundException {
        orders = (List<Order>) fileSerializer.loadFromFile("orders.xml");
    }
    public static void findByName(String secondName, String firstName){
        orders.stream().filter(order -> secondName.equals(order.getClient().getLastName())
                && firstName.equals(order.getClient().getFirstName())).forEach((order) -> System.out.println(order.toString()));
    }

    public static void SortOrders(){
        Collections.sort(orders, new OrderComparatorByPrice());
        printAllOrders();
    }
}
