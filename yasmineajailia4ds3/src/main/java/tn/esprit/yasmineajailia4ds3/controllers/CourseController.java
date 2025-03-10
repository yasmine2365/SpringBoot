package tn.esprit.yasmineajailia4ds3.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.yasmineajailia4ds3.entities.Course;
import tn.esprit.yasmineajailia4ds3.services.ICourseServices;

import java.util.List;
@AllArgsConstructor
@RestController
@RequestMapping("course")
public class CourseController {

    private ICourseServices courseServices;

    @PostMapping("add")
    Course addCourse(@RequestBody Course course) {
        return courseServices.addCourse(course);
    }

    @PutMapping("update")
    Course updateCourse(@RequestBody Course course) {
        return courseServices.updateCourse(course);
    }

    @GetMapping("{id}")
    Course retrieveCourse(@PathVariable Long id) {
        return courseServices.retrieveCourse(id);
    }

    @DeleteMapping("{id}")
    void removeCourse(@PathVariable Long id) {
        courseServices.removeCourse(id);
    }

    @GetMapping("all")
    List<Course> retrieveAll() {
        return courseServices.retrieveAll();
    }
}
