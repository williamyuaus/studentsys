package com.integradev.studentsys.service;

import com.integradev.studentsys.exception.StudentNotFoundException;
import com.integradev.studentsys.model.Student;
import com.integradev.studentsys.repository.StudentRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> listStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student findStudent(Long id) {
        Optional<Student> optionalStudent = Optional.of(studentRepository.getOne(id));
        if (optionalStudent.isPresent())
            return optionalStudent.get();
        else
            throw new StudentNotFoundException("Student Not Found");
    }

    @Override
    public Student addStudent(final Student student) {
        return studentRepository.saveAndFlush(student);
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public Student updateStudent(Long id, Student student) {
        Student existingStudent = studentRepository.getOne(id);
        BeanUtils.copyProperties(student, existingStudent, "id");
        return studentRepository.saveAndFlush(existingStudent);
    }

}
