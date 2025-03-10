package tn.esprit.yasmineajailia4ds3.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.yasmineajailia4ds3.entities.Registration;
import tn.esprit.yasmineajailia4ds3.services.IRegistrationServices;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("registration")
public class RegistrationController {

    private IRegistrationServices registrationServices;

    @PostMapping("add")
    Registration addRegistration(@RequestBody Registration registration) {
        return registrationServices.addRegistration(registration);
    }

    @PutMapping("update")
    Registration updateRegistration(@RequestBody Registration registration) {
        return registrationServices.updateRegistration(registration);
    }

    @GetMapping("{id}")
    Registration retrieveRegistration(@PathVariable Long id) {
        return registrationServices.retrieveRegistration(id);
    }

    @DeleteMapping("{id}")
    void removeRegistration(@PathVariable Long id) {
        registrationServices.removeRegistration(id);
    }

    @GetMapping("all")
    List<Registration> retrieveAll() {
        return registrationServices.retrieveAll();
    }

    @PostMapping("addAndAssignToSkier/{numSkieur}")
    Registration addRegistrationAndAssignToSkier(@RequestBody Registration registration, @PathVariable Long numSkieur) {
        return registrationServices.addRegistrationAndAssignToSkier(registration, numSkieur);
    }

    @PostMapping("/assignToCourse/{numRegistration}/courses/{numCourse}")
    Registration assignRegistrationToCourse(@PathVariable Long numRegistration, @PathVariable Long numCourse) {
        return registrationServices.assignRegistrationToCourse(numRegistration, numCourse);
    }
}