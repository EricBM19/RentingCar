package org.example.views;

import org.example.model.MinimalClient;
import org.example.utilities.Utilities;

import java.util.Scanner;

public class LoginView {

    public static MinimalClient showLoginView(Scanner sc) {

        System.out.println("\n");
        System.out.println("Login View:");
        System.out.println("----------------------");

        String email = Utilities.ask(sc, "Email? ");
        String password = Utilities.ask(sc, "Password? ");

        MinimalClient minimalClient = new MinimalClient(email, password);

        return minimalClient;
    }
}
