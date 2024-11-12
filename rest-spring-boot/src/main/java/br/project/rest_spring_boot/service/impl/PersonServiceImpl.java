package br.project.rest_spring_boot.service.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import br.project.rest_spring_boot.model.Person;
import br.project.rest_spring_boot.repository.PersonRepository;
import br.project.rest_spring_boot.service.PersonService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final Logger logger = Logger.getLogger(PersonServiceImpl.class.getName());
    private final PersonRepository personRepository;

    @Override
    public Person findById(Integer id) {
        logger.info("Finding one person!");
        Optional<Person> personOpt = this.personRepository.findById(id);
        return personOpt.orElseThrow(() -> new IllegalArgumentException("ID is not found"));
    }

    @Override
    public List<Person> findAll() {
        logger.info("Finding all people!");
        return this.personRepository.findAll();
    }

    @Override
    public Person create(Person person) {
        logger.info("Creating one person!");
        if(Objects.nonNull(person.getId())) {
            throw new IllegalArgumentException("ID should is null");
        }
        return this.personRepository.save(person);
    }

    @Override
    public Person update(Person person) {
        logger.info("Updating one person!");
        if(Objects.isNull(person.getId())) {
            throw new IllegalArgumentException("ID should not null");
        }
        return this.personRepository.save(person);
    }
    
    @Override
    public void delete(Integer id) {
        logger.info("deleting one person!");
        if(this.personRepository.findById(id).isEmpty()) {
            throw new IllegalArgumentException("ID is not found");
        }
        this.personRepository.deleteById(id);
    }

    
}
