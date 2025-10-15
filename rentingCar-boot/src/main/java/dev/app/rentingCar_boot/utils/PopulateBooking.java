package dev.app.rentingCar_boot.utils;

import dev.app.rentingCar_boot.model.Booking;
import dev.app.rentingCar_boot.model.Car;
import dev.app.rentingCar_boot.model.Client;
import dev.app.rentingCar_boot.repository.BookingRepository;
import dev.app.rentingCar_boot.repository.CarRepository;
import dev.app.rentingCar_boot.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class PopulateBooking {

    @Autowired
    CarRepository carRepository;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    BookingRepository bookingRepository;

    public void populateBooking(int qty) {

        List<Booking> bookings = genarateBooking(qty);
        List<Car> cars = (List<Car>) carRepository.findAll();
        List<Client> clients = (List<Client>) clientRepository.findAll();

        assignCarAndClientToBooking(cars, clients, bookings);
    }

    public List<Booking> genarateBooking (int qty) {

        List<Booking> generatedBookings = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < qty; i++) {

            int bookingDate = random.nextInt(1514800800, 1760443927);
            int days = random.nextInt(1,20);
            double amount = random.nextDouble(50,600);
            boolean isActive = random.nextBoolean();

            Booking booking = new Booking(bookingDate,days,amount,isActive,null,null);
            generatedBookings.add(booking);
            bookingRepository.save(booking);
        }

        return generatedBookings;
    }

    public void assignCarAndClientToBooking(List<Car> cars, List<Client> clients, List<Booking> bookings) {

        Random random = new Random();

        for (Booking booking : bookings) {

            Car car = cars.get(random.nextInt(cars.size()));
            Client client = clients.get(random.nextInt(clients.size()));

            booking.setCarFK(car);
            booking.setClientFK(client);

            bookingRepository.save(booking);
        }
    }
}
