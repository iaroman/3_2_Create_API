package ru.hogwarts.school.service;

import ru.hogwarts.school.model.Faculty;

import java.util.Collection;

public interface FacultyService {
    Faculty create(Faculty faculty);
    void delete(Long id);
    Faculty get(Long id);
    Collection<Faculty> getAll();
    Faculty update(Faculty faculty);

    Collection<Faculty> findByColor(String color);
}