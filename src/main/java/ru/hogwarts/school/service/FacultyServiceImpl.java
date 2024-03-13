package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repository.FacultyRepository;

import java.awt.*;
import java.util.*;
import java.util.List;

@Service
public class FacultyServiceImpl implements FacultyService{
    private final FacultyRepository facultyRepository;

    public FacultyServiceImpl(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    public Faculty create(Faculty faculty) {
        return facultyRepository.save(faculty);
    }
    public void delete(Long id) {
        facultyRepository.deleteById(id);
    }
    public Faculty get(Long id) {
        return facultyRepository.findById(id).get();
    }
    public Collection<Faculty> getAll() {
        return facultyRepository.findAll();
    }
    public Faculty update(Faculty faculty) {
        return facultyRepository.save(faculty);
    }
    public Collection<Faculty> findByColor(String color) {
        return facultyRepository.findByColorIgnoreCase(color);
    }
    public Collection<Faculty> findByName(String name) {
        return facultyRepository.findByNameIgnoreCase(name);
    }
    public Collection<Student> getListStudentsByIdFaculty(Long id) {
        return facultyRepository.findById(id).get().getStudentSet();
    }
}
