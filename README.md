# Student Management Back-end System 
The student management Back-end system provides APIs for a demo CRUD web-based app for students management.


## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

What things you need to install the software and how to install them

- jdk 1.8
- IntelliJ IDEA or Eclipse IDE 

### Installing and Running

A step by step series of examples that tell you how to get a development env running

Say what the step will be

1. Extract the project ZIP package and open Intellij.
2. Using your IDE to open the project folder, or clone the repository of the program: https://github.com/williamyuaus/studentsys.git ![image](https://user-images.githubusercontent.com/60310380/84095612-13cdb300-aa43-11ea-9022-6a92d6921934.png)![image](https://user-images.githubusercontent.com/60310380/84095740-6c9d4b80-aa43-11ea-9a42-a1f4aeb91c2c.png)
3. Wait for Maven to load all the dependencies which declared in pom.xml
4. An H2 database has been configured and embedded in the project, so no more configuration needed for the datasource of the system.
5. To run the project, open the StudentsysApplication class (\studentsys\src\main\java\com\integradev\studentsys) by double-clicking on it and then pressing the Run button in the Intellij toolbar, or select the Run menu and press Run 'StudentsysApplication': ![image](https://user-images.githubusercontent.com/60310380/84096433-41b3f700-aa45-11ea-8c20-bf9dc85ad576.png)
6. If the project was executed correctly, you should see the 'Completed initialization in...' text at the end of the console. The following screenshot shows the content of the Intellij console after the Spring Boot project has been started: ![spring-success](https://user-images.githubusercontent.com/60310380/84096481-61e3b600-aa45-11ea-8dcc-a5ca898e8595.JPG)
7. The back-end system is running at port 8080, you can visit the URL: http://localhost:8080/swagger-ui.html#/ to check the API documentation of the system: ![image](https://user-images.githubusercontent.com/60310380/84096598-aa9b6f00-aa45-11ea-99fa-916a3ec53bdd.png)
8. Also, you may use Postman to test the APIs, such as the following screenshot: ![image](https://user-images.githubusercontent.com/60310380/84096656-d159a580-aa45-11ea-8cd6-782fb1200aa6.png)


## Running the tests

Some unit tests can be run for this system.

### Unit tests for service

The StudentServiceTest is a unit test for testing the service layer of the system using JUnit 5 and Mockito.

Open the StudentServiceTest class (\studentsys\src\test\java\com\integradev\studentsys\student\service) and run 'StudentServiceTest': ![image](https://user-images.githubusercontent.com/60310380/84096742-02d27100-aa46-11ea-9444-b1596a2fb75a.png)

testFindByIdSuccess and testFindAllStudents will be running:

```
@Test
    @DisplayName("Test findById Success")
    void testFindByIdSuccess() {
        // Setup our mock
        Student mockStudent = new Student(new Long(1), "first1", "last1");
        doReturn(mockStudent).when(studentRepository).getOne(new Long(1));

        // Execute the service call
        Optional<Student> returnedStudent = Optional.of(studentService.findStudent(new Long(1)));

        // Assert the response
        Assertions.assertTrue(returnedStudent.isPresent(), "Student was not found");
        Assertions.assertSame(returnedStudent.get(), mockStudent, "Students should be the same");
    }

@Test
    @DisplayName("Test listAllStudents")
    void testFindAllStudents() {
        // Setup our mock
        Student mockStudent1 = new Student(new Long(1), "first1", "last1");
        Student mockStudent2 = new Student(new Long(2), "first2", "last2");
        doReturn(Arrays.asList(mockStudent1, mockStudent2)).when(studentRepository).findAll();

        // Execute the service call
        List<Student> students = studentService.listStudents();

        Assertions.assertEquals(2, students.size(), "findAll should return 2 products");
    }
```

### Unit tests for repository

The StudentRepositoryTest is a unit test for testing the repository of the system using DataJpaTest.

Open the StudentRepositoryTest class (\studentsys\src\test\java\com\integradev\studentsys\student\repository) and run 'StudentRepositoryTest': ![image](https://user-images.githubusercontent.com/60310380/84096801-25648a00-aa46-11ea-9815-5ac853645fad.png)

saveStudent and deleteStudents will be tested:
```
 @Test
    public void saveStudent() {
        Student course = new Student("Weibo", "Luo");
        entityManager.persistAndFlush(course);

        assertThat(course.getId()).isNotNull();
    }

    @Test
    public void deleteStudents() {
        entityManager.persistAndFlush(new Student("Weibo", "Luo"));
        entityManager.persistAndFlush(new Student("Albert", "Ding"));

        courseRepository.deleteAll();
        assertThat(courseRepository.findAll().isEmpty());
    }
```

## Deployment

To deploy the backend system, you may use Maven to generate an executable JAR file by typing `mvn clean install` command in the command line.

## Built With

* [Spring Boot](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/) - The web framework used
* [Maven](https://maven.apache.org/) - Dependency Management
* [SWAGGER](https://swagger.io/docs/) - Used to document the APIs

## Authors

* **William YU** - *Initial work* - [William YU](https://github.com/williamyuaus)

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

