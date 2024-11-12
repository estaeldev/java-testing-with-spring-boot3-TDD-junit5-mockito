package br.project.rest_spring_boot.service;

import java.util.List;

import br.project.rest_spring_boot.model.Person;

public interface PersonService {
    Person findById(Integer id);
    List<Person> findAll();
    Person create(Person person);
    Person update(Person person);
    void delete(Integer id);
}
