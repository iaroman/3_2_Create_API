package ru.hogwarts.school.controller;

import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.service.StudentService;
import ru.hogwarts.school.service.StudentServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return studentService.create(student);
    }
    @GetMapping("{id}")
    public Student getStudent(@PathVariable Long id) {
        if (!(id == null))
            return studentService.get(id);
        return null;
    }
    @PutMapping("{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student student) {
        return studentService.update(id, student);
    }
    @DeleteMapping("{id}")
    public void delStudent(@PathVariable Long id) {
        if (!(id == null))
            studentService.delete(id);
    }
    @GetMapping
    public List<Student> getListStudentsByAge(@RequestParam int age) {
        return studentService.getListStudentsByAge(age);
    }
    @PostConstruct
    public void forTest() {
        studentService.create(new Student("first", 29));
        studentService.create(new Student("two", 28));
        studentService.create(new Student("three", 259));
        studentService.create(new Student("four", 29));
    }
}
