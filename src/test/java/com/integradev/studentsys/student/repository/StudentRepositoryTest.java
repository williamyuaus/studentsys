package com.integradev.studentsys.student.repository;

import com.integradev.studentsys.model.Student;
import com.integradev.studentsys.repository.StudentRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class StudentRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent() {
        Student student = new Student("Weibo", "Luo");
        entityManager.persistAndFlush(student);
        // Validate the saved student
        assertThat(student.getId()).isNotNull();
    }

    @Test
    public void deleteStudents() {
        entityManager.persistAndFlush(new Student("Weibo", "Luo"));
        entityManager.persistAndFlush(new Student("Albert", "Ding"));

        studentRepository.deleteAll();
        
        // Validate that the students has been deleted.
        assertThat(studentRepository.findAll().isEmpty());
    }
}
