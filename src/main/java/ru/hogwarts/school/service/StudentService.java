package ru.hogwarts.school.service;

import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;

import java.util.Collection;

public interface StudentService {
    Student create(Student student);
    void delete(Long id);
    Student get(Long id);
    Student update(Student student);
    Collection<Student> getAll();
    Collection<Student> findByAgeBetween(int from, int to);
    Faculty getFacultyById(Long studentId);
}

