package dev.app.rentingCar_boot.utils;

import dev.app.rentingCar_boot.model.Client;
import dev.app.rentingCar_boot.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class PopulateClient {

    @Autowired
    ClientRepository clientRepository;

    public void populateClient (int qty) {

        List<Client> client = generateClients(qty);
    }

    public List<Client> generateClients (int qty) {

        List<Client> generatedClients = new ArrayList<>();
        Random random = new Random();

        String [] names = {"John", "Mai", "Sonia", "Markus", "James", "Mary", "Jack", "Peter", "Harry", "Heather", "Claire", "Rebecca", "Jake"};
        String [] surnames = {"Doe", "Torres", "Sunderlan", "Ortiz", "Morales", "Flores", "Brown", "Johnson", "Collins", "Cooper", "Foster"};
        String [] adresses = {"123 Maple Street, Springfield, IL 62704" , "742 Evergreen Terrace, Springfield, OR 97477", "456 Oak Avenue, Fairview, CA 94541",
                                "89 Pinehill Drive, Rivertown, TX 75001", "321 Elm Street, Lakeside, FL 32055", "800 Sunset Blvd, Westbridge, NY 10001",
                                "67 Brookside Lane, Milltown, MA 02130", "55 Cedar Way, Ashford, WA 98304", "909 Birchwood Road, Greenville, NC 27834",
                                "2020 Horizon Court, Redwood, CO 80128"};
        String [] passwords = {"Skyline89!", "Moon_23fox", "T!ger007", "Nova*456", "BlueLeaf9", "Echo!7run", "Zebra#21", "Minty$88", "Frost_3x", "Brick!11"};

        for (int i = 0; i < qty; i++) {

            String name = names[random.nextInt(names.length)];
            String lastName = surnames[random.nextInt(surnames.length)];
            String adress = adresses[random.nextInt(adresses.length)];
            String email = name.toLowerCase() + "@gmail.com";
            boolean isPremium = random.nextBoolean();
            int age = random.nextInt(18,80);
            String password = passwords[random.nextInt(passwords.length)];

            Client client = new Client(name, lastName, adress, email, isPremium, age, password);
            generatedClients.add(client);
            clientRepository.save(client);
        }

        return generatedClients;
    }
}
