package br.project.rest_spring_boot.integration.controller;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.project.rest_spring_boot.config.TestConfig;
import br.project.rest_spring_boot.integration.container.AbstractIntegrationTest;
import br.project.rest_spring_boot.model.Person;
import br.project.rest_spring_boot.util.PersonMock;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;

@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
@TestMethodOrder(OrderAnnotation.class)
public class PersonControllerIntegrationTest extends AbstractIntegrationTest {
    
    private static RequestSpecification specification;
    private static ObjectMapper mapper;
    private static Person person;

    @BeforeAll
    public static void beforeAll() {
        person = PersonMock.getWithIDNulo();
        mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        specification = new RequestSpecBuilder()
            .setBasePath("/person")
            .setPort(TestConfig.SERVER_PORT)
            .addFilter(new RequestLoggingFilter(LogDetail.ALL))
            .addFilter(new ResponseLoggingFilter(LogDetail.ALL))
            .build();
    }
    
    @Order(1)
    @Test
    public void testIntegrationCreate_WhenScenarioSuccessful_ThenReturnPersonObject() throws JsonProcessingException {
        String jsonString = RestAssured
            .given()
                .spec(specification)
                .contentType(TestConfig.CONTENT_TYPE_JSON)
                .body(mapper.writeValueAsString(person))
            .when()
                .post()
            .then()
                .statusCode(201)
                .extract()
                    .body().asString();

        Person personObject = mapper.readValue(jsonString, Person.class);
        
        Assertions.assertNotNull(personObject);  
        Assertions.assertNotNull(personObject.getId());  
        Assertions.assertEquals(person.getFirstName(), personObject.getFirstName());  
    }
    
}
