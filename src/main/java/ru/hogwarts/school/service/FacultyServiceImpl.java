package ru.hogwarts.school.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repository.FacultyRepository;

import java.awt.*;
import java.util.*;
import java.util.List;

@Service
public class FacultyServiceImpl implements FacultyService{
    Logger logger = LoggerFactory.getLogger(FacultyServiceImpl.class);
    private final FacultyRepository facultyRepository;

    public FacultyServiceImpl(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    public Faculty create(Faculty faculty) {
        logger.info("Was invoked method for create faculty");
        return facultyRepository.save(faculty);
    }
    public void delete(Long id) {
        logger.info("Was invoked method for delete faculty");
        facultyRepository.deleteById(id);
    }
    public Faculty get(Long id) {
        logger.info("Was invoked method for get faculty");
        return facultyRepository.findById(id).get();
    }
    public Collection<Faculty> getAll() {
        logger.info("Was invoked method for get all faculty");
        return facultyRepository.findAll();
    }
    public Faculty update(Faculty faculty) {
        logger.info("Was invoked method for update faculty");
        return facultyRepository.save(faculty);
    }
    public Collection<Faculty> findByColor(String color) {
        logger.info("Was invoked method for find faculty by color");
        return facultyRepository.findByColorIgnoreCase(color);
    }
    public Collection<Faculty> findByName(String name) {
        logger.info("Was invoked method for find faculty by name");
        return facultyRepository.findByNameIgnoreCase(name);
    }
    public Collection<Student> getListStudentsByIdFaculty(Long id) {
        logger.info("Was invoked method for get list students by ID faculty");
        return facultyRepository.findById(id).get().getStudentSet();
    }
    public String getMaxNameFaculty() {
        List<Faculty> listFaculty = facultyRepository.findAll();

        String maxNameFaculty = listFaculty.stream()
                .map(Faculty::getName)
                .max((s1, s2) -> s1.length()-s2.length())
                .orElse(null);

        return maxNameFaculty;
    }
}
