package travel;

import travel.data.FileSerializer;
import travel.data.OrderComparatorByPrice;
import travel.data.OrderHandler;
import travel.essense.*;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Client> clients;
    private static List<Country> countries;
    private static List<Hotel> hotels;
    private static List<Resort> resorts;
    private static List<Transport> transports;
    private static List<Order> orders;
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        clients = new ArrayList<Client>();
        countries = new ArrayList<Country>();
        hotels = new ArrayList<Hotel>();
        resorts = new ArrayList<Resort>();
        transports = new ArrayList<Transport>();
        Scanner myObj = new Scanner(System.in);
        var fileSerializer = new FileSerializer<>();

        OrderHandler ordersHandler = new OrderHandler(); //
        orders = ordersHandler.getOrders();

        if (orders.isEmpty()) {
            var customer1 = new Client("Dmitriy", "Kosikov", "dk@mail.ru");
            var customer2 = new Client("Artem", "Gotovchikov", "ag1@mail.ru");
            clients.add(customer1);
            clients.add(customer2);

            var belarus = new Country("Belarus");
            var egypt = new Country("Egypt");
            var turkey = new Country("Turkey");
            countries.add(belarus);
            countries.add(egypt);
            countries.add(turkey);

            var hotel1 = new Hotel("SeaHotel", 5);
            var hotel2 = new Hotel("TurkeyHotel", 3);
            hotels.add(hotel1);
            hotels.add(hotel2);

            var resort1 = new Resort("Egypt resort", hotel1);
            var resort2 = new Resort("Turkey resort", hotel2);
            resorts.add(resort1);
            resorts.add(resort2);

            var airplane = new Transport("airplane");
            var bus = new Transport("bus");
            transports.add(airplane);
            transports.add(bus);

            var order1 = new Order(1,customer1, belarus, egypt,
                    LocalDate.of(2019, 12, 23),
                    LocalDate.of(2020, 1, 23), resort1, 900, airplane);

            var order2 = new Order(2,customer2, belarus, turkey,
                    LocalDate.of(2019, 12, 23),
                    LocalDate.of(2020, 1, 23), resort2, 500, bus);

            ordersHandler.addOrder(order1);
            ordersHandler.addOrder(order2);

            fileSerializer.saveFile(ordersHandler);
        }
        String key = "";

        while(!key.equals("quit")){
        switch (key){
            case "1":
                outputAction();
                break;
            case "2":
                ordersHandler.printAllOrders();
                break;
            case "3":
                fileSerializer.saveFile(ordersHandler);
                break;
            case "4":
                var ordersFromFile = (OrderHandler) fileSerializer.loadFromFile();
                orders = ordersFromFile.getOrders();
                for (var order : orders) {
                    ordersHandler.addOrder(order);
                }
                break;
            case "5":
                System.out.println("enter id of order");
                var id = myObj.nextLine ();
                ordersHandler.removeOrder(Integer.parseInt(id));
                break;
            case "6":
                System.out.println("enter second name of client");
                var name = myObj.nextLine ();
                var orders = ordersHandler.findByClient(name);
                for (var order : orders) {
                    System.out.println(ordersHandler.print(order));
                }
            case "7":
                Collections.sort(ordersHandler.getOrders(), new OrderComparatorByPrice());
                ordersHandler.printAllOrders();
                break;
                default:
                    System.out.println(key);
        }
            key = myObj.nextLine ();
        }
    }

    public static void outputAction(){
        System.out.println("1 - list of action");
        System.out.println("2 - list of orders");
        System.out.println("3 - save to file");
        System.out.println("4 - load from file");
        System.out.println("5 - delete order");
        System.out.println("6 - find client by first name and second name");
        System.out.println("7 - sort order by price");

    }
}
