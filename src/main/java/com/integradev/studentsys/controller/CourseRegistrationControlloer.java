package com.integradev.studentsys.controller;

import com.integradev.studentsys.exception.CourseRegistrationNotFoundException;
import com.integradev.studentsys.model.CourseRegistration;
import com.integradev.studentsys.service.CourseRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/course-registrations")
public class CourseRegistrationControlloer {
    private CourseRegistrationService courseRegistrationService;

    @Autowired
    public void setCourseRegistrationService(CourseRegistrationService courseRegistrationService) {
        this.courseRegistrationService = courseRegistrationService;
    }

    @GetMapping
    public ResponseEntity<List<CourseRegistration>> getAllCourseRegistrations() {
        List<CourseRegistration> list = courseRegistrationService.listCourseRegistrations();
        return new ResponseEntity<List<CourseRegistration>>(list, HttpStatus.OK);
    }

    @GetMapping
    @RequestMapping("{id}")
    public ResponseEntity<CourseRegistration> getCourseRegistration(@PathVariable Long id){
        try {
            return new ResponseEntity<CourseRegistration>(courseRegistrationService.findCourseRegistration(id), HttpStatus.OK);
        } catch (CourseRegistrationNotFoundException exception){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<CourseRegistration> addCourseRegistration(@RequestBody final CourseRegistration courseRegistration){
        return new ResponseEntity<CourseRegistration>(courseRegistrationService.addCourseRegistration(courseRegistration), HttpStatus.OK);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void deleteCourseRegistration(@PathVariable Long id) {courseRegistrationService.deleteCourseRegistration(id);}

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public ResponseEntity<CourseRegistration> updateCourseRegistration(@PathVariable Long id, @RequestBody CourseRegistration courseRegistration){
        try {
            return new ResponseEntity<CourseRegistration>(courseRegistrationService.updateCourseRegistration(id, courseRegistration), HttpStatus.OK);
        } catch (CourseRegistrationNotFoundException exception){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
