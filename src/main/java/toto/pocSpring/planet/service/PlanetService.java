package toto.pocSpring.planet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import toto.pocSpring.planet.entity.Planet;
import toto.pocSpring.planet.repository.PlanetRepository;

import javax.persistence.EntityNotFoundException;
import java.math.BigInteger;
import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlanetService {

    @Autowired
    private PlanetRepository planetRepository;

    public List<Planet> getAllPlanet() {
        return planetRepository.findAll();
    }

    public Planet getPlanetById(int id) {
        return planetRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Planet not found"));
    }

    public List<String> getAllPlanetsName() {
        return planetRepository.findAll().stream()
                .map(Planet::getName)
                .sorted()
                .collect(Collectors.toList());
    }

    public Planet createNewPlanet(Planet planet) {
        Date now = new Date(System.currentTimeMillis());
        planet.setCreatedDate(now);
        planet.setUpdatedDate(now);
        return planetRepository.save(planet);
    }

    public Planet updatePlanet(Planet planet) {
        planet.setUpdatedDate(new Date(System.currentTimeMillis()));
        return planetRepository.save(planet);
    }

    public void deletePlanetById(int id) {
        planetRepository.deleteById(id);
    }

    public List<Planet> executeOrder66(int peopleToExecute) {
        List<Planet> allPlanets = planetRepository.findAll();
        BigInteger _peopleToExecute = BigInteger.valueOf(peopleToExecute);
        Date now = new Date(System.currentTimeMillis());

        // si la population de la planète est supérieure au nombre de personne à exécuter, on soustrait, sinon on met 0 (pour ne pas avoir de population négative)
        allPlanets.stream()
                .filter(item -> item.getPopulation() != null)
                .forEach(item -> {
                    item.setPopulation(item.getPopulation().compareTo(_peopleToExecute) >= 1 ? item.getPopulation().subtract(_peopleToExecute) : BigInteger.ZERO);
                    item.setUpdatedDate(now);
                });

        allPlanets.forEach(item -> planetRepository.save(item));

        return allPlanets;
    }
}
