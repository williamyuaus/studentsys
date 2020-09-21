package com.integradev.studentsys.service;

import com.integradev.studentsys.exception.CourseNotFoundException;
import com.integradev.studentsys.model.CourseRegistration;
import com.integradev.studentsys.repository.CourseRegistrationRepository;
import com.integradev.studentsys.repository.CourseRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseRegistrationServiceImpl implements CourseRegistrationService {
    @Autowired
    private CourseRegistrationRepository courseRegistrationRepository;

    @Override
    public List<CourseRegistration> listCourseRegistrations() {
        return courseRegistrationRepository.findAll();
    }

    @Override
    public CourseRegistration findCourseRegistration(Long id) {
        Optional<CourseRegistration> optionalCourse = Optional.of(courseRegistrationRepository.getOne(id));
        if (optionalCourse.isPresent())
            return optionalCourse.get();
        else
            throw new CourseNotFoundException("CourseRegistration Not Found");
    }

    @Override
    public CourseRegistration addCourseRegistration(CourseRegistration courseRegistration) {
        return courseRegistrationRepository.saveAndFlush(courseRegistration);
    }

    @Override
    public void deleteCourseRegistration(Long id) {
        courseRegistrationRepository.deleteById(id);
    }

    @Override
    public CourseRegistration updateCourseRegistration(Long id, CourseRegistration courseRegistration) {
        CourseRegistration existingCourse = courseRegistrationRepository.getOne(id);
        BeanUtils.copyProperties(courseRegistration, existingCourse, "id");
        return courseRegistrationRepository.saveAndFlush(existingCourse);
    }
}
