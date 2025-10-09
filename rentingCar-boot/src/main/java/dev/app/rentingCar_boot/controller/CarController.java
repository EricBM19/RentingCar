package dev.app.rentingCar_boot.controller;

import dev.app.rentingCar_boot.model.Car;
import dev.app.rentingCar_boot.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
public class CarController {

    @Autowired
    CarRepository carRepository;

    @GetMapping("/cars-nocss")
    public String listCarsNoCss(Model model) {
        model.addAttribute("cars", carRepository.findAll());
        System.out.println("Cars (controller/cars-nocss): " + carRepository.findAll());
        return "cars-nocss";
    }

    @GetMapping("/cars")
    public String listCars(Model model) {
        model.addAttribute("cars", carRepository.findAll());
        System.out.println("Cars (controller/cars): " + carRepository.findAll());
        return "cars";
    }

    @GetMapping("/cars/generate")
    public String generateCars(@RequestParam int quantity) {
        List <Car> generatedCars = new ArrayList<>();
        Random random = new Random();

        String [] brands = {"Toyota", "Honda", "Ford", "Chevrolet", "Nissan", "BMW", "Mercedes-Benz", "Audi", "Volkswagen", "Hyundai"};
        String [] models = {"Sedan", "SUV", "Hatchback", "Convertible", "Coupe", "Wagon", "Pickup Truck", "Minivan", "Crossover", "Roadster"};

        for (int i = 0; i < quantity; i++) {
            String brand = brands[random.nextInt(brands.length)];
            String model = models[random.nextInt(models.length)];
            String plate = generateRandomPlate(random);
            int year = random.nextInt(2000, 2024);
            double price = 50.0 + (random.nextDouble()* 450.0);

            Car car = new Car(brand, model, plate, year, price);
            generatedCars.add(car);
            carRepository.save(car);
        }

        return "cars";
    }

    private String generateRandomPlate(Random random) {
        StringBuilder plate = new StringBuilder();

        for (int i = 0; i < 3; i++) {
            plate.append((char) ('A' + random.nextInt(26)));
        }
        for (int i = 0; i < 3; i++) {
            plate.append(random.nextInt(10));
        }
        return plate.toString();
    }
}
