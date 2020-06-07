package com.integradev.studentsys.controller;

import com.integradev.studentsys.model.Student;
import com.integradev.studentsys.repository.StudentRepository;
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

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;

    @GetMapping
    public List<Student> list() {
        return studentRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Student get(@PathVariable Long id) {
        return studentRepository.getOne(id);
    }

    @PostMapping
    public Student create(@RequestBody final Student student) {
        return studentRepository.saveAndFlush(student);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        studentRepository.deleteById(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Student update(@PathVariable Long id, @RequestBody Student student) {
        Student existingStudent = studentRepository.getOne(id);
        BeanUtils.copyProperties(student, existingStudent, "id");
        return studentRepository.saveAndFlush(existingStudent);
    }
}
