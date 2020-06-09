package com.integradev.studentsys.controller;

import com.integradev.studentsys.exception.StudentNotFoundException;
import com.integradev.studentsys.model.Student;
import com.integradev.studentsys.service.StudentService;
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
@RequestMapping("/students")
public class StudentController {
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @Autowired
    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    /**
     * Return all students in the database.
     *
     * @return      All students in the database.
     */
    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> list = studentService.listStudents();
        return new ResponseEntity<List<Student>>(list, HttpStatus.OK);
    }

    /**
     * Returns the student with the specified id.
     *
     * @param id    ID of the student to retrieve.
     * @return      The request Student if found.
     */
    @GetMapping
    @RequestMapping("{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Long id) {
        try {
            return new ResponseEntity<Student>(studentService.findStudent(id), HttpStatus.OK);
        } catch (StudentNotFoundException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Add a student to the database.
     * @param student   The student to add to the database.
     * @return          The added student.
     */
    @PostMapping
    public ResponseEntity<Student> addStudent(@RequestBody final Student student) {
        return new ResponseEntity<Student>(studentService.addStudent(student), HttpStatus.OK);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }

    /**
     * Deletes the student with the specified id.
     *
     * @param id    The id of the student to delete.
     */
    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student student) {
        try {
            return new ResponseEntity<Student>(studentService.updateStudent(id, student), HttpStatus.OK);
        } catch (StudentNotFoundException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
