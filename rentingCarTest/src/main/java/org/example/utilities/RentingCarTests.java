package org.example.utilities;

import com.github.javafaker.Faker;
import org.example.managers.CarManager;
import org.example.dataStore.DataStore;
import org.example.model.Car;
import org.example.model.Client;

import java.util.ArrayList;

public class RentingCarTests
{
    public static void testCar () {

        System.out.println("Printing car info...");
        Car bmw001 = new Car("1", "4759N", "BMW", "M3", 2022, 100.0);
        System.out.println(bmw001);
    }

    public static void testClient () {

        System.out.println("Printing client info...");
        Client client001 = new Client("1", "John", "Doe", "123 Main St", "jdoe@gmail.com", true);
        System.out.println(client001);
    }

    public static void testArrayList() {

        ArrayList<Car> cars = new ArrayList<Car>();
        cars.add(new Car("1", "4759N", "BMW", "M3", 2022, 100.0));
        System.out.println(cars.get(0));
    }

    public static void createFakeCarList() {

        ArrayList<Car> cars = new ArrayList<>();
        Faker faker = new Faker();

        for (int i = 0; i < 100; i++) {
            // create a car object
            Car myCar = new Car();
            // set fake data
            myCar.setId(String.valueOf(faker.number().randomNumber()));
            myCar.setBrand(faker.company().name());
            myCar.setModel(faker.artist().name());
            myCar.setPlate(faker.code().asin());
            myCar.setYear(faker.number().numberBetween(1980, 2024));
            myCar.setPrice(faker.number().numberBetween(20, 250));
            // add myCar to the list
            cars.add(myCar);
        }

        System.out.println("\n");
        System.out.println("This is my list of cars: ");
        System.out.println("-------------------------");
        System.out.println("The list has " + cars.size() + " cars");
        System.out.println("\n");

        // Print each car on a separate line
        for (Car car : cars) {
            System.out.println("\t" + car);
        }
        System.out.println("\n");
    }

    public static void myDataStoreTest() {

        DataStore myDataStoreTest = new DataStore();

        Car myCar = new Car();
        myCar.setId("1");
        myCar.setBrand("BMW");
        myCar.setModel("M3");
        myCar.setPlate("A123DFGR4");
        myCar.setYear(2022);

        Car myCar2 = new Car();
        myCar2.setId("2");
        myCar2.setBrand("Mazda");
        myCar2.setModel("Mazda 3");
        myCar2.setPlate("B123DFGR4");
        myCar2.setYear(2021);

        myDataStoreTest.getCars().add(myCar);
        myDataStoreTest.getCars().add(myCar2);

        CarManager.printCarList(myDataStoreTest.getCars());

        myDataStoreTest.getCars().get(0).setPlate("1111111");

        CarManager.printCarList(myDataStoreTest.getCars());
    }
}
