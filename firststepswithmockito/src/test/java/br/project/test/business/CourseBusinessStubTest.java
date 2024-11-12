package br.project.test.business;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import br.project.test.service.CourseService;
import br.project.test.service.stubs.CourserServiceStub;

class CourseBusinessStubTest {

    @Test
    void testRetrieveCourses_WhenFieldsOk_ThenReturnSuccess() {
        CourseService serviceStub = new CourserServiceStub();
        CourseBusiness courseBusiness = new CourseBusiness(serviceStub);
        List<String> courses = courseBusiness.retrieveCourses("leandro");
        Assertions.assertEquals(4, courses.size());
    }

    @Test
    void testRetrieveCourses_WhenFieldsIsInvalid_ThenReturnEmptyList() {
        CourseService serviceStub = new CourserServiceStub();
        CourseBusiness courseBusiness = new CourseBusiness(serviceStub);
        List<String> courses = courseBusiness.retrieveCourses("");
        Assertions.assertEquals(0, courses.size());
    }


}
