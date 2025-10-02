package org.example.managers;

import org.example.dataStore.DataStore;
import org.example.model.Booking;
import org.example.model.Car;
import org.example.utilities.Utilities;

import java.util.Scanner;

public class BookingManager {

    public static void createBooking(DataStore myDataStore, Scanner sc) {

        System.out.println("Welcome to Booking Manager");
        System.out.println("--------------------------");

        // Implementation for creating a booking
        System.out.println("Logged in client name: " + myDataStore.getLoggedClient().getName());
        System.out.println("Logged in client ID: " + myDataStore.getLoggedClient().getId());
        System.out.println("Logged in client mail: " + myDataStore.getLoggedClient().getEmail());

        Booking booking = new Booking();
        booking.setId("1");

        String daysRented = Utilities.ask(sc, "For how many days do you want to rent the car? ");
        int intDaysRented = Integer.parseInt(daysRented);

        booking.setDays(intDaysRented);
        booking.setActive(true);
        booking.setClient(myDataStore.getLoggedClient());

        CarManager.printCarList(myDataStore.getCars());

        String carIndex = Utilities.ask(sc, "Car index?");
        Car selectedCar = myDataStore.getCars().get(Integer.parseInt(carIndex) - 1);
        booking.setCar(selectedCar);

        booking.setPrice(intDaysRented * selectedCar.getPrice());

        booking.setCar(selectedCar);

        System.out.println("Booking details: " + booking.toString());

    }
}
