package dev.app.rentingCar_boot.utils;

import dev.app.rentingCar_boot.model.Car;
import dev.app.rentingCar_boot.model.CarExtras;
import dev.app.rentingCar_boot.model.InssuranceCia;
import dev.app.rentingCar_boot.repository.CarExtrasRepository;
import dev.app.rentingCar_boot.repository.CarRepository;
import dev.app.rentingCar_boot.repository.InssuranceCiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class PopulateCar {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private CarExtrasRepository carExtrasRepository;

    @Autowired
    private InssuranceCiaRepository inssuranceCiaRepository;

    public void populateCar(int quantity) {
        List<Car> cars = generateCars(quantity);
        List<CarExtras> carExtras = generateCarExtras(quantity);
        List<InssuranceCia> inssuranceCias = generateInssuranceCia(quantity);

        assignInsuranceToCar(inssuranceCias, cars);
        assignCarToCarExtras(cars,carExtras);
    }

    public List<InssuranceCia> generateInssuranceCia(int quantity) {
        List<InssuranceCia> generatedInssurances = new ArrayList<>();
        Random random = new Random();

        String [] insuranceNames = {"Allianz", "Mapfre", "AXA", "Zurich", "Liberty Seguros", "Generali", "Mutua Madrileña", "Reale Seguros", "Linea Directa", "Balumba"};

        for (int  i =0; i < quantity; i++) {

            String name = insuranceNames[random.nextInt(insuranceNames.length)];
            String description = setInsuranceDescription(name);
            int empluyesNum = 200 + random.nextInt(2000);
            boolean isActive = random.nextBoolean();

            InssuranceCia inssuranceCia = new InssuranceCia(name, description, empluyesNum, isActive);
            generatedInssurances.add(inssuranceCia);
            inssuranceCiaRepository.save(inssuranceCia);
        }
        return generatedInssurances;
    }

    public List<Car> generateCars(int quantity) {
        List<Car> generatedCars = new ArrayList<>();
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

        return generatedCars;
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

    public List<CarExtras> generateCarExtras(int quantity)  {
        List<CarExtras> generatedCarExtras = new ArrayList<>();
        Random random = new Random();

        String [] name = {"Seat covers", "Fire extinguisher", "Warning triangles", "GPS navigation unit", "Jumper cables", "Tire inflator", "Car vacuum cleaner", "Pet seat cover", "Roof storage box"};

        for (int i = 0; i < quantity; i++) {
            String extraName = name[random.nextInt(name.length)];
            String description = setExtraDescription(extraName);
            double dailyPrice = 10.0 + (random.nextDouble()* 50.0);
            boolean available = random.nextBoolean();

            CarExtras carExtras = new CarExtras(extraName, description, dailyPrice, available);
            generatedCarExtras.add(carExtras);
            carExtrasRepository.save(carExtras);
        }
        return generatedCarExtras;
    }

    public String setExtraDescription (String name) {

        String description = "";

        if (name.equals("Seat covers")) {
            description = "Protective covers for car seats.";
        }
        else if (name.equals("Fire extinguisher")) {
            description = "Device to put out fires in emergencies.";
        }
        else if (name.equals("Warning triangles")) {
            description = "Reflective triangles to signal accidents or breakdowns.";
        }
        else if (name.equals("GPS navigation unit")) {
            description = "Device that provides real-time route guidance.";
        }
        else if (name.equals("Jumper cables")) {
            description = "Cables used to start a car with a dead battery.";
        }
        else if (name.equals("Tire inflator")) {
            description = "Portable compressor to inflate tires.";
        }
        else if (name.equals("Car vacuum cleaner")) {
            description = "Small vacuum designed for cleaning car interiors.";
        }
        else if (name.equals("Pet seat cover")) {
            description = "Seat protector to prevent pet stains and damage.";
        }
        else if (name.equals("Roof storage box")) {
            description = "Box mounted on the roof for extra cargo space.";
        }

        return description;
    }

    public String setInsuranceDescription (String name) {

        String description = null;

        if (name.equals("Allianz")) {
            description = "Global company offering car insurance with extensive coverage.";
        }
        else if (name.equals("Mapfre")) {
            description = "Spanish insurer with various policies and roadside assistance.";
        }
        else if (name.equals("AXA")) {
            description = "Multinational providing personalized car insurance services.";
        }
        else if (name.equals("Zurich")) {
            description = "Offers flexible car insurance options with full coverage.";
        }
        else if (name.equals("Liberty Seguros")) {
            description = "European insurer known for fast claims and service.";
        }
        else if (name.equals("Generali")) {
            description = "Italian company with car insurance and extended protection options.";
        }
        else if (name.equals("Mutua Madrileña")) {
            description = "Spanish insurer specializing in vehicle insurance and close support.";
        }
        else if (name.equals("Reale Seguros")) {
            description = "Company offering personalized car insurance with good value.";
        }
        else if (name.equals("Linea Directa")) {
            description = "Known for direct car insurance without intermediaries.";
        }
        else if (name.equals("Balumba")) {
            description = "100% online car insurance with competitive prices and easy management.";
        }

        return description;
    }

    public void assignInsuranceToCar(List<InssuranceCia> inssuranceCias, List<Car> cars) {

        for (Car car : cars) {

            Random random = new Random();
            InssuranceCia inssuranceCia = inssuranceCias.get(random.nextInt(inssuranceCias.size()));

            car.setInssuranceCia(inssuranceCia);

            carRepository.save(car);
        }
    }

    public void assignCarToCarExtras(List<Car> cars, List<CarExtras> carExtrass) {

        for (CarExtras carExtras : carExtrass) {

            Random random = new Random();
            Car car = cars.get(random.nextInt(cars.size()));

            carExtras.setCarFK(car);

            carExtrasRepository.save(carExtras);
        }
    }
}
