package toto.pocSpring.planet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import toto.pocSpring.planet.entity.Planet;
import toto.pocSpring.planet.service.PlanetService;

import javax.websocket.server.PathParam;
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
     * @return tous les noms de planètes par ordre alphabétique
     */
    @RequestMapping(value = "/names", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<String> getAllPlanetsName() {
        return planetService.getAllPlanetsName();
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
     * Met à jour une planète en base
     *
     * @param planet objet planète à mettre à jour
     * @return l'objet planète mis à jour
     */
    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public Planet updatePlanet(@RequestBody Planet planet) {
        return planetService.updatePlanet(planet);
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

    /**
     * Execute l'ordre 66 : éxecute un nombre de personne sur chaque planète
     *
     * @param nbPeople nombre de personne touchées par l'ordre 66 sur chaque planète
     */
    @RequestMapping(value = "/order66", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Planet> executeOrder66(@PathParam("nbPeople") int nbPeople) {
        return planetService.executeOrder66(nbPeople);
    }
}
