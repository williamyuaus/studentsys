package com.integradev.studentsys.student.service;

import com.integradev.studentsys.model.Student;
import com.integradev.studentsys.repository.StudentRepository;
import com.integradev.studentsys.service.StudentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.doReturn;

/**
 * Tests the StudentService
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class StudentServiceTest {
    /**
     *  The service that we want to test.
     */
    @Autowired
    StudentService studentService;

    /**
     *  A mock version of the StudentRepository for use in the tests.
     */
    @MockBean
    StudentRepository studentRepository;


    @Test
    @DisplayName("Test findById Success")
    void testFindByIdSuccess() {
        // Setup our mock
        Student mockStudent = new Student(new Long(1), "first1", "last1");
        doReturn(mockStudent).when(studentRepository).getOne(new Long(1));

        // Execute the service call
        Optional<Student> returnedStudent = Optional.of(studentService.findStudent(new Long(1)));

        // Assert the response
        Assertions.assertTrue(returnedStudent.isPresent(), "Student was not found");
        Assertions.assertSame(returnedStudent.get(), mockStudent, "Students should be the same");
    }

    @Test
    @DisplayName("Test listAllStudents")
    void testFindAllStudents() {
        // Setup our mock
        Student mockStudent1 = new Student(new Long(1), "first1", "last1");
        Student mockStudent2 = new Student(new Long(2), "first2", "last2");
        doReturn(Arrays.asList(mockStudent1, mockStudent2)).when(studentRepository).findAll();

        // Execute the service call
        List<Student> students = studentService.listStudents();

        Assertions.assertEquals(2, students.size(), "findAll should return 2 products");
    }
}
