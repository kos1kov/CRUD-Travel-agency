package travel.service;



import travel.data.orders.OrderHandler;
import travel.essense.Order;

import java.io.IOException;

public class OrderService {
    public static void addNewOrder(Order order) throws IOException {
        OrderHandler.addOrder(order);
    };
    public static void findByName(String secondName, String firstName) {
        OrderHandler.findByName(secondName, firstName);
    };
    public static void deleteOrder(int id) throws IOException {
        OrderHandler.deleteOrder(id);
    };

    public static void printAllOrders(){
        OrderHandler.printAllOrders();
    }

    public static void SortOrders(){
        OrderHandler.SortOrders();
    }
}
