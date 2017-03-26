package gov.michigan.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by bknop on 3/12/2017.
 */

@Entity
@Table(name="USERS")
public class User {

    @Id
    @Column(name = "USER_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String firstName;
    private String lastName;
    private String email;
    private String birthDate;
    private String licenseNumber;
    private String streetAddress;
    private String city;
    private String state;
    private String zipCode;
    private String phoneNumber;

    @OneToMany
    @JoinColumn(name = "user_id")
    /*@JoinTable(name="users_vehicles",
        joinColumns = { @JoinColumn(name = "user_id", referencedColumnName = "user_id") },
        inverseJoinColumns = { @JoinColumn(name = "vehicle_id", referencedColumnName = "vehicle_id", unique = true) })*/
    private Set<Vehicle> vehicles = new HashSet<Vehicle>();

    public Set<Vehicle> getVehicles() { return this.vehicles; }

    public void setVehicles(Set<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
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

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
