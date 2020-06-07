package com.integradev.studentsys;

import com.integradev.studentsys.model.Course;
import com.integradev.studentsys.model.Student;
import com.integradev.studentsys.repository.CourseRepository;
import com.integradev.studentsys.repository.StudentRepository;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;


@SpringBootApplication
public class StudentsysApplication {
    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private StudentRepository studentRepository;

    private static final Logger log = LoggerFactory.getLogger(StudentsysApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(StudentsysApplication.class, args);
    }

    @Bean
    public CommandLineRunner runner(){
        return args -> {
            courseRepository.save(new Course("Python Class"));
            courseRepository.save( new Course("Robotics Class"));
            studentRepository.save(new Student("Weibo", "Luo"));
            studentRepository.save(new Student("Albert", "Ding"));

            for (Course course: courseRepository.findAll()){
                log.info("The course is: " + course.toString());
            }
        };
    }

}
