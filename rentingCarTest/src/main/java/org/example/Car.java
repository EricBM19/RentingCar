package org.example;

public class Car {

    private String id;
    private String plate;
    private String brand;
    private String model;
    private int year;
    private double price;

    public Car(String id, String plate, String brand, String model, int year, double price) {
        this.id = id;
        this.plate = plate;
        this.brand = brand;
        this.model = model;
        this.year = year;
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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int carAge() {
        return 2025 - this.year;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id='" + id + '\'' +
                ", plate='" + plate + '\'' +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", price=" + price +
                '}';
    }
}
