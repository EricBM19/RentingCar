package dev.app.rentingcarvaadin.controller;

import com.vaadin.flow.server.auth.AnonymousAllowed;
import com.vaadin.hilla.Endpoint;
import dev.app.rentingcarvaadin.model.Car;
import dev.app.rentingcarvaadin.model.Client;
import dev.app.rentingcarvaadin.repository.CarRepository;
import dev.app.rentingcarvaadin.repository.ClientRepository;
import dev.app.rentingcarvaadin.service.GenerateBookingService;
import org.springframework.beans.factory.annotation.Autowired;

@Endpoint
@AnonymousAllowed
public class GenerateBookingEndpoint {

    @Autowired
    private GenerateBookingService generateBookingService;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private CarRepository carRepository;

    public String generateBooking(String clientId, String carId, int bookingDate, int qtyDays) {
        try {
            Client client = clientRepository.findById(clientId)
                    .orElseThrow(() -> new RuntimeException("Client not found with ID: " + clientId));

            Car car = carRepository.findById(carId)
                    .orElseThrow(() -> new RuntimeException("Car not found with ID: " + carId));

            return generateBookingService.generateBooking(car, bookingDate, qtyDays, client,2026);
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }
}