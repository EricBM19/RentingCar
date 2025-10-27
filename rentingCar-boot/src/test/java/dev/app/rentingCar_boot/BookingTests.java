package dev.app.rentingCar_boot;

import dev.app.rentingCar_boot.model.Booking;
import dev.app.rentingCar_boot.model.Car;
import dev.app.rentingCar_boot.model.Client;
import dev.app.rentingCar_boot.repository.BookingRepository;
import dev.app.rentingCar_boot.repository.CarRepository;
import dev.app.rentingCar_boot.repository.ClientRepository;
import dev.app.rentingCar_boot.service.GenerateBookingService;
import dev.app.rentingCar_boot.utils.PopulateBooking;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class BookingTests {

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    CarRepository carRepository;

    @Autowired
    PopulateBooking populateBooking;

    @Autowired
    GenerateBookingService generateBookingService;

    @Test
    void bookingTest() {

        List<String> addresses = new ArrayList<>();

        addresses.add("89 Pinehill Drive, Rivertown, TX 75001");
        addresses.add("67 Brookside Lane, Milltown, MA 02130");

        Client client = new Client("John", "Doe", "jdoe@gmail.com", false, 35, "1234");
        client.setAddresses(addresses);

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

    @Test
    void populateBookingMethodTest() {
        populateBooking.populateBooking(10);
    }

    @Test
    void checkCarAvailability() {

        Car car = carRepository.findById("CR8604").get();
        Client client = clientRepository.findById("CLI4610").get();
        String generatedResult = generateBookingService.generateBooking(car, 20486, 0, client, 2026);
        System.out.println(generatedResult);
    }
}