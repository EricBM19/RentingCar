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
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

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

    @Test
    void findByIsActiveTrue() {

        List<Booking> bookings = (List<Booking>) bookingRepository.findAll();
        List<Booking> activeBookings = new ArrayList<>();

        for(Booking booking: bookings) {
            if (booking.isActive()) {
                activeBookings.add(booking);
            }
        }

        for (int i = 0; i < activeBookings.size(); i++) {
            System.out.println(activeBookings.get(i));
        }
    }

    @Test
    void findByIsActiveFalse() {
        List<Booking> bookings = (List<Booking>) bookingRepository.findAll();
        List<Booking> inactiveBookings = new ArrayList<>();

        for(Booking booking: bookings) {
            if (!booking.isActive()) {
                inactiveBookings.add(booking);
            }
        }

        for (int i = 0; i < inactiveBookings.size(); i++) {
            System.out.println(inactiveBookings.get(i));
        }
    }

    @Test
    void findByCar() {

        Car car = carRepository.findById("CR8604").get();

        List<Booking> myBooking = bookingRepository.findByCarFK(car);

        for (Booking booking: myBooking) {
            System.out.println("Booking: " + booking);
        }
    }

    @Test
    void findByClient() {

        Client client = clientRepository.findById("CLI4610").get();

        List<Booking> myBooking = bookingRepository.findByClientFK(client);

        for (Booking booking: myBooking) {
            System.out.println("Booking: " + booking);
        }
    }

    @Test
    void findByBookingDateBetween() {

        List<Booking> bookings = (List<Booking>) bookingRepository.findAll();

        for (Booking booking: bookings) {
            if (booking.getBookingDate() >= 20498 && booking.getBookingDate() <= 20628) {
                System.out.println("Booking: " + booking);
            }
        }
    }

    @Test
    void findByCarAndIsActiveTrue () {
        Car car = carRepository.findById("CR8182").get();
        List<Booking> bookings = (List<Booking>) bookingRepository.findAll();

        for (Booking booking: bookings) {
            if (booking.getCarFK().getId().equals(car.getId()) && booking.isActive()) {
                System.out.println("Booking :" + booking);
            }
        }
    }

    @Test
    void findByTotalAmountGreaterThan() {
        List<Booking> bookings = (List<Booking>) bookingRepository.findAll();

        for (Booking booking: bookings) {
            if (booking.getTotalAmount() >= 400.00) {
                System.out.println("Booking :" + booking);
            }
        }
    }

    @Test
    void findByQtyDays () {
        List<Booking> bookings = (List<Booking>) bookingRepository.findAll();

        for (Booking booking: bookings) {
            if (booking.getQtyDays() == 14) {
                System.out.println("Booking :" + booking);
            }
        }
    }

    @Test
    void testQuery() {
        Car car = carRepository.findById("CR8182").get();

        List<Booking> myBooking = bookingRepository.findOverlappingBookingsForCar(car, 20498, 20628);

        if (!myBooking.isEmpty()) {
            for (Booking booking: myBooking) {
                System.out.println("Booking: " + booking);
            }
        }
        else System.out.println("Not bookings for that query");
    }

    @Test
    void findTop10ByOrderByTotalAmountDesc() {

        List<Booking> orderedBookings = bookingRepository.findTop10ByOrderByTotalAmountDesc();

        for (Booking booking: orderedBookings) {
            System.out.println("Booking: " + booking);
        }
    }
}