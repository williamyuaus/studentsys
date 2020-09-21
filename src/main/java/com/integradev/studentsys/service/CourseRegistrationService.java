package com.integradev.studentsys.service;

import com.integradev.studentsys.model.CourseRegistration;

import java.util.List;

public interface CourseRegistrationService {
    /**
     * Return all courseRegistrations in the database.
     *
     * @return      All courseRegistrations in the database.
     */
    List<CourseRegistration> listCourseRegistrations();

    /**
     * Returns the courseRegistration with the specified id.
     *
     * @param id    ID of the courseRegistration to retrieve.
     * @return      The request courseRegistration if found.
     */
    CourseRegistration findCourseRegistration(Long id);

    /**
     * Add a courseRegistration to the database.
     * @param courseRegistration   The courseRegistration to add to the database.
     * @return         The added courseRegistration.
     */
    CourseRegistration addCourseRegistration(CourseRegistration courseRegistration);

    /**
     * Deletes the courseRegistration with the specified id.
     *
     * @param id    The id of the courseRegistration to delete.
     */
    void deleteCourseRegistration(Long id);

    /**
     * Updates the specified student, identified by its id.
     *
     * @param id        The id of the courseRegistration to update.
     * @param courseRegistration    The courseRegistration to update.
     * @return          The updated courseRegistration.
     */
    CourseRegistration updateCourseRegistration(Long id, CourseRegistration courseRegistration);
}
