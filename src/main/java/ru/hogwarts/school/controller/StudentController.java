package ru.hogwarts.school.controller;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.service.StudentService;

import java.util.Collection;


@RestController
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    @Operation(summary = "Create student")
    public Student createStudent(@RequestBody Student student) {
        return studentService.create(student);
    }

    @GetMapping("{id}")
    @Operation(summary = "Get student by Id")
    public Student getStudent(@PathVariable Long id) {
        if (id != null)
            return studentService.get(id);
        return null;
    }
    @GetMapping("{id}/faculty")
    @Operation(summary = "Get faculty by Id")
    public Faculty getFacultyById(@PathVariable Long id){
        if (id != null) {
            return studentService.getFacultyById(id);
        }
        return null;
    }

    @GetMapping
    @Operation(summary = "Get all student or between from/to")
    public Collection<Student> getStudent(@RequestParam(required = false) Integer from,
                                          @RequestParam(required = false) Integer to) {

        if ((from != null) & (to != null)) {
            return studentService.findByAgeBetween(from, to);
        }
        return studentService.getAll();
    }

    @PutMapping
    @Operation(summary = "Update data student")
    public Student updateStudent(@RequestBody Student student) {
        return studentService.update(student);
    }

    @DeleteMapping("{id}")
    @Operation(summary = "Delete student by id")
    public void delStudent(@PathVariable Long id) {
        if (id != null)
            studentService.delete(id);
    }
   /* @PostConstruct
    public void forTest() {
        studentService.create(new Student("first", 10));
        studentService.create(new Student("two", 15));
        studentService.create(new Student("three", 25));
        studentService.create(new Student("four", 35));
    }*/
}
