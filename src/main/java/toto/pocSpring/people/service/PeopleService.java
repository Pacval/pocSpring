package toto.pocSpring.people.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import toto.pocSpring.people.entity.People;
import toto.pocSpring.people.repository.PeopleRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class PeopleService {

    @Autowired
    private PeopleRepository peopleRepository;

    public List<People> getAllPeople() {
        return peopleRepository.findAll();
    }

    public People getPeopleById(Long id) {
        return peopleRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("People not found"));
    }
}
