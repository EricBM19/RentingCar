package dev.app.rentingcarvaadin.service;

import dev.app.rentingcarvaadin.model.Booking;
import dev.app.rentingcarvaadin.model.Car;
import dev.app.rentingcarvaadin.model.Client;
import dev.app.rentingcarvaadin.repository.BookingRepository;
import dev.app.rentingcarvaadin.repository.CarRepository;
import dev.app.rentingcarvaadin.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Map;

@Service
public class GenerateBookingService {

    @Autowired
    CarRepository carRepository;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    BookingRepository bookingRepository;

    public String generateBooking (Car car, long bookingDate, int qtyDays, Client client, int year) {

        String validationResult = validateBookingData(car,bookingDate,qtyDays,client,year);

        if (!validationResult.equals("All values are valid.")) {
            return validationResult;
        }

        if(!checkAvailability(car, bookingDate, qtyDays)) {
            return "Error: Car with plate " + car.getPlate() + " is not available for the requested days";
        }

        double bookingTotalAmount = calculateBookingTotalAmount(qtyDays, car);

        Booking myBooking = new Booking();

        myBooking.setBookingDate(bookingDate);
        myBooking.setQtyDays(qtyDays);
        myBooking.setTotalAmount(bookingTotalAmount);
        myBooking.setActive(true);
        myBooking.setCarFK(car);
        myBooking.setClientFK(client);

        if(!createBooking(myBooking)) {
            return "Error: could not create booking.";
        }

        if(!updateCarAvailableDays(car, bookingDate, qtyDays)) {
            return "Error: failed to upload car availableDates";
        }

        return "Booking successfully created for car " + car.getPlate() + "!";
    }

    public String validateBookingData (Car car, long bookingDate, int qty, Client client, int year) {

        if (!carRepository.existsById(car.getId())) {
            return "The requested car does not exist in our database.";
        }

        if(!validateBookingDateRange(bookingDate, year, car)) {
            return "The provided bookingDate is invalid";
        }

        if (qty <= 0) {
            return "The provided number of days is invalid.";
        }

        if (!clientRepository.existsById(client.getId())) {
            return "The requested client does not exist in our database.";
        }

        return "All values are valid.";
    }

    public boolean validateBookingDateRange (long bookingDate, int yearToCheck, Car car) {

        LocalDate date = LocalDate.ofEpochDay(bookingDate);
        int year = date.getYear();

        if (year != yearToCheck) {
            return false;
        }

        if (!car.getAvailableDates().containsKey(bookingDate)) {
            return false;
        }

        return true;
    }

    public boolean checkAvailability(Car car, long initialDate, int qty) {

        Map<Long, Boolean> unavailableDates = car.getAvailableDates();

        for (int i = 0; i < qty; i++) {

            if (unavailableDates.containsKey(initialDate) && !unavailableDates.get(initialDate)) {
                System.out.println("Car not available");
                return false;
            }

            initialDate++;
        }

        System.out.println("Car ready to book ;)");
        return true;
    }

    public double calculateBookingTotalAmount (int qtyDays, Car car) {

        double carPrice = car.getPrice();
        double totalPrice = carPrice * qtyDays;

        return totalPrice;
    }

    public boolean createBooking (Booking booking) {

        bookingRepository.save(booking);

        if (bookingRepository.findById(booking.getId()).isEmpty()) {
            return false;
        }

        return true;
    }

    public boolean updateCarAvailableDays(Car car, long bookingDate, int qty) {

        if (carRepository.findById(car.getId()).isEmpty()) {
            return false;
        }

        for (int i = 0; i < qty; i++) {
            car.getAvailableDates().put(bookingDate, false);
            bookingDate++;
        }

        carRepository.save(car);
        return true;
    }
}
