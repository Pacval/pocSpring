package toto.pocSpring.people.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import toto.pocSpring.people.entity.People;

public interface PeopleRepository extends JpaRepository<People, Long> {
}
