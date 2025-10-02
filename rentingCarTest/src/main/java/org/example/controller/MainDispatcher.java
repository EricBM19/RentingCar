package org.example.controller;

import org.example.dataStore.DataStore;
import org.example.managers.BookingManager;
import org.example.managers.CarManager;
import org.example.utilities.RentingCarTests;
import org.example.utilities.Utilities;
import org.example.views.MainMenuView;

import java.util.Scanner;

public class MainDispatcher {

    public static void runner (DataStore myDataStore) {

        Scanner sc = new Scanner(System.in);

        while (true)
        {
            MainMenuView.showMainMenu();
            String option = Utilities.ask(sc, "Please select an option: ");

            if (option.equals("0")) {
                break;
            }
            else if (option.equals("1")) {
                RentingCarTests.testCar();
            }
            else if (option.equals("2")) {
                CarManager.printCarList(myDataStore.getCars());
            }
            else if (option.equals("3")) {
                System.out.println("Not implemented yet");
            }
            else if (option.equals("4")) {

               if (myDataStore.getLoggedClient() == null) {
                   System.out.println("You need to be logged in to rent a car.");
                }
               else {
                   BookingManager.createBooking(myDataStore);
               }
            }
            else {
                System.out.println("Invalid option, please try again.");
            }
        }
    }
}
