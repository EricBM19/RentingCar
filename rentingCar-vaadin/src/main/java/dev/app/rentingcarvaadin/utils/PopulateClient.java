package dev.app.rentingcarvaadin.utils;

import dev.app.rentingcarvaadin.model.Client;
import dev.app.rentingcarvaadin.model.DrivingCourse;
import dev.app.rentingcarvaadin.repository.ClientRepository;
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
        String [] passwords = {"Skyline89!", "Moon_23fox", "T!ger007", "Nova*456", "BlueLeaf9", "Echo!7run", "Zebra#21", "Minty$88", "Frost_3x", "Brick!11"};

        for (int i = 0; i < qty; i++) {

            String name = names[random.nextInt(names.length)];
            String lastName = surnames[random.nextInt(surnames.length)];
            String email = name.toLowerCase() + "@gmail.com";
            boolean isPremium = random.nextBoolean();
            int age = random.nextInt(18,80);
            String password = passwords[random.nextInt(passwords.length)];
            List<String> addresses = assignAddressToAddresses();

            Client client = new Client(name, lastName, email, isPremium, age, password);
            client.setAddresses(addresses);
            generatedClients.add(client);
            clientRepository.save(client);
        }

        return generatedClients;
    }

    public List<String> assignAddressToAddresses () {

        String [] adresses = {"123 Maple Street, Springfield, IL 62704" , "742 Evergreen Terrace, Springfield, OR 97477", "456 Oak Avenue, Fairview, CA 94541",
                "89 Pinehill Drive, Rivertown, TX 75001", "321 Elm Street, Lakeside, FL 32055", "800 Sunset Blvd, Westbridge, NY 10001",
                "67 Brookside Lane, Milltown, MA 02130", "55 Cedar Way, Ashford, WA 98304", "909 Birchwood Road, Greenville, NC 27834",
                "2020 Horizon Court, Redwood, CO 80128"};


        Random random = new Random();
        List <String> addressesToAdd = new ArrayList<>();

        int numOfAddresses = random.nextInt(1,3);

        while (addressesToAdd.size() < numOfAddresses) {

            String address = adresses[random.nextInt(adresses.length)];

            if (!addressesToAdd.contains(address)) {
                addressesToAdd.add(address);
            }
        }

        return addressesToAdd;
    }
}
