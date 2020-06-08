//package com.integradev.studentsys.student.repository;
//
//import com.github.database.rider.core.api.connection.ConnectionHolder;
//import com.github.database.rider.core.api.dataset.DataSet;
//import com.github.database.rider.junit5.DBUnitExtension;
//import com.github.database.rider.junit5.DBUnitExtension;
//import com.integradev.studentsys.model.Student;
//import com.integradev.studentsys.repository.StudentRepository;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.ActiveProfiles;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//import javax.sql.DataSource;
//import java.util.List;
//import java.util.Optional;
//
//@ExtendWith({DBUnitExtension.class, SpringExtension.class})
//@SpringBootTest
//@ActiveProfiles("test")
//public class StudentRepositoryTest {
//
//    @Autowired
//    private DataSource dataSource;
//
//    @Autowired
//    private StudentRepository studentRepository;
//
//    public ConnectionHolder getConnectionHolder() {
//        // Return a function that retrieves a connection from our data source
//        return () -> dataSource.getConnection();
//    }
//
////    @Test
////    @DataSet("students.yml")
////    public void testFindAll() {
////        List<Student> students = studentRepository.findAll();
////        Assertions.assertEquals(2, students.size(), "We should have 2 students in our database");
////    }
//}
