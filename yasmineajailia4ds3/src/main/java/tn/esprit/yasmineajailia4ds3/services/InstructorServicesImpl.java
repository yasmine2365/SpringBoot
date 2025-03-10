package tn.esprit.yasmineajailia4ds3.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.yasmineajailia4ds3.entities.Instructor;
import tn.esprit.yasmineajailia4ds3.repositories.IInstructorRepository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
@Service
@AllArgsConstructor
public class InstructorServicesImpl implements IInstructorServices{
    private IInstructorRepository instructorRepository;

    @Override
    public Instructor addInstructor(Instructor instructor) {
        return instructorRepository.save(instructor);
    }

    @Override
    public Instructor updateInstructor(Instructor instructor) {
        return instructorRepository.save(instructor);
    }

    @Override
    public Instructor retrieveInstructor(Long id) {
        return instructorRepository.findById(id).orElse(null);
    }

    @Override
    public void removeInstructor(Long id) {
        instructorRepository.deleteById(id);
    }

    @Override
    public List<Instructor> retrieveAll() {
        Iterable<Instructor> instructors = instructorRepository.findAll();
        return StreamSupport.stream(instructors.spliterator(), false)
                .collect(Collectors.toList());
    }
}
