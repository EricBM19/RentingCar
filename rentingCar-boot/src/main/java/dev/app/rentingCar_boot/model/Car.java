package dev.app.rentingCar_boot.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.app.rentingCar_boot.utils.GenerateUnavailableDateHashMap;
import dev.app.rentingCar_boot.utils.GenerateUuid;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
public class Car {

    @Id
    private String id;
    private String plate;
    private String brand;
    private String model;
    private int carYear;
    private double price;

    @OneToMany (mappedBy = "carFK", cascade = CascadeType.ALL)
    private List<CarExtras> carExtras = new ArrayList<>();

    @JsonIgnore
    @ManyToOne (cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "INSURANCE_CIA_FK")
    private InssuranceCia inssuranceCia;

    @JsonIgnore
    @OneToMany(mappedBy = "carFK", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Booking> bookings = new ArrayList<>();

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "car_available_dates", joinColumns = @JoinColumn(name = "car_id"))
    @MapKeyColumn(name = "date_key")
    @Column(name = "is_available")
    private Map<Integer, Boolean> unavailableDates = new HashMap<Integer, Boolean>();

    public Car() {
        this.id = "CR" + GenerateUuid.generateUuid();
    }

    public Car(String plate, String brand, String model, int carYear, double price) {
        this.id = "CR" + GenerateUuid.generateUuid();
        this.plate = plate;
        this.brand = brand;
        this.model = model;
        this.carYear = carYear;
        this.price = price;
        this.unavailableDates = GenerateUnavailableDateHashMap.generateHashMap();
    }

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

    public List<CarExtras> getCarExtras() {
        return carExtras;
    }

    public void setCarExtras(List<CarExtras> carExtras) {
        this.carExtras = carExtras;
    }

    public InssuranceCia getInssuranceCia() {
        return inssuranceCia;
    }

    public void setInssuranceCia(InssuranceCia inssuranceCia) {
        this.inssuranceCia = inssuranceCia;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    public Map<Integer, Boolean> getUnavailableDates() {
        return unavailableDates;
    }

    public void setUnavailableDates(Map<Integer, Boolean> unavailableDates) {
        this.unavailableDates = unavailableDates;
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