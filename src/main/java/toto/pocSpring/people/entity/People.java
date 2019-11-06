package toto.pocSpring.people.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import toto.pocSpring.planet.entity.Planet;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "people")
@Data
@NoArgsConstructor
public class People implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "height")
    private Long height;

    @Column(name = "mass")
    private Float mass;

    @Column(name = "hair_color")
    private String hairColor;

    @Column(name = "skin_color")
    private String skinColor;

    @Column(name = "eye_color")
    private String eyeColor;

    @Column(name = "birth_year")
    private String birthYear;

    @ManyToOne
    private Planet planet;

    @Column(name = "gender")
    private String gender;

    @Column(name = "created_date")
    private Date createdDate;

    @Column(name = "updated_date")
    private Date updatedDate;

    @Column(name = "url")
    private String url;
}
