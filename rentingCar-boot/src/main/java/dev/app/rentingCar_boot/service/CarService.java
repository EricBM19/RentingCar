package dev.app.rentingCar_boot.service;

import dev.app.rentingCar_boot.model.Car;
import dev.app.rentingCar_boot.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

        return null;
    }

    public void deleteCarById(String id) {

        carRepository.deleteById(id);

        Optional<Car> foundCar = carRepository.findById(id);

        if (foundCar.isEmpty()) System.out.println("Car not found");
        else System.out.println("Car found: " + foundCar);
    }
}
