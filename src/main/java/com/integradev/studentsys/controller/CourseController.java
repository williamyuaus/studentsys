package com.integradev.studentsys.controller;

import com.integradev.studentsys.model.Course;
import com.integradev.studentsys.repository.CourseRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/courses")
public class CourseController {
    @Autowired
    private CourseRepository courseRepository;


    @GetMapping
    public List<Course> list() {
        return courseRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Course get(@PathVariable Long id) {
        return courseRepository.getOne(id);
    }

    @PostMapping
    public Course create(@RequestBody final Course course) {
        return courseRepository.saveAndFlush(course);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        courseRepository.deleteById(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Course update(@PathVariable Long id, @RequestBody Course course) {
        Course existingCourse = courseRepository.getOne(id);
        BeanUtils.copyProperties(course, existingCourse, "id");
        return courseRepository.saveAndFlush(existingCourse);
    }
}
