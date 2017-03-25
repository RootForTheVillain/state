package gov.michigan.model;

import javax.persistence.*;

/**
 * Created by bknop on 3/24/2017.
 */
@Entity
@Table(name="VEHICLE_MODELS")
public class Model {
    @Id
    @Column(name = "MODEL_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //private Integer id;

    private String code;
    private String title;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
