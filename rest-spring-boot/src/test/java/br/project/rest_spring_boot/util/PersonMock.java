package br.project.rest_spring_boot.util;

import br.project.rest_spring_boot.model.Person;

public abstract class PersonMock {
    
    private PersonMock(){}

    public static Person getWithIDNulo() {
        Person person = new Person();
        person.setId(null);
        person.setFirstName("Leandro");
        person.setLastName("Costa");
        person.setEmail("leandro@erudio.com");
        person.setAddress("Uberlândia");
        person.setGender("Male");
        return person;
    }

    public static Person getWithID() {
        Person person = new Person();
        person.setId(1);
        person.setFirstName("Leandro");
        person.setLastName("Costa");
        person.setEmail("leandro@erudio.com");
        person.setAddress("Uberlândia");
        person.setGender("Male");
        return person;
    }


}
