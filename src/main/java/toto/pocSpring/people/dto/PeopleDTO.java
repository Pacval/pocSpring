package toto.pocSpring.people.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PeopleDTO {

    private Long id;
    private String name;
    private Long height;
    private Float mass;
    private String hairColor;
    private String skinColor;
    private String eyeColor;
    private String birthYear;
    private String gender;
    private Date createdDate;
    private Date updatedDate;
    private String url;
}