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

    @OneToOne
    @JoinColumn(name = "MAKE_ID")
    private Make make;

    @OneToOne
    @JoinColumn(name = "MODEL_ID")
    private Model model;

    /*private String vehicle_type;*/
    private String plateNumber;
    private Date plateExpiration;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) { this.id = id; }

    public Make getMake() {
        return this.make;
    }

    public void setMake(Make make) {
        this.make = make;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

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
