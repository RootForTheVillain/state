package gov.michigan.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by bknop on 3/24/2017.
 */
@Entity
@Table(name="VEHICLES")
public class Vehicle {
    @Id
    @Column(name = "VEHICLE_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /*private String make;
    private String model;
    private String vehicle_type;*/
    private String plateNumber;
    private Date plateExpiration;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) { this.id = id; }

    /*public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }*/

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public Date getPlateExpiration() {
        return plateExpiration;
    }

    public void setPlateExpiration(Date plateExpiration) {
        this.plateExpiration = plateExpiration;
    }
}
