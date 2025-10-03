package org.example.utilities;

import com.github.javafaker.Faker;
import org.example.dataStore.DataStore;
import org.example.model.Car;
import org.example.model.Client;

public class FakeDataDBPopulator {

    public static void populateDBByCars (DataStore myDataStore) {

        // create fake object
        // loop with faker to create 100 cars
        // create new car
        // set car properties with faker
        // add car to the list of the data store
        // myDataStore.getCars().add(myCar);
        // end loop

        Faker faker = new Faker();

        for (int i = 0; i < 100; i++) {
            Car myCar = new Car();
            myCar.setId(String.valueOf(faker.number().randomNumber()));
            myCar.setBrand(faker.company().name());
            myCar.setModel(faker.artist().name());
            myCar.setPlate(faker.code().asin());
            myCar.setYear(faker.number().numberBetween(1980, 2024));
            myCar.setPrice(faker.number().numberBetween(20, 250));

            // add fake car to the DB list
            myDataStore.getCars().add(myCar);
        }
    }

    public static void populateDBByClients (DataStore myDataStore) {

        Faker faker = new Faker();

        for (int i = 0; i < 100; i++) {
            Client myClient = new Client();
            myClient.setId(String.valueOf(faker.number().randomNumber()));
            myClient.setName(faker.name().firstName());
            myClient.setLastName(faker.name().lastName());
            myClient.setAddress(faker.address().fullAddress());
            myClient.setEmail(myClient.getName().toLowerCase() + "@gmail.com");
            myClient.setPremium(faker.bool().bool());
            myClient.setPassword(faker.internet().password());

            myDataStore.getClients().add(myClient);
        }

        Client hardCodedClient = new Client();
        hardCodedClient.setId("1");
        hardCodedClient.setName("John");
        hardCodedClient.setLastName("Doe");
        hardCodedClient.setAddress("123 Main St, Anytown, USA");
        hardCodedClient.setEmail("john@gmail.com");
        hardCodedClient.setPremium(true);
        hardCodedClient.setPassword("1234");
        myDataStore.getClients().add(hardCodedClient);
    }
}
