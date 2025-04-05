package tn.esprit.yasmineajailia4ds3.repositories;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.yasmineajailia4ds3.entities.Course;
import tn.esprit.yasmineajailia4ds3.entities.Registration;

import java.util.List;

public interface IRegistrationRepository extends CrudRepository<Registration, Long> {
    List<Registration> findByCourse(Course course);

}
