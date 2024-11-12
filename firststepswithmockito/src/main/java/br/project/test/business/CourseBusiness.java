package br.project.test.business;

import java.util.List;

import br.project.test.service.CourseService;

public class CourseBusiness {

    private final CourseService courseService;

    public CourseBusiness(CourseService courseService) {
        this.courseService = courseService;
    }

    public List<String> retrieveCourses(String student) {
        return this.courseService.retrieveCourses(student)
            .stream()
            .filter(course -> course.contains("Spring"))
            .toList();
    }

    public void deleteCourses(String course) {
        this.courseService.delete(course);
    }
    

}
