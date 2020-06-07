package com.integradev.studentsys.repository;

import com.integradev.studentsys.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin
public interface StudentRepository extends JpaRepository<Student, Long> {
    // Fetch students by first name
//    List<Student> findByFirst_name(String first_name);
}
