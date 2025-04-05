package tn.esprit.yasmineajailia4ds3.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.yasmineajailia4ds3.entities.Course;
import tn.esprit.yasmineajailia4ds3.entities.Registration;
import tn.esprit.yasmineajailia4ds3.repositories.ICourseRepository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
@Service
@AllArgsConstructor
public class CourseServicesImpl implements ICourseServices{
    private ICourseRepository courseRepository;

    @Override
    public Course addCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Course updateCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Course retrieveCourse(Long id) {
        return courseRepository.findById(id).orElse(null);
    }

    @Override
    public void removeCourse(Long id) {
        courseRepository.deleteById(id);
    }

    @Override
    public List<Course> retrieveAll() {
        Iterable<Course> courses = courseRepository.findAll();
        return StreamSupport.stream(courses.spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public Registration assignRegistrationToCourse(Long numRegistration, Long numCourse) {
        Registration registration = registrationRepository.findById(numRegistration).orElse(null);
        Course course = courseRepository.findById(numCourse).orElse(null);
        if (registration != null && course != null) {
            registration.setCourse(course);
            return registrationRepository.save(registration);
        }
        return null;
    }
}
