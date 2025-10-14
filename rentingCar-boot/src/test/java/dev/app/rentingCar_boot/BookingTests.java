package dev.app.rentingCar_boot;

import dev.app.rentingCar_boot.model.Booking;
import dev.app.rentingCar_boot.model.Car;
import dev.app.rentingCar_boot.model.Client;
import dev.app.rentingCar_boot.repository.BookingRepository;
import dev.app.rentingCar_boot.repository.CarRepository;
import dev.app.rentingCar_boot.repository.ClientRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookingTests {

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    CarRepository carRepository;

    @Test
    void bookingTest() {

        Client client = new Client("John", "Doe", "Fake Street 1234", "jdoe@gmail.com", false, 35, "1234" );

        clientRepository.save(client);

        Car car = carRepository.findById("1263").get();

        Booking booking = new Booking();
        booking.setId("B001");
        booking.setBookingDate(1760349646);
        booking.setQtyDays(5);
        booking.setTotalAmount(160.55);
        booking.setActive(true);

        booking.setClientFK(client);
        booking.setCarFK(car);

        bookingRepository.save(booking);

        System.out.println("Booking: " + booking);
    }
}
