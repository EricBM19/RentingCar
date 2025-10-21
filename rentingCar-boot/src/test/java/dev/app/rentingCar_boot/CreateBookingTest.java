package dev.app.rentingCar_boot;

import dev.app.rentingCar_boot.model.Client;
import dev.app.rentingCar_boot.repository.ClientRepository;
import dev.app.rentingCar_boot.utils.BookingCreator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CreateBookingTest {

    @Autowired
    BookingCreator bookingCreator;

    @Autowired
    ClientRepository clientRepository;

    @Test
    void createBooking() {

        Client client = clientRepository.findById("CLI6470").get();
        bookingCreator.createBooking(1792486800,8,150.0, true, "CR6362", client);
    }

}
