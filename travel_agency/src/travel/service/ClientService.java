package travel.service;

import travel.data.clients.ClientHandler;
import travel.essense.Client;

import java.io.IOException;

public class ClientService {
    public static void addNewClient(Client client) throws IOException {
        ClientHandler.addClient(client);
    };
    public static void findByEmail(String email) {
        ClientHandler.findByEmail(email);
    };
    public static void deleteClient(int id) throws IOException {
        ClientHandler.deleteClient(id);
    };

    public static void printAllClients(){
        ClientHandler.printAllClients();
    }

}
