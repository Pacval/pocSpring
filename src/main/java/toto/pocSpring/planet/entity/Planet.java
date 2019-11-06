package toto.pocSpring.planet.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;
import java.sql.Date;

@Entity
@Table(name = "planet")
@Data
@NoArgsConstructor
public class Planet implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "rotation_period")
    private Integer rotationPeriod;

    @Column(name = "orbital_period")
    private Integer orbitalPeriod;

    @Column(name = "diameter")
    private Integer diameter;

    @Column(name = "climate")
    private String climate;

    @Column(name = "gravity")
    private String gravity;

    @Column(name = "terrain")
    private String terrain;

    @Column(name = "surface_water")
    private String surfaceWater;

    @Column(name = "population")
    private BigInteger population;

    @Column(name = "created_date")
    private Date createdDate;

    @Column(name = "updated_date")
    private Date updatedDate;

    @Column(name = "url")
    private String url;
}

