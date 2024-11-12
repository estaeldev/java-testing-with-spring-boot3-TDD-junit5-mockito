package br.project.rest_spring_boot.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import br.project.rest_spring_boot.model.Person;
import br.project.rest_spring_boot.repository.PersonRepository;
import br.project.rest_spring_boot.service.impl.PersonServiceImpl;
import br.project.rest_spring_boot.util.PersonMock;

@ExtendWith(MockitoExtension.class)
class PersonServiceImplTest {

    @Mock
    private PersonRepository personRepository;

    @InjectMocks
    private PersonServiceImpl personService;

    @Test
    void testCreate_WhenIDNotExist_ThenReturnCreatePerson() {
        Person person = PersonMock.getWithIDNulo();
        Mockito.when(personRepository.save(person)).thenReturn(PersonMock.getWithID());

        Person personCreated = this.personService.create(person);
        Assertions.assertNotNull(personCreated);
        Assertions.assertNotNull(personCreated.getId());

        Mockito.verify(personRepository, Mockito.times(1)).save(person);
    }

    @Test
    void testCreate_WhenIDExist_ThenReturnException() {
        Person person = PersonMock.getWithID();

        Assertions.assertThrows(IllegalArgumentException.class, 
            () -> this.personService.create(person));

        Mockito.verify(personRepository, Mockito.never()).save(person);
    }

    @Test
    void testDelete_WhenIDExist_ThenReturnVoidAndDeleted() {
        Person person = PersonMock.getWithID();
        Mockito.when(this.personRepository.findById(person.getId())).thenReturn(Optional.of(person));
        Mockito.doNothing().when(this.personRepository).deleteById(person.getId());
        
        Assertions.assertDoesNotThrow(() -> this.personService.delete(person.getId()));

        Mockito.verify(personRepository, Mockito.atLeastOnce()).deleteById(person.getId());
    }

    @Test
    void testDelete_WhenIDNoExist_ThenReturnException() {
        Person person = PersonMock.getWithID();
        Mockito.when(this.personRepository.findById(person.getId())).thenReturn(Optional.empty());
        
        Assertions.assertThrows(IllegalArgumentException.class, 
            () -> this.personService.delete(person.getId()));

        Mockito.verify(personRepository, Mockito.never()).deleteById(person.getId());
    }

    @Test
    void testFindAll_WhenExistElements_ThenReturnFullPersonList() {
        Person person = PersonMock.getWithID();
        Mockito.when(this.personRepository.findAll()).thenReturn(Arrays.asList(person));

        List<Person> personList = this.personService.findAll();

        Assertions.assertNotNull(personList);
        Assertions.assertEquals(1, personList.size());
        Assertions.assertEquals(person, personList.get(0));
        Mockito.verify(personRepository, Mockito.atLeastOnce()).findAll();
    }

    @Test
    void testFindAll_WhenNoExistElements_ThenReturnEmptyPersonList() {
        Mockito.when(this.personRepository.findAll()).thenReturn(List.of());

        List<Person> personList = this.personService.findAll();

        Assertions.assertTrue(personList.isEmpty());
        Assertions.assertEquals(0, personList.size());
        Mockito.verify(personRepository, Mockito.atLeastOnce()).findAll();
    }

    @Test
    void testFindById_WhenIDExist_ThenReturnPersonObject() {
        Mockito.when(this.personRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(PersonMock.getWithID()));

        Person person = this.personService.findById(Mockito.anyInt());

        Assertions.assertNotNull(person);
        Assertions.assertNotNull(person.getId());
        Mockito.verify(this.personRepository, Mockito.atLeastOnce()).findById(Mockito.anyInt());
    }

    @Test
    void testFindById_WhenIDNoExist_ThenReturnException() {
        Mockito.when(this.personRepository.findById(Mockito.anyInt())).thenReturn(Optional.empty());

        Assertions.assertEquals("ID is not found", 
            Assertions.assertThrows(IllegalArgumentException.class, 
            () -> this.personService.findById(Mockito.anyInt())).getMessage());

        Mockito.verify(this.personRepository, Mockito.atLeastOnce()).findById(Mockito.anyInt());
    }

    @Test
    void testUpdate_WhenIDExist_ThenReturnUpdatedPerson() {
        Person person = PersonMock.getWithID();
        Mockito.when(this.personRepository.save(person)).thenReturn(person);

        Person personUpdated = this.personService.update(person);

        Assertions.assertNotNull(personUpdated);
        Assertions.assertNotNull(personUpdated.getId());
        Mockito.verify(this.personRepository, Mockito.atLeastOnce()).save(person);
    }

    @Test
    void testUpdate_WhenIDNoExist_ThenReturnException() {
        Person person = PersonMock.getWithIDNulo();

        Assertions.assertThrows(IllegalArgumentException.class, 
            () -> this.personService.update(person));

        Mockito.verify(this.personRepository, Mockito.never()).save(person);
    }

}
