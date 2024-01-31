package ru.hogwarts.school.service;

import ru.hogwarts.school.model.Faculty;

import java.util.List;

public interface FacultyService {
    Faculty create(Faculty faculty);
    void delete(Long id);
    Faculty get(Long id);
    Faculty update(Long id, Faculty faculty);
    List<Faculty> getListFacultyByColor(String color);
}