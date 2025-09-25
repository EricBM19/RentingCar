package org.example;

import com.github.javafaker.Faker;
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

    public static ArrayList createFakeCarList() {

        ArrayList<Car> carList = new ArrayList<Car>();
        Faker faker = new Faker();

        for(int i = 0; i < 100; i++)
        {
            Car myCar = new Car();
            myCar.setId(String.valueOf(i));
            myCar.setBrand(faker.company().name());
            myCar.setModel(faker.ancient().primordial());
            myCar.setPlate(faker.bothify("???-####"));
            myCar.setYear(faker.number().numberBetween(1990, 2024));
            myCar.setPrice(faker.number().randomDouble(2, 20, 500));
            carList.add(myCar);
        }

        return carList;
    }
}
