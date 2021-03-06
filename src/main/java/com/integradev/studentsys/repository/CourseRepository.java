package com.integradev.studentsys.repository;

import com.integradev.studentsys.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;


@CrossOrigin
public interface CourseRepository extends JpaRepository<Course, Long> {

}
