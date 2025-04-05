package tn.esprit.yasmineajailia4ds3.services;

import tn.esprit.yasmineajailia4ds3.entities.Course;
import tn.esprit.yasmineajailia4ds3.entities.Registration;

import java.util.List;

public interface ICourseServices {
    Course addCourse(Course course);
    Course updateCourse(Course course);
    Course retrieveCourse(Long id);
    void removeCourse(Long id);
    List<Course> retrieveAll();
    Registration assignRegistrationToCourse(Long numRegistration, Long numCourse);

}
