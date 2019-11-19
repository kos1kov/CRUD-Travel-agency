package travel.view;

import travel.data.FileSerializer;
import travel.data.clients.*;
import travel.data.orders.DeleteOrder;
import travel.data.orders.DisplayOrder;
import travel.data.orders.OrderComparatorByPrice;
import travel.data.orders.SearchOrder;
import travel.data.resort.*;
import travel.essense.*;
import travel.service.ClientService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class View {

    private static List<Client> clients = new ArrayList<Client>();
    private static List<Resort> resorts = new ArrayList<Resort>();
    private static List<Order> orders1 = new ArrayList<Order>();
    private static Scanner myObj = new Scanner(System.in);
    public static void action() throws IOException, ClassNotFoundException {

        var fileSerializer = new FileSerializer<>();


        String key = "1";

        while(!key.equals("quit")){
            switch (key){
                case "1":
                    outputAction();
                    break;
                case "2":
                    DisplayOrder.printAllOrders(orders1);
                    break;
                case "3":
                    SaveToFile(fileSerializer);
                    break;
                case "4":
                    ClientHandler.getAllClient();
                    break;
                case "5":
                    System.out.println("enter id of order");
                    var id = Integer.parseInt(myObj.nextLine());
                    DeleteOrder.removeOrder(orders1, id);
                    SaveToFile(fileSerializer);
                    break;
                case "6":
                    System.out.println("enter first name");
                    var name = myObj.nextLine ();
                    System.out.println("enter second name ");
                    var name2 = myObj.nextLine ();
                    SearchOrder.findByClient(orders1, name, name2);
                    break;
                case "7":
                    Collections.sort(orders1, new OrderComparatorByPrice());
                    DisplayOrder.printAllOrders(orders1);
                    break;
                case "8":
                    ClientService.printAllClients();
                    break;
                case "9":
                    OutputResorts.printAllResorts(resorts);
                    break;
                case "10":
                    CreateClient();
                    break;
                case "11":
                    AddResort.addResort(resorts, myObj);
                    SaveToFile(fileSerializer);
                    break;
                case "12":
                      System.out.print("Input id: ");
                      id = Integer.parseInt(myObj.nextLine());
                      ClientService.deleteClient(id - 1);
                    break;
                case "13":
                    DeleteResort.deleteResort(resorts, myObj);
                    SaveToFile(fileSerializer);
                    break;
                case "14":
                    System.out.println("enter name of resort");
                    name = myObj.nextLine ();
                    SearchResort.findByName(resorts, name);
                    break;
                case "15":
                    System.out.println("enter user email");
                    name = myObj.nextLine ();
                    ClientService.findByEmail(name);
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
        System.out.println("3 - save to file");
        System.out.println("4 - load from file");
        System.out.println("5 - delete order");
        System.out.println("6 - find orders by first and second");
        System.out.println("7 - sort order by price");
        System.out.println("8 - list of client");
        System.out.println("9 - list of Resort");
        System.out.println("10 - add client");
        System.out.println("11 - add resort");
        System.out.println("12 - delete client");
        System.out.println("13 - delete resort");
        System.out.println("14 - find resort by name");
        System.out.println("15 - find client by email");
    }

    private static void loadFromFile(FileSerializer<Object> fileSerializer) throws IOException, ClassNotFoundException {
        orders1 = (List<Order>) fileSerializer.loadFromFile("order.xml");
        clients = (List<Client>) fileSerializer.loadFromFile("clients.xml");
        resorts = (List<Resort>) fileSerializer.loadFromFile("resorts.xml");
    }

    private static void SaveToFile(FileSerializer<Object> fileSerializer) throws IOException {
        fileSerializer.saveFile(orders1, "order.xml");
        fileSerializer.saveFile(clients, "clients.xml");
        fileSerializer.saveFile(resorts, "resorts.xml");
    }

    private static void CreateClient() throws IOException {
        System.out.print("Input first name: ");
        var firstName = myObj.nextLine();
        System.out.print("Input last name: ");
        var lastName = myObj.nextLine();
        System.out.print("Input email: ");
        var email = myObj.nextLine();

        Client client = new Client(0, firstName, lastName, email);
        ClientService.addNewClient(client);
    }



    private static void fields(){
        System.out.println("1 - list of fields");
        System.out.println("2 - change first name");
        System.out.println("3 - change last name");
        System.out.println("4 - change email");
        System.out.println("quit - to exit");
    }
}
