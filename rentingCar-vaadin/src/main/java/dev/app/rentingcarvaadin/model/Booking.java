package dev.app.rentingcarvaadin.model;

import dev.app.rentingcarvaadin.utils.GenerateUuid;
import jakarta.persistence.*;

@Entity
public class Booking {

    @Id
    private String id;
    private long bookingDate;
    private int qtyDays;
    private double totalAmount;
    private boolean isActive;

    @JoinColumn(name = "CAR_FK")
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Car carFK;

    @JoinColumn(name = "CLIENT_FK")
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Client clientFK;

    public Booking() {
        this.id = "BOOK" + GenerateUuid.generateUuid();
    }

    public Booking(long bookingDate, int qtyDays, double totalAmount, boolean isActive, Car car, Client client) {
        this.id = "BOOK" + GenerateUuid.generateUuid();
        this.bookingDate = bookingDate;
        this.qtyDays = qtyDays;
        this.totalAmount = totalAmount;
        this.isActive = isActive;
        this.carFK = car;
        this.clientFK = client;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(long bookingDate) {
        this.bookingDate = bookingDate;
    }

    public int getQtyDays() {
        return qtyDays;
    }

    public void setQtyDays(int qtyDays) {
        this.qtyDays = qtyDays;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Car getCarFK() {
        return carFK;
    }

    public void setCarFK(Car carFK) {
        this.carFK = carFK;
    }

    public Client getClientFK() {
        return clientFK;
    }

    public void setClientFK(Client clientFK) {
        this.clientFK = clientFK;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id='" + id + '\'' +
                ", bookingDate=" + bookingDate +
                ", qtyDays=" + qtyDays +
                ", totalAmount=" + totalAmount +
                ", isActive=" + isActive +
                ", car=" + carFK +
                ", client=" + clientFK +
                '}';
    }
}
