package ru.hogwarts.school.service;

import ru.hogwarts.school.model.Student;

import java.util.List;

public interface StudentService {
    Student create(Student student);
    void delete(Long id);
    Student get(Long id);
    Student update(Long id, Student student);
    List<Student> getListStudentsByAge(int age);
}

