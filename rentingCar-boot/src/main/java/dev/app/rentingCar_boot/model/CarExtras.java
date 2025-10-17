package dev.app.rentingCar_boot.model;

import dev.app.rentingCar_boot.utils.GenerateUuid;
import jakarta.persistence.*;

@Entity
public class CarExtras {

    @Id
    private String id;
    private String name;
    private String description;
    private double dailyPrice;
    private boolean available;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CAR_FK")
    private Car carFK;

    public CarExtras(String name, String description, double dailyPrice, boolean available) {
        this.id = "CE" + GenerateUuid.generateUuid();
        this.name = name;
        this.description = description;
        this.dailyPrice = dailyPrice;
        this.available = available;
    }

    public CarExtras() {
        this.id = "CE" + GenerateUuid.generateUuid();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getDailyPrice() {
        return dailyPrice;
    }

    public void setDailyPrice(double dailyPrice) {
        this.dailyPrice = dailyPrice;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

//    public String getCategory() {
//        return category;
//    }
//
//    public void setCategory(String category) {
//        this.category = category;
//    }

    public Car getCarFK() {
        return carFK;
    }

    public void setCarFK(Car carFK) {
        this.carFK = carFK;
    }

    @Override
    public String toString() {
        return "CarExtras{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", dailyPrice=" + dailyPrice +
                ", available=" + available +
                '}';
    }
}
