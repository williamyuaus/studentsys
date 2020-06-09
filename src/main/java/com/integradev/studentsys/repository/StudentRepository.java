package com.integradev.studentsys.repository;

import com.integradev.studentsys.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 * The persistence layer for student.
 */
@CrossOrigin
public interface StudentRepository extends JpaRepository<Student, Long> {

}
