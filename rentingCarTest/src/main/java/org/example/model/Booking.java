package org.example.model;

public class Booking
{
    private String id;
    private Car car;
    private int days;
    private double price;
    private boolean isActive;

    public Booking(String id, Car car, int days) {
        this.id = id;
        this.car = car;
        this.days = days;
        this.price = car.getPrice() * days;
        this.isActive = true;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id='" + id + '\'' +
                ", car=" + car +
                ", days=" + days +
                ", price=" + price +
                ", isActive=" + isActive +
                '}';
    }
}
