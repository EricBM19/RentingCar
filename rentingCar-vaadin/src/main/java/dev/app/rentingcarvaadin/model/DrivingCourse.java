package dev.app.rentingcarvaadin.model;
import dev.app.rentingcarvaadin.utils.GenerateUuid;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class DrivingCourse {

    @Id
    private String id;
    private String courseName;
    private String courseDescription;
    private String instructor;
    private int durationHours;
    private double price;
    private String category;
    private int maxStudents;
    private boolean isActive;
    private String location;

    @ManyToMany
    @JoinTable (name = "DRIVING_COURSE_CLIENT_JOIN_TABLE",
    joinColumns = @JoinColumn(name = "DRIVING_COURSE_ID"),
    inverseJoinColumns = @JoinColumn(name = "CLIENT_ID"))
    private List<Client> clientFK;

    public DrivingCourse() {
        this.id = "DCO" + GenerateUuid.generateUuid();
    }

    public DrivingCourse(String courseName, String courseDescription, String instructor, int durationHours, double price, String category, int maxStudents, boolean isActive, String location) {

        this.id = "DCO" + GenerateUuid.generateUuid();
        this.courseName = courseName;
        this.courseDescription = courseDescription;
        this.instructor = instructor;
        this.durationHours = durationHours;
        this.price = price;
        this.category = category;
        this.maxStudents = maxStudents;
        this.isActive = isActive;
        this.location = location;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public int getDurationHours() {
        return durationHours;
    }

    public void setDurationHours(int durationHours) {
        this.durationHours = durationHours;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getMaxStudents() {
        return maxStudents;
    }

    public void setMaxStudents(int maxStudents) {
        this.maxStudents = maxStudents;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Client> getClientFK() {
        return clientFK;
    }

    public void setClientFK(List<Client> clientFK) {
        this.clientFK = clientFK;
    }
}
