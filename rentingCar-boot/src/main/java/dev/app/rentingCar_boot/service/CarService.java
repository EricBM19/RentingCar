package dev.app.rentingCar_boot.service;

import dev.app.rentingCar_boot.model.Car;
import dev.app.rentingCar_boot.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CarService {

    //let's implement all CRUD operations here

    @Autowired
    CarRepository carRepository;

    public Iterable<Car> findAll() {

        Iterable<Car> foundCars = new ArrayList<>();
        foundCars = carRepository.findAll();
        return foundCars;
    }

    public Optional findCarById(String id) {

        Optional<Car> foundCar = carRepository.findById(id);

        if (foundCar.isEmpty()) System.out.println("Car not found");
        else System.out.println("Car found: " + foundCar);

        return foundCar;
    }

    public void deleteCarById(String id) {

        carRepository.deleteById(id);

        Optional<Car> foundCar = carRepository.findById(id);

        if (foundCar.isEmpty()) System.out.println("Car not found");
        else System.out.println("Car found: " + foundCar);
    }

    public boolean checkAvailability(Car car, int initialDate, int finalDate) {

        Map<Integer, Boolean> unavailableDates = car.getUnavailableDates();

        for (int i = initialDate; i <= finalDate; i= i+86400) {

            if (!unavailableDates.get(i)) {
                System.out.println("Car not available");
                return false;
            }
        }

        System.out.println("Car ready to book :)");
        return true;
    }
}
