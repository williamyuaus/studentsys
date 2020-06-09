package com.integradev.studentsys.service;

import com.integradev.studentsys.model.Course;

import java.util.List;

public interface CourseService {
    /**
     * Return all courses in the database.
     *
     * @return      All courses in the database.
     */
    List<Course> listCourses();

    /**
     * Returns the course with the specified id.
     *
     * @param id    ID of the course to retrieve.
     * @return      The request course if found.
     */
    Course findCourse(Long id);

    /**
     * Add a course to the database.
     * @param course   The course to add to the database.
     * @return         The added course.
     */
    Course addCourse(Course course);

    /**
     * Deletes the course with the specified id.
     *
     * @param id    The id of the course to delete.
     */
    void deleteCourse(Long id);

    /**
     * Updates the specified student, identified by its id.
     *
     * @param id        The id of the course to update.
     * @param course    The course to update.
     * @return          The updated course.
     */
    Course updateCourse(Long id, Course course);
}
