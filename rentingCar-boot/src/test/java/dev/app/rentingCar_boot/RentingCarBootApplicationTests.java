package dev.app.rentingCar_boot;

import dev.app.rentingCar_boot.model.Car;
import dev.app.rentingCar_boot.repository.CarRepository;
import dev.app.rentingCar_boot.service.CarService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RentingCarBootApplicationTests {

    @Autowired
    CarRepository carRepository;

    @Autowired
    CarService carService;

    @Test
    void contextLoad() {
    }

    @Test
    void testCarRepository () {
        Car car = new Car("ABCD1234", "Toyota", "Crossover", 2015, 100.0);
        carRepository.save(car);
    }
}
