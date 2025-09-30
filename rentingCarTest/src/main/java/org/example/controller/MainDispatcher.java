package org.example.controller;

import org.example.dataStore.DataStore;
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
            break;
        }
    }
}
