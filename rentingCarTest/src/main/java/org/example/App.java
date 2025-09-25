package org.example;

import java.util.ArrayList;
import java.util.Scanner;

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

        FakeDataDBPopulator.populateDBByCars(myDataStore);

        //RentingCarTests.createFakeCarList();
        //RentingCarTests.myDataStoreTest();

        System.out.println("Finished!");
    }
}
