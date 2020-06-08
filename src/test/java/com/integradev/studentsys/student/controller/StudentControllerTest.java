package com.integradev.studentsys.student.controller;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import com.integradev.studentsys.controller.StudentController;
import com.integradev.studentsys.model.Student;
import com.integradev.studentsys.service.CourseService;
import com.integradev.studentsys.service.StudentService;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class StudentControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StudentService studentService;

    @MockBean
    private CourseService courseService;

    @Test
    public void getAllStudents() throws Exception {
        mockMvc.perform(get("/students"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(content().json("[]"));
        verify(studentService, times(1)).listStudents();
    }

}

//    @Test
//    @DisplayName("Get /students/1 - Found")
//    public void testFindStudentByIdFound() throws Exception {
//        // Setup our mocked service
//        Student mockStudent = new Student("Test first name", "Test last name");
//        doReturn(mockStudent).when(service).findStudent(new Long(1));
//
//        // Execute the GET request
//        mockMvc.perform(get("/students/{id}", new Long(1)))
//                // Validate the response code and content type
//                .andExpect(status().isOk())
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
//
//                // Validate the returned fields
//                .andExpect(jsonPath("$.id", is(1)))
//                .andExpect(jsonPath("$.firstName", is("Test first name")))
//                .andExpect(jsonPath("$.lastName", is("Test last name")));
//    }
//
//    @Test
//    @DisplayName("GET /students/1 - Not Found")
//    public void testGetProductByIdNotFound() throws Exception {
//        // Setup our mocked service
//        doReturn(Optional.empty()).when(service).findStudent(new Long(1));
//
//        // Execute the GET request
//        mockMvc.perform(get("/students/{id}", new Long(1)))
//
//                // Validate that we get a 404 Not Found response
//                .andExpect(status().isNotFound());
//    }
//}
