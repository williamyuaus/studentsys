package com.integradev.studentsys.service;

import com.integradev.studentsys.exception.CourseNotFoundException;
import com.integradev.studentsys.model.Course;
import com.integradev.studentsys.repository.CourseRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService{
    @Autowired
    private CourseRepository courseRepository;

    @Override
    public List<Course> listCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Course findCourse(Long id) {
        Optional<Course> optionalCourse = Optional.of(courseRepository.getOne(id));
        if (optionalCourse.isPresent())
            return optionalCourse.get();
        else
            throw new CourseNotFoundException("Course Not Found");
    }

    @Override
    public Course addCourse(Course course) {
        return courseRepository.saveAndFlush(course);
    }

    @Override
    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }

    @Override
    public Course updateCourse(Long id, Course course) {
        Course existingCourse = courseRepository.getOne(id);
        BeanUtils.copyProperties(course, existingCourse, "id");
        return courseRepository.saveAndFlush(existingCourse);
    }
}
