package br.project.test.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.project.test.model.Person;

class PersonServiceTest {

    private PersonService service;
    private Person person;
    
    @BeforeEach
    void setup() {
        this.service = new PersonServiceImpl();
        this.person = new Person(
            "Keith", 
            "Moon", 
            "Wembley", 
            "Male", 
            "kmoon@erudio.com.br"
        );
    }
    
    @Test
    void testCreatePerson_WhenSuccess_ThenReturnPersonObject() {
        Person personCreated = service.createPerson(person);
        Assertions.assertNotNull(personCreated);
        Assertions.assertNotNull(personCreated.getId());
    }

    @Test
    void testCreatePerson_WhenIDIsNotNull_ThenReturnException() {
        this.person.setId(1);
        Assertions.assertEquals("ID is not null", 
            Assertions.assertThrows(IllegalArgumentException.class, 
            () -> service.createPerson(person)).getMessage());
    }

    @Test
    void testCreatePerson_WhenSuccess_ShouldContainsValidFieldsInPersonObject() {
        Person personCreated = service.createPerson(person);
        Assertions.assertNotNull(personCreated);
        Assertions.assertEquals(person.getFirstName(), personCreated.getFirstName());
        Assertions.assertEquals(person.getLastName(), personCreated.getLastName());
        Assertions.assertEquals(person.getAddress(), personCreated.getAddress());
        Assertions.assertEquals(person.getGender(), personCreated.getGender());
        Assertions.assertEquals(person.getEmail(), personCreated.getEmail());
    }

}
