package com.integradev.studentsys.repository;

import com.integradev.studentsys.model.CourseRegistration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.data.jpa.repository.JpaRepository;

@CrossOrigin
public interface CourseRegistrationRepository extends JpaRepository<CourseRegistration, Long> {
}
