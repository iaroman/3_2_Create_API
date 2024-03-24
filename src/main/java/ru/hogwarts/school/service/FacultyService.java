package ru.hogwarts.school.service;

import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;

import java.util.Collection;
import java.util.List;

public interface FacultyService {
    Faculty create(Faculty faculty);
    void delete(Long id);
    Faculty get(Long id);
    Collection<Faculty> getAll();
    Faculty update(Faculty faculty);
    Collection<Faculty> findByColor(String color);
    Collection<Faculty> findByName(String name);
    Collection<Student> getListStudentsByIdFaculty(Long id);
    String getMaxNameFaculty();

}