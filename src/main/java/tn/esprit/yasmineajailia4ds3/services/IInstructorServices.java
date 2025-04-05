package tn.esprit.yasmineajailia4ds3.services;

import tn.esprit.yasmineajailia4ds3.entities.Instructor;

import java.util.List;

public interface IInstructorServices {
    Instructor addInstructor(Instructor instructor);
    Instructor updateInstructor(Instructor instructor);
    Instructor retrieveInstructor(Long id);
    void removeInstructor(Long id);
    List<Instructor> retrieveAll();
    Instructor addInstructorAndAssignToCourse(Instructor instructor, Long numCourse);

}
