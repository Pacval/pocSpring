package toto.pocSpring.planet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import toto.pocSpring.planet.entity.Planet;
import toto.pocSpring.planet.service.PlanetService;

import java.util.List;

/**
 * Controller des objets "planètes"
 */
@RestController
@RequestMapping("/planet")
public class PlanetController {

    @Autowired
    private PlanetService planetService;

    /**
     * @return tous les objets planètes en base
     */
    @RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Planet> getAll() {
        return planetService.getAllPlanet();
    }

    /**
     * @param id id de la planète
     * @return retourne l'objet planète correspondant à l'id passé en paramètre
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Planet getById(@PathVariable("id") int id) {
        return planetService.getPlanetById(id);
    }

    /**
     * Enregistre une nouvelle planète en base
     *
     * @param planet objet planète à enregistrer
     * @return l'objet planète créé
     */
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Planet createNewPlanet(@RequestBody Planet planet) {
        return planetService.createNewPlanet(planet);
    }

    /**
     * Supprime un objet planète de la base
     *
     * @param id id de la planète à supprimer
     * @return l'objet planète supprimé
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Planet deletePlanet(@PathVariable("id") int id) {
        Planet planet = planetService.getPlanetById(id);

        // si l'entrée n'existe pas en base la fonction du dessus pète une exception
        planetService.deletePlanetById(id);
        return planet;
    }
}
