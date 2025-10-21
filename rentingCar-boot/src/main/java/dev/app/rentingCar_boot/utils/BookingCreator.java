package dev.app.rentingCar_boot.utils;

import dev.app.rentingCar_boot.model.BookedDate;
import dev.app.rentingCar_boot.model.Booking;
import dev.app.rentingCar_boot.model.Car;
import dev.app.rentingCar_boot.model.Client;
import dev.app.rentingCar_boot.repository.BookingRepository;
import dev.app.rentingCar_boot.repository.CarRepository;
import dev.app.rentingCar_boot.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookingCreator {

    @Autowired
    CarRepository carRepository;

    @Autowired
    BookingRepository bookingRepository;

    public void createBooking(int bookingDate, int qtyDays, double totalAmount, boolean isActive, String carId, Client client) {

        Car carToBook = carRepository.findById(carId).get();

        if (carToBook == null) {
            System.out.println("Car not found");
            return;
        }

        if (carToBook.getBookedDates().isEmpty()) {
            BookedDate bookedDate = new BookedDate(bookingDate, qtyDays);
            carToBook.getBookedDates().add(bookedDate);
            carRepository.save(carToBook);

            Booking booking = new Booking(bookingDate, qtyDays, totalAmount, isActive, carToBook, client);
            bookingRepository.save(booking);

            System.out.println("Booking created for car: " + carToBook.getPlate());
        }
    }
}
