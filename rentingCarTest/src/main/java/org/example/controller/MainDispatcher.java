package org.example.controller;

import org.example.dataStore.DataStore;
import org.example.managers.CarManager;
import org.example.utilities.RentingCarTests;
import org.example.utilities.Utilities;
import org.example.views.MainMenuView;

import java.util.Scanner;

public class MainDispatcher {

    public static void runner (DataStore myDataStore) {

        Scanner sc = new Scanner(System.in);
        boolean userLoggedIn = false;

        while (true)
        {
            MainMenuView.showMainMenu(userLoggedIn);
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
        }
    }
}
