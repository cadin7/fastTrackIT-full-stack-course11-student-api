package ro.fasttrackit.homework11.student.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ro.fasttrackit.homework11.student.exceptions.StudentNotFoundException;
import ro.fasttrackit.homework11.student.model.entity.Student;
import ro.fasttrackit.homework11.student.model.StudentFilters;
import ro.fasttrackit.homework11.student.service.StudentService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("students")
public class StudentController {
    private final StudentService studentService;

    @GetMapping
    List<Student> getAll(StudentFilters studentFilters){
        return studentService.getAll(studentFilters);
    }

    @PostMapping
    Student addStudent(@RequestBody Student newStudent){
        return studentService.addStudent(newStudent);
    }

    @GetMapping("{studentId}")
    Student getStudent(@PathVariable String studentId){
        return studentService.getStudent(studentId)
                .orElseThrow(() -> new StudentNotFoundException("Couldn't find student with ID: " + studentId));
    }
}
