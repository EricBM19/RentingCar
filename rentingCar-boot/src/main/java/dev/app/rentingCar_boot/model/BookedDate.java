package dev.app.rentingCar_boot.model;

import jakarta.persistence.Embeddable;

@Embeddable
public class BookedDate {

    private int initDate;
    private int endDate;

    public BookedDate() {
    }

    public BookedDate(int initDate, int endDate) {
        this.initDate = initDate;
        this.endDate = endDate;
    }

    public int getInitDate() {
        return initDate;
    }

    public void setInitDate(int initDate) {
        this.initDate = initDate;
    }

    public int getEndDate() {
        return endDate;
    }

    public void setEndDate(int endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "BookedDate{" +
                "initDate=" + initDate +
                ", endDate=" + endDate +
                '}';
    }
}
