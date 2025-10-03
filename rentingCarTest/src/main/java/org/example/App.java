package org.example;

import org.example.controller.MainDispatcher;
import org.example.dataStore.DataStore;
import org.example.managers.ClientManager;
import org.example.utilities.FakeDataDBPopulator;

public class App
{
    public static void main( String[] args ) {
        System.out.println( "Starting code..." );

        DataStore myDataStore = new DataStore();
        myDataStore.setId("1");
        myDataStore.setLabel("Renting Car Fake DB V1.0");
        long epoch = System.currentTimeMillis()/1000;
        myDataStore.setCreationDate(epoch);
        myDataStore.setLastModification(epoch);

        // What? populate DB with fake data
        // How? with a static method we add fake data to the list
        // Why? For what? We need data to init out app
        FakeDataDBPopulator.populateDBByCars(myDataStore);

        FakeDataDBPopulator.populateDBByClients(myDataStore);
        ClientManager.printClientList(myDataStore.getClients());

        // Let's create a supper hard coded client

        MainDispatcher.runner(myDataStore);

        System.out.println("Finished!");
    }
}
