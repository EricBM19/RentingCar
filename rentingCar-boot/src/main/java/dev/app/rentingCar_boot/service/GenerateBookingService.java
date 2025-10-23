package dev.app.rentingCar_boot.service;

import dev.app.rentingCar_boot.model.Booking;
import dev.app.rentingCar_boot.model.Car;
import dev.app.rentingCar_boot.model.Client;
import dev.app.rentingCar_boot.repository.BookingRepository;
import dev.app.rentingCar_boot.repository.CarRepository;
import dev.app.rentingCar_boot.repository.ClientRepository;
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

        // 1. Check car, bookingDate, qtyDays and client are valid data.
        // car, check if the car is on our ddbb
        // booking date, if is in the correct format
        // qty days it cannot be 0, negative or decimal
        // client, check if our client exist on our ddbb
        validateBookingData(car,bookingDate,qtyDays,client,year);

        // 2. Call checkAvailability
        checkAvailability(car, bookingDate, qtyDays);

        // 3. Create method to calculate booking totalAmount
        // call a method where we calculate the price for our booking
        // price being, qtyDays * carPrice
        double bookingTotalAmount = calculateBookingTotalAmout(qtyDays, car);

        // 4. Create empty booking
        Booking myBooking = new Booking();

        // 5. Setting all booking values
        myBooking.setBookingDate(bookingDate);
        myBooking.setQtyDays(qtyDays);
        myBooking.setTotalAmount(bookingTotalAmount);
        myBooking.setActive(true);
        myBooking.setCarFK(car);
        myBooking.setClientFK(client);

        // 6. Call method createBooking which saves our booking at the ddbb todo

        // 7. Update car unavailableDays with the booked dates todo
        // create and call a method where we update our car unavailableDays with the booked dates

        // 8. return string with all checked and correct todo

        return "TO DO";
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

        if (!car.getUnavailableDates().containsKey(bookingDate)) {
            return false;
        }

        return true;
    }

    public boolean checkAvailability(Car car, long initialDate, int qty) {

        Map<Long, Boolean> unavailableDates = car.getUnavailableDates();

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

    public double calculateBookingTotalAmout (int qtyDays, Car car) {

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
}
