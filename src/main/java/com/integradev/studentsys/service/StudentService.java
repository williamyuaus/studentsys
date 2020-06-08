package com.integradev.studentsys.service;

import com.integradev.studentsys.model.Student;

import java.util.List;

public interface StudentService {
    List<Student> listStudents();
    Student findStudent(Long id);
    Student addStudent(Student student);
    void deleteStudent(Long id);
    Student updateStudent(Long id, Student student);
}
