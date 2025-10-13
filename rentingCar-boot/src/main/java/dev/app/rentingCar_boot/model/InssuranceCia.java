package dev.app.rentingCar_boot.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Random;

@Entity
public class InssuranceCia {

    @Id
    private String id;
    private String name;
    private String description;
    private int qtyEmployee;
    private boolean isActive;

    @OneToMany(mappedBy = "inssuranceCia", cascade = CascadeType.ALL)
    private List<Car> cars;

    public String generateFourDigitUuid () {
        Random random = new Random();
        return "INS" + random.nextInt(9000);
    }

    public InssuranceCia () {
        this.id = generateFourDigitUuid();
    }

    public InssuranceCia(String name, String description, int qtyEmployee, boolean isActive) {
        this.id = generateFourDigitUuid();
        this.name = name;
        this.description = description;
        this.qtyEmployee = qtyEmployee;
        this.isActive = isActive;
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

    public int getQtyEmployee() {
        return qtyEmployee;
    }

    public void setQtyEmployee(int qtyEmployee) {
        this.qtyEmployee = qtyEmployee;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    @Override
    public String toString() {
        return "InssuranceCia{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", qtyEmployee=" + qtyEmployee +
                ", isActive=" + isActive +
                '}';
    }
}
