package tn.esprit.yasmineajailia4ds3.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.yasmineajailia4ds3.entities.Course;
import tn.esprit.yasmineajailia4ds3.entities.Registration;
import tn.esprit.yasmineajailia4ds3.entities.Skier;
import tn.esprit.yasmineajailia4ds3.entities.TypeCourse;
import tn.esprit.yasmineajailia4ds3.repositories.ICourseRepository;
import tn.esprit.yasmineajailia4ds3.repositories.IRegistrationRepository;
import tn.esprit.yasmineajailia4ds3.repositories.ISkierRepository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@AllArgsConstructor
public class RegistrationServicesImpl implements IRegistrationServices {
    private IRegistrationRepository registrationRepository;
    private ISkierRepository skierRepository;
    private ICourseRepository courseRepository;

    @Override
    public Registration addRegistration(Registration registration) {
        return registrationRepository.save(registration);
    }

    @Override
    public Registration updateRegistration(Registration registration) {
        return registrationRepository.save(registration);
    }

    @Override
    public Registration retrieveRegistration(Long id) {
        return registrationRepository.findById(id).orElse(null);
    }

    @Override
    public void removeRegistration(Long id) {
        registrationRepository.deleteById(id);
    }

    @Override
    public List<Registration> retrieveAll() {
        Iterable<Registration> registrations = registrationRepository.findAll();
        return StreamSupport.stream(registrations.spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public Registration addRegistrationAndAssignToSkier(Registration registration, Long numSkieur) {
        Skier skier = skierRepository.findById(numSkieur).orElse(null);
        if (skier != null) {
            registration.setSkier(skier);
            return registrationRepository.save(registration);
        }
        return null;
    }

    @Override
    public Registration addRegistrationAndAssignToSkierAndCourse(Registration registration, Long numSkier, Long numCourse) {
        Skier skier = skierRepository.findById(numSkier).orElseThrow(() -> new RuntimeException("Skier not found"));
        Course course = courseRepository.findById(numCourse).orElseThrow(() -> new RuntimeException("Course not found"));

        // Check the number of skiers in the course
        List<Registration> registrations = registrationRepository.findByCourse(course);
        if ((course.getTypeCourse() == TypeCourse.COLLECTIVE_CHILDREN || course.getTypeCourse() == TypeCourse.COLLECTIVE_ADULT) && registrations.size() >= 6) {
            throw new RuntimeException("The number of skiers per course must not exceed 6 for collective courses");
        }

        // Verify the skier's age
        if (course.getTypeCourse() == TypeCourse.COLLECTIVE_CHILDREN && skier.getAge() > 12) {
            throw new RuntimeException("Skier's age must be 12 or below for collective children courses");
        }

        registration.setSkier(skier);
        registration.setCourse(course);
        return registrationRepository.save(registration);
    }


}