package travel.data.orders;

import travel.data.resort.OutputResorts;
import travel.essense.Client;
import travel.essense.Order;
import travel.essense.Resort;

import java.util.List;
import java.util.Scanner;

public class AddOrder {
    public static void addOrder(List<Order> orders, Scanner in, List<Client> clients, List<Resort> resorts){
        if(!clients.isEmpty() || !resorts.isEmpty()){
            Order order = new Order();

            order.setId(orders.size() + 1);

//            OutputClients.printAllClients(clients);
            System.out.print(" Choose client by id: ");
            int clientIndex = Integer.parseInt(in.nextLine());
            order.setClient(clients.get(clientIndex - 1));

            OutputResorts.printAllResorts(resorts);
            System.out.print(" Choose resort by id: ");
            int resortIndex = Integer.parseInt(in.nextLine());
            order.setResort(resorts.get(resortIndex - 1));

            System.out.print(" Enter price: ");
            order.setPrice(Integer.parseInt(in.nextLine()));

            orders.add(order);
        }else {
            System.out.print(" Sorry create  user or resort at first: ");
        }

    }

}
