package com.integradev.studentsys.service;

import com.integradev.studentsys.model.Course;

import java.util.List;

public interface CourseService {
    List<Course> listCourses();
    Course findCourse(Long id);
    Course addCourse(Course course);
    void deleteCourse(Long id);
    Course updateCourse(Long id, Course course);
}
