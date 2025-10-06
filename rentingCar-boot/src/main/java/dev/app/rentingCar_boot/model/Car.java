package dev.app.rentingCar_boot.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Car {
    @Id
    private String id;
    private String plate;
    private String brand;
    private String model;
    private int carYear;
    private double price;

    public Car(String id, String plate, String brand, String model, int carYear, double price) {
        this.id = id;
        this.plate = plate;
        this.brand = brand;
        this.model = model;
        this.carYear = carYear;
        this.price = price;
    }

    public Car() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getCarYear() {
        return carYear;
    }

    public void setCarYear(int carYear) {
        this.carYear = carYear;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int carAge() {
        return 2025 - this.carYear;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id='" + id + '\'' +
                ", plate='" + plate + '\'' +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", year=" + carYear +
                ", price=" + price +
                '}';
    }
}
