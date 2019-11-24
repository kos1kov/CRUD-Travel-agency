package travel.view;

import travel.data.FileSerializer;
import travel.data.clients.ClientHandler;
import travel.db.Migrator;
import travel.essense.Client;
import travel.essense.Order;
import travel.essense.Resort;
import travel.service.ClientService;
import travel.service.OrderService;
import travel.service.ResortService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class View {

    private static List<Client> clients = new ArrayList<Client>();
    private static List<Resort> resorts = new ArrayList<Resort>();
    private static List<Order> orders1 = new ArrayList<Order>();

    private static Scanner myObj = new Scanner(System.in);
    public static void action() throws IOException, ClassNotFoundException {

        var fileSerializer = new FileSerializer<Client>();
        var migrator = new Migrator();
        migrator.validate("orders.xml", "orders.xsd");
        migrator.validate("clients.xml", "clients.xsd");
        migrator.validate("resorts.xml", "resorts.xsd");
        String key = "1";

        while(!key.equals("quit")){
            switch (key){
                case "1":
                    outputAction();
                    break;
                case "2":
                    OrderService.printAllOrders();
                    break;
                case "3":
                    ClientHandler.getAllClient();
                    break;
                case "4":
                    System.out.println("enter id of order");
                    var id = Integer.parseInt(myObj.nextLine());
                    OrderService.deleteOrder(id);
                    break;
                case "5":
                    System.out.println("enter first name");
                    var name = myObj.nextLine ();
                    System.out.println("enter second name ");
                    var name2 = myObj.nextLine ();
                   OrderService.findByName(name2, name);
                    break;
                case "6":
                    OrderService.SortOrders();
                    break;
                case "7":
                    ClientService.printAllClients();
                    break;
                case "8":
                    ResortService.printAllresorts();
                    break;
                case "9":
                    ClientService.addNewClient(CreateClient());
                    break;
                case "10":
                    ResortService.addNewResort(CreateResort());
                    break;
                case "11":
                      System.out.print("Input id: ");
                      id = Integer.parseInt(myObj.nextLine());
                      ClientService.deleteClient(id - 1);
                    break;
                case "12":
                    System.out.print("Input id: ");
                    id = Integer.parseInt(myObj.nextLine());
                    ResortService.deleteResort(id - 1);
                    break;
                case "13":
                    System.out.println("enter name of resort");
                    name = myObj.nextLine ();
                    ResortService.findByName(name);
                    break;
                case "14":
                    System.out.println("enter user email");
                    name = myObj.nextLine ();
                    ClientService.findByEmail(name);
                    break;
                case "15":
                    OrderService.addNewOrder(CreateOrder());
                    break;
                default:
                    System.out.println(key);
            }
            key = myObj.nextLine ();
        }
    }

    private static void outputAction(){
        System.out.println("1 - list of action");
        System.out.println("2 - list of orders");
        System.out.println("3 - load from file");
        System.out.println("4 - delete order");
        System.out.println("5 - find orders by first and second");
        System.out.println("6 - sort order by price");
        System.out.println("7 - list of client");
        System.out.println("8 - list of Resort");
        System.out.println("9 - add client");
        System.out.println("10 - add resort");
        System.out.println("11 - delete client");
        System.out.println("12 - delete resort");
        System.out.println("13 - find resort by name");
        System.out.println("14 - find client by email");
        System.out.println("15 - add order");
    }

    private static Client CreateClient() throws IOException {
        System.out.print("Input first name: ");
        var firstName = myObj.nextLine();
        System.out.print("Input last name: ");
        var lastName = myObj.nextLine();
        System.out.print("Input email: ");
        var email = myObj.nextLine();

        Client client = new Client(1, firstName, lastName, email);
        return client;
    }

    private static Resort CreateResort() throws IOException {
        System.out.print("Input resort name: ");
        var name = myObj.nextLine();
        System.out.print("Input hotel name: ");
        var hotelName = myObj.nextLine();
        System.out.print("Input numbers of stars: ");
        var stars = Integer.parseInt(myObj.nextLine());

        Resort resort = new Resort(1, name, hotelName, stars);
        return resort;
    }

    private static Order CreateOrder() throws IOException {
        System.out.print("Input price: ");
        var price = Integer.parseInt(myObj.nextLine());
        Order order = new Order(1, CreateClient(), CreateResort(), price);
        return order;
    }
}
