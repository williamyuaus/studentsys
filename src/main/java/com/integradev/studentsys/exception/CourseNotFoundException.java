package com.integradev.studentsys.exception;

public class CourseNotFoundException extends RuntimeException{
    public CourseNotFoundException(String exception) {
        super(exception);
    }

}
