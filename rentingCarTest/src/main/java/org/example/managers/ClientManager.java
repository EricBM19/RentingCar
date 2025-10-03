package org.example.managers;
import org.example.dataStore.DataStore;
import org.example.model.Client;
import org.example.model.MinimalClient;
import org.example.views.LoginView;

import java.util.List;
import java.util.Scanner;

public class ClientManager {

    public static void printClientList (List<Client> clients) {

        System.out.println("Clients from DB: ");
        System.out.println("---------------");
        System.out.println("Size DB: " + clients.size());

        for (Client client: clients) {
            System.out.println(client);
        }

        System.out.println("\n");
    }

    public static Client loginClient(DataStore myDataStore, Scanner sc) {

        // Invoke view to get minimal client
        MinimalClient minimalClient = LoginView.showLoginView(sc);
        // Validate minimal client
        Client validatedClient = validateLogin(minimalClient, myDataStore);

        if (validatedClient == null) {
            System.out.println("Login failed, invalid email or password.");
        } else {
            System.out.println("Login successful, welcome " + validatedClient.getName() + "!");
            myDataStore.setLoggedClient(validatedClient);
            return validatedClient;
        }



        return null;
    }

    public static Client validateLogin (MinimalClient minimalClient, DataStore myDataStore) {

        List <Client> clients = myDataStore.getClients();

        for (Client client : clients) {
            if (client.getEmail().equals(minimalClient.getEmail()) && client.getPassword().equals(minimalClient.getPassword())) {
                return client;
            }
        }


        return null;
    }
}
