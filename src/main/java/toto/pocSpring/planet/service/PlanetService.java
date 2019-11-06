package toto.pocSpring.planet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import toto.pocSpring.planet.entity.Planet;
import toto.pocSpring.planet.repository.PlanetRepository;

import java.sql.Date;
import java.util.List;

@Service
public class PlanetService {

    @Autowired
    private PlanetRepository planetRepository;

    public List<Planet> getAllPlanet() {
        return planetRepository.findAll();
    }

    public Planet getPlanetById(int id) {
        return planetRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Planet not found"));
    }

    public Planet createNewPlanet(Planet planet) {
        Date now = new Date(System.currentTimeMillis());
        planet.setCreatedDate(now);
        planet.setUpdatedDate(now);
        return planetRepository.save(planet);
    }

    public void deletePlanetById(int id) {
        planetRepository.deleteById(id);
    }
}
