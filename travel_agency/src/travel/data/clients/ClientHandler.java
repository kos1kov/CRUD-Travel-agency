package travel.data.clients;

import travel.data.FileSerializer;
import travel.essense.Client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClientHandler {
    public static FileSerializer fileSerializer = new FileSerializer<Client>();
    private static List<Client> clients = new ArrayList<Client>();
    public static void addClient(Client client) throws IOException {
        client.setId(clients.get(clients.size()).getId() + 1);
        clients.add(client);
        fileSerializer.saveFile(clients, "clients.xml");
    }

    public static void deleteClient(int id) throws IOException {
        clients.remove(id);
        fileSerializer.saveFile(clients, "clients.xml");
    }

    public static void printAllClients(){
        for (var client : clients) {
            System.out.println(client.toString());
        }
    }

    public static void getAllClient() throws IOException, ClassNotFoundException {
        clients = (List<Client>) fileSerializer.loadFromFile("clients.xml");
    }
    public static void findByEmail(String email){
        clients.stream().filter(client -> email.equals(client.getEmail())).forEach((client) -> System.out.println(client.toString()));
    }
}
