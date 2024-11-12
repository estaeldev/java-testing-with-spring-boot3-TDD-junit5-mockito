package br.project.test.business;

import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;

import br.project.test.service.CourseService;

class CourseBusinessMockWithBDDTest {

    private static final List<String> COURSES = new ArrayList<>();

    static {
        COURSES.addAll(
            Arrays.asList("REST API's RESTFul do 0 à Azure com ASP.NET Core 5 e Docker",
                "Agile Desmistificado com Scrum, XP, Kanbun e Trello",
                "Spotify Engineering Culture Desmistificado",
                "REST API's RESTFul do 0 à AWS com Spring Boot 3 Java e Docker",
                "Docker do Zero à Maestria - Conteinerização Desmistificada",
                "Docker para Amazon AWS Implante Apps Java e .NET com Travis CI",
                "Microsserviços do 0 com Spring Cloud, Spring Boot e Docker",
                "Arquitetura de Microsserviços do 0 com ASP.NET, .NET 6 e C#",
                "REST API's RESTFul do 0 à AWS com Spring Boot 3 Kotlin e Docker",
                "Kotlin para DEV's Java: Aprenda a Linguagem Padrão do Android",
                "Microsserviços do 0 com Spring Cloud, Kotlin e Docker")
        );
    }
    
    private CourseService serviceMock;
    private CourseBusiness courseBusiness;

    @BeforeEach()
    void setup() {
        serviceMock = mock(CourseService.class);
        courseBusiness = new CourseBusiness(serviceMock);
    }

    @Test
    void testRetrieveCourses_WhenFieldsOk_ThenReturnSuccess() {
        BDDMockito
            .given(serviceMock.retrieveCourses("leandro"))
            .willReturn(COURSES);

        List<String> courses = courseBusiness.retrieveCourses("leandro");
        Assertions.assertEquals(4, courses.size());
    }

    @Test
    void testRetrieveCourses_WhenFieldsIsInvalid_ThenReturnEmptyList() {
        BDDMockito
            .given(serviceMock.retrieveCourses(ArgumentMatchers.contains("Carlos")))
            .willReturn(List.of());

        List<String> courses = courseBusiness.retrieveCourses("Carlos");
        Assertions.assertEquals(0, courses.size());
    }


}
