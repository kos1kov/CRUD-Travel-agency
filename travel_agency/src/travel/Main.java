package travel;

import travel.data.FileSerializer;
import travel.essense.*;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Scanner myObj = new Scanner(System.in);
        var fileSerializer = new FileSerializer<>();

        OrderHandler ordersHandler = (OrderHandler) fileSerializer.loadFromFile();
        var orders = ordersHandler.getOrders();

        if (orders.isEmpty()) {
            var customer1 = new Client("Dmitriy", "Kosikov", "dk@mail.ru");
            var customer2 = new Client("Artem", "Gotovchikov", "ag1@mail.ru");

            var belarus = new Country("Belarus");
            var egypt = new Country("Egypt");
            var turkey = new Country("Turkey");

            var hotel1 = new Hotel("SeaHotel", 5);
            var hotel2 = new Hotel("TurkeyHotel", 3);

            var resort1 = new Resort("Egypt resort", hotel1);
            var resort2 = new Resort("Turkey resort", hotel2);

            var airplane = new Transport("airplane");
            var bus = new Transport("bus");

            var price1 = new Price(1000, 500);
            var price2 = new Price(2000, 1000);

            var order1 = new Order(customer1, belarus, egypt,
                    LocalDate.of(2019, 12, 23),
                    LocalDate.of(2020, 1, 23), resort1, price1, airplane);

            var order2 = new Order(customer2, belarus, turkey,
                    LocalDate.of(2019, 12, 23),
                    LocalDate.of(2020, 1, 23), resort2, price2, bus);

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
                for (var order : orders) {
                    System.out.println(ordersHandler.print(order));
                }
                break;
            case "5":
                System.out.println("Create customer");

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
        System.out.println("3 - find by customer");
        System.out.println("4 - find by destination country");
        System.out.println("5 - create order");

    }
}
