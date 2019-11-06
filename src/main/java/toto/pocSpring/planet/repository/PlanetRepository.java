package toto.pocSpring.planet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import toto.pocSpring.planet.entity.Planet;

public interface PlanetRepository extends JpaRepository<Planet, Integer> {
}
