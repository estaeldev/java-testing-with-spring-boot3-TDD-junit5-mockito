package br.project.test.service;

import java.util.List;

public interface CourseService {
    List<String> retrieveCourses(String student);
    List<String> doSomething(String student);
    void delete(String course);
}
