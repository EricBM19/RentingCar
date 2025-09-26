package org.example;

import com.github.javafaker.Faker;

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

        for (int i = 0; i < 100; i++)
        {
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
}
