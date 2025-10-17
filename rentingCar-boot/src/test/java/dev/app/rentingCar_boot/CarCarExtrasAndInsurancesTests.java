package dev.app.rentingCar_boot;

import dev.app.rentingCar_boot.model.Car;
import dev.app.rentingCar_boot.model.CarExtras;
import dev.app.rentingCar_boot.model.InssuranceCia;
import dev.app.rentingCar_boot.repository.CarExtrasRepository;
import dev.app.rentingCar_boot.repository.CarRepository;
import dev.app.rentingCar_boot.repository.InssuranceCiaRepository;
import dev.app.rentingCar_boot.service.CarService;
import dev.app.rentingCar_boot.utils.GenerateUuid;
import dev.app.rentingCar_boot.utils.PopulateCar;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
class CarCarExtrasAndInsurancesTests {

    @Autowired
    CarRepository carRepository;

    @Autowired
    CarService carService;

    @Autowired
    CarExtrasRepository carExtrasRepository;

    @Autowired
    InssuranceCiaRepository inssuranceCiaRepository;

    @Autowired
    PopulateCar populateCar;

    @Test
    void contextLoad() {
    }

    @Test
    void testCarRepository () {
        Car car = new Car("ABCD1234", "Toyota", "Crossover", 2015, 100.0);
        carRepository.save(car);
    }

    @Test
    void testAssignCarExtraToCarAndCarInsurance() {

        //todo
        // create a car extra: myCarExtras
        CarExtras myCarExtras = new CarExtras("GPS", "High precission GPS",50.0, true);
        carExtrasRepository.save(myCarExtras);
        System.out.println("CarExtras -object-: " + carExtrasRepository.findById("1").get());

        System.out.println("CarExtras --from db-: " + myCarExtras);

        // create an insurance cia: myInssuranceCia
        InssuranceCia myInssuranceCia = new InssuranceCia();
        myInssuranceCia.setId("1");
        myInssuranceCia.setName("Alliance");
        myInssuranceCia.setActive(true);
        myInssuranceCia.setQtyEmployee(1000);
        inssuranceCiaRepository.save(myInssuranceCia);
        System.out.println("InssuranceCia -object-: " + inssuranceCiaRepository.findById("1").get());

        // fetch a car: id="2189"
        Optional<Car> myOptCar = carService.findCarById("2189");
        System.out.println("Car: " + myOptCar.get());

        // assign to many side: carExtras to car
        // save carExtras
        myCarExtras.setCarFK(myOptCar.get());
        carExtrasRepository.save(myCarExtras);

        // assign to many side: car to insurance
        myOptCar.get().setInssuranceCia(myInssuranceCia);

        // save car
        carRepository.save(myOptCar.get());
    }

    @Test
    void testPopulateCarMethods() {
        populateCar.populateCar(10);
    }
}
