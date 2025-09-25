package org.example;

import java.util.List;

public class DataStore
{
    private String id;
    private String label;
    private static List<Car> cars;
    private static List<Client> clients;
    private static List<Booking> bookings;
    private boolean isActive;
    private long creationDate;
    private long lastModification;

    public DataStore()
    {

    }

    public DataStore(String id, String label, List<Car> cars, List<Client> clients, List<Booking> bookings, boolean isActive, long creationDate, long lastModification)
    {
        this.id = id;
        this.label = label;
        this.cars = cars;
        this.clients = clients;
        this.bookings = bookings;
        this.isActive = true;
        this.creationDate = creationDate;
        this.lastModification = lastModification;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<Client> getClients() {
        return clients;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public long getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(long creationDate) {
        this.creationDate = creationDate;
    }

    public long getLastModification() {
        return lastModification;
    }

    public void setLastModification(long lastModification) {
        this.lastModification = lastModification;
    }
}
