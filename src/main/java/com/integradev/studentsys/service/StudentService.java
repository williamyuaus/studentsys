package com.integradev.studentsys.service;

import com.integradev.studentsys.model.Student;

import java.util.List;

public interface StudentService {
    /**
     * Return all students in the database.
     *
     * @return      All students in the database.
     */
    List<Student> listStudents();

    /**
     * Returns the student with the specified id.
     *
     * @param id    ID of the student to retrieve.
     * @return      The request Student if found.
     */
    Student findStudent(Long id);

    /**
     * Add a student to the database.
     * @param student   The student to add to the database.
     * @return          The added student.
     */
    Student addStudent(Student student);

    /**
     * Deletes the student with the specified id.
     *
     * @param id    The id of the student to delete.
     */
    void deleteStudent(Long id);

    /**
     * Updates the specified student, identified by its id.
     *
     * @param id        The id of the student to update.
     * @param student   The student to update.
     * @return          The updated student.
     */
    Student updateStudent(Long id, Student student);
}
