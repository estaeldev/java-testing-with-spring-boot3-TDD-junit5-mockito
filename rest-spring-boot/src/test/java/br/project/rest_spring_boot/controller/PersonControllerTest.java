package br.project.rest_spring_boot.controller;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.project.rest_spring_boot.model.Person;
import br.project.rest_spring_boot.service.PersonService;
import br.project.rest_spring_boot.util.PersonMock;

@WebMvcTest(PersonController.class)
class PersonControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    @MockBean
    private PersonService personService;

    @InjectMocks
    private PersonController personController;

    @Test
    void testCreate_WhenParametersIsOk_ThenReturnPersonObject() throws Exception {
        Person person = PersonMock.getWithIDNulo();
        Mockito.when(this.personService.create(person)).thenAnswer(invocation -> invocation.getArgument(0));

        ResultActions response = this.mockMvc.perform(MockMvcRequestBuilders.post("/person")
            .contentType(MediaType.APPLICATION_JSON_VALUE)
            .content(this.mapper.writeValueAsString(person)));

        response
            .andExpect(MockMvcResultMatchers.status().isCreated())
            .andExpect(MockMvcResultMatchers.jsonPath("$.firstName").value(person.getFirstName()));

    }
    
    @Test
    void testDelete_WhenScenarioSuccessful_ThenReturnVoid() throws Exception {
        Person person = PersonMock.getWithID();
        Mockito.doNothing().when(this.personService).delete(person.getId());

        ResultActions response = this.mockMvc
            .perform(MockMvcRequestBuilders.delete("/person/{id}", person.getId()));

        response
            .andExpect(MockMvcResultMatchers.status().isNoContent());
        
        Mockito.verify(this.personService, Mockito.atLeastOnce()).delete(person.getId());
    }

    @Test
    void testFindAll_WhenScenarioSuccessful_ThenReturnPersonList() throws Exception {
        Mockito.when(this.personService.findAll()).thenReturn(Arrays.asList(PersonMock.getWithID()));
        ResultActions response = this.mockMvc.perform(MockMvcRequestBuilders.get("/person"));

        response
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.size()").value(1));
    }

    @Test
    void testFindById_WhenIDExist_ThenReturnPersonObject() throws Exception {
        Person person = PersonMock.getWithID();
        Mockito.when(this.personService.findById(person.getId())).thenReturn(person);

        ResultActions response = this.mockMvc
            .perform(MockMvcRequestBuilders.get("/person/{id}", person.getId()));

        response
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(MockMvcResultMatchers.jsonPath("$.id").isNotEmpty());
    }

    @Test
    void testUpdate_WhenScenarioSuccessful_ThenReturnUpdatedPerson() throws Exception {
        Person person = PersonMock.getWithID();
        Person personUpdated = PersonMock.getWithID();
        personUpdated.setFirstName("Estael");
        Mockito.when(this.personService.update(person)).thenReturn(personUpdated);

        ResultActions response = this.mockMvc.perform(MockMvcRequestBuilders.put("/person")
            .contentType(MediaType.APPLICATION_JSON_VALUE)
            .content(this.mapper.writeValueAsString(person)));

        response
            .andDo(MockMvcResultHandlers.print())
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(MockMvcResultMatchers.jsonPath("$.firstName").value("Estael"));
    }

}
