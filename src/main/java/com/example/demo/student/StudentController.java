package com.example.demo.student;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/student")
public class StudentController {

    private final StudentService studentService;

    /*
    We need to inject studentService from the StudentService class
    into the constructor below for the StudentController
    so that the controller class has access to that object.
    We can create a new instance of StudentService using
    'this.studentService = new StudentService()',
    however we can instead use dependency injection to avoid
    tight coupling.

    We must tell the program to Autowire the beans from the StudentService class
    so that they can be used here.

    @Autowired on the below method instantiates studentService
    and injects it into the constructor.

    We must then also declare the StudentService class as a Spring Component.
    This allows the class to be instantiated
    and that it's contents are Spring Beans.
    */

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getStudents() {
        return studentService.getStudents();
    }

}
