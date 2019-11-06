package toto.pocSpring.people.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import toto.pocSpring.people.entity.People;
import toto.pocSpring.people.service.PeopleService;

import java.util.List;

/**
 * Controller des objets "personnage"
 */
@RestController
@RequestMapping("/people")
public class PeopleController {

    @Autowired
    private PeopleService peopleService;

    /**
     * @return tous les objets personnages en base
     */
    @RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<People> getAll() {
        return peopleService.getAllPeople();
    }

    /**
     * @param id id de la personnage
     * @return retourne l'objet personnage correspondant à l'id passé en paramètre
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public People getById(@PathVariable("id") long id) {
        return peopleService.getPeopleById(id);
    }
}
