package br.project.rest_spring_boot.repository;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import br.project.rest_spring_boot.integration.container.AbstractIntegrationTest;
import br.project.rest_spring_boot.model.Person;
import br.project.rest_spring_boot.util.PersonMock;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
class PersonRepositoryTest extends AbstractIntegrationTest {

    @Autowired
    private PersonRepository personRepository;

    @Test
    void testCreate_WhenSavePerson_ThenReturnSavedPerson() {
        Person personSaved = this.personRepository.save(PersonMock.getWithIDNulo());
        Assertions.assertNotNull(personSaved.getId());
    }   

    @Test
    void testFindAll_ShouldReturnListPerson() {
        this.personRepository.save(PersonMock.getWithIDNulo());
        this.personRepository.save(PersonMock.getWithIDNulo());
        List<Person> personList = this.personRepository.findAll();

        Assertions.assertNotNull(personList);
        Assertions.assertNotNull(personList.get(0).getId());
        Assertions.assertNotNull(personList.get(1).getId());
        Assertions.assertEquals(2, personList.size());

    }   

    @Test
    void testFindById_ShouldReturnPerson() {
        Person personSaved = this.personRepository.save(PersonMock.getWithIDNulo());
        Optional<Person> personOpt = this.personRepository.findById(personSaved.getId());

        Assertions.assertNotNull(personOpt);
        Assertions.assertNotNull(personOpt.get());
        Assertions.assertTrue(personOpt.isPresent());
        Assertions.assertEquals(personSaved.getId(), personOpt.get().getId());
    }

    @Test
    void testFindByEmail_ShouldReturnPerson() {
        Person personSaved = this.personRepository.save(PersonMock.getWithIDNulo());
        Optional<Person> personOpt = this.personRepository.findByEmail(personSaved.getEmail());

        Assertions.assertNotNull(personOpt);
        Assertions.assertNotNull(personOpt.get());
        Assertions.assertTrue(personOpt.isPresent());
        Assertions.assertEquals(personSaved.getEmail(), personOpt.get().getEmail());
    }

    @Test
    void testUpdate_ShouldReturnPerson() {
        Person person = this.personRepository.save(PersonMock.getWithIDNulo());
        person.setLastName("Meireles");
        this.personRepository.save(person);
 
        Assertions.assertNotNull(person);
        Assertions.assertNotNull(person.getId());
        Assertions.assertNotEquals(PersonMock.getWithIDNulo().getLastName(), person.getLastName());
    }

    @Test
    void testDelete_ShouldDeletedPerson() {
        Person personSaved = this.personRepository.save(PersonMock.getWithIDNulo());
        this.personRepository.delete(personSaved);
        List<Person> personList = this.personRepository.findAll();

        Assertions.assertEquals(0, personList.size());
    }

    @Test
    void testFindByJPQL_ShouldReturnPerson() {
        Person personSaved = this.personRepository.save(PersonMock.getWithIDNulo());
        Optional<Person> personOpt = this.personRepository.findByJPQL(personSaved.getFirstName(), personSaved.getLastName());

        Assertions.assertNotNull(personOpt);
        Assertions.assertNotNull(personOpt.get());
        Assertions.assertTrue(personOpt.isPresent());
        Assertions.assertEquals(personSaved.getFirstName(), personOpt.get().getFirstName());
    }

}
