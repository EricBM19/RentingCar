package org.example.managers;
import org.example.model.Client;

import java.util.List;

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

    public static Client logingClient () {

        // to do: implement view, where? / views
        // to do: business logic: check if client exist

        Client hardCodedClient = new Client();
        hardCodedClient.setId("1");
        hardCodedClient.setName("John");
        hardCodedClient.setEmail("johndoe@gmail.com");

        return hardCodedClient;
    }
}
