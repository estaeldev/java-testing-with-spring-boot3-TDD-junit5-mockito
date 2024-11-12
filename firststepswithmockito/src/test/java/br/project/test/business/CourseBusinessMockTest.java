package br.project.test.business;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import br.project.test.service.CourseService;

@ExtendWith(MockitoExtension.class)
class CourseBusinessMockTest {

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
    
    @Mock
    private CourseService serviceMock;

    @InjectMocks
    private CourseBusiness courseBusiness;

    @Test
    void testRetrieveCourses_WhenFieldsOk_ThenReturnSuccess() {
        Mockito
            .when(serviceMock.retrieveCourses("leandro"))
            .thenReturn(COURSES);

        List<String> courses = courseBusiness.retrieveCourses("leandro");
        Assertions.assertEquals(4, courses.size());
    }

    @Test
    void testRetrieveCourses_WhenFieldsIsInvalid_ThenReturnEmptyList() {
        Mockito
            .when(serviceMock.retrieveCourses(ArgumentMatchers.contains("Carlos")))
            .thenReturn(List.of());

        List<String> courses = courseBusiness.retrieveCourses("Carlos");
        Assertions.assertEquals(0, courses.size());
    }

    @Test
    void testDeleteCourses_WhenFieldsIsValid_ThenReturnVoid() {
        Mockito.doNothing().when(serviceMock).delete(anyString());

        courseBusiness.deleteCourses("");
        courseBusiness.deleteCourses("");

        Mockito.verify(serviceMock, times(2)).delete("");
    }



}
