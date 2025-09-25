package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class App
{
    static Scanner sc = new Scanner(System.in);
    private final static ArrayList<Car> rentingCarList = RentingCarTests.createFakeCarList();

    public static void main( String[] args ) {
        System.out.println( "Starting code..." );

        mainMenu();

        System.out.println("Finished!");
    }

    public static void mainMenu() {

        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1.Tests");
            System.out.println("2.List cars");
            System.out.println("3.Login client");
            System.out.println("4.Make a Booking");
            System.out.println("0.Quit");

            int option = sc.nextInt();

            if (option == 1)
            {
               testTest();
            }
            else if (option == 2)
            {
                listCars();
            }
            else if (option == 3)
            {
                System.out.println("Login client - Not implemented yet");
            }
            else if (option == 4)
            {
                makeBooking();
            }
            else if (option == 0)
            {
                System.out.println("Exiting...");
                break;
            }
            else
            {
                System.out.println("Invalid option");
            }
        }
    }

    public static void testTest() {
        System.out.println("Choose an option:");
        System.out.println("1.Test a car");
        System.out.println("2.Test a client");
        System.out.println("3.Test ArrayList");
        System.out.println("0.Back to main menu");

        int testOption = sc.nextInt();

        if (testOption == 1)
        {
            RentingCarTests.testCar();
            mainMenu();
        }
        else if (testOption == 2)
        {
            RentingCarTests.testClient();
            mainMenu();
        }
        else if (testOption == 3)
        {
            RentingCarTests.testArrayList();
            mainMenu();
        }
        else if (testOption == 0)
        {
            mainMenu();
        }
        else
        {
            System.out.println("Invalid option");
            testTest();
        }
    }

    public static void listCars() {
        for (int i = 0; i < rentingCarList.size(); i++)
        {
            System.out.println(rentingCarList.get(i));
        }
        mainMenu();
    }

    public static void makeBooking() {

        System.out.println("Select a car by its ID:");
        int carId = sc.nextInt();
        System.out.println(rentingCarList.get(carId));
        System.out.println("How many days do you want to rent the car?");
        int days = sc.nextInt();
        double carPrice = rentingCarList.get(carId).getPrice();
        double price = days * carPrice;
        System.out.println("The total price is: " + price);
        mainMenu();
    }
}
