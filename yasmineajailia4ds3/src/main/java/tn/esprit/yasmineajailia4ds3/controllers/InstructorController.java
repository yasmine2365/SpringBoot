package tn.esprit.yasmineajailia4ds3.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.yasmineajailia4ds3.entities.Instructor;
import tn.esprit.yasmineajailia4ds3.services.IInstructorServices;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("instructor")
public class InstructorController {

    private IInstructorServices instructorServices;

    @PostMapping("add")
    Instructor addInstructor(@RequestBody Instructor instructor) {
        return instructorServices.addInstructor(instructor);
    }

    @PutMapping("update")
    Instructor updateInstructor(@RequestBody Instructor instructor) {
        return instructorServices.updateInstructor(instructor);
    }

    @GetMapping("{id}")
    Instructor retrieveInstructor(@PathVariable Long id) {
        return instructorServices.retrieveInstructor(id);
    }

    @DeleteMapping("{id}")
    void removeInstructor(@PathVariable Long id) {
        instructorServices.removeInstructor(id);
    }

    @GetMapping("all")
    List<Instructor> retrieveAll() {
        return instructorServices.retrieveAll();
    }
}
