package dev.app.rentingcarvaadin.model;
import dev.app.rentingcarvaadin.utils.GenerateUuid;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Client {

    @Id
    private String id;
    private String name;
    private String lastName;
    private String email;
    private boolean premium;
    private int age;
    private String password;

    @ElementCollection (fetch = FetchType.EAGER)
    @CollectionTable(name = "CLIENT_ADDRESSES", joinColumns = @JoinColumn(name = "CLIENT_FK"))
    @Column(name = "ADDRESS")
    private List<String> addresses;

    public Client() {
        this.id = "CLI" + GenerateUuid.generateUuid();
    }

    public Client(String name, String lastName, String email, boolean premium, int age, String password) {
        this.id = "CLI" + GenerateUuid.generateUuid();
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.premium = premium;
        this.age = age;
        this.password = password;
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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isPremium() {
        return premium;
    }

    public void setPremium(boolean premium) {
        this.premium = premium;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<String> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<String> addresses) {
        this.addresses = addresses;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", premium=" + premium +
                ", age=" + age +
                ", password='" + password + '\'' +
                ", addresses=" + addresses +
                '}';
    }
}
