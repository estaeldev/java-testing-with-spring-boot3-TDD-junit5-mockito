package br.project.test.service;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

import br.project.test.model.Person;

public class PersonServiceImpl implements PersonService {

    @Override
    public Person createPerson(Person person) {
        if(Objects.nonNull(person.getId())) {
            throw new IllegalArgumentException("ID is not null");
        }
        person.setId(new AtomicInteger().incrementAndGet());
        return person;
    }
    
}
