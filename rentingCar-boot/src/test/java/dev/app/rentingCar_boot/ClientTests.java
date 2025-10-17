package dev.app.rentingCar_boot;

import dev.app.rentingCar_boot.repository.ClientRepository;
import dev.app.rentingCar_boot.utils.PopulateClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ClientTests {

    @Autowired
    PopulateClient populateClient;

    @Test
    void populateClientMethodTest(){
        populateClient.generateClients(10);
    }
}
