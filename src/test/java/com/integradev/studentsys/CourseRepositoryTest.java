package com.integradev.studentsys;

import com.integradev.studentsys.model.Course;
import com.integradev.studentsys.repository.CourseRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CourseRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void saveCourse() {
        Course course = new Course("Math");
        entityManager.persistAndFlush(course);

        assertThat(course.getId()).isNotNull();
    }

    @Test
    public void deleteCourses() {
        entityManager.persistAndFlush(new Course("Math"));
        entityManager.persistAndFlush(new Course("Science"));

        courseRepository.deleteAll();
        assertThat(courseRepository.findAll().isEmpty());
    }
}
