package ru.hogwarts.school.controller;

import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.service.FacultyService;

import java.util.Collection;

@RestController
@RequestMapping("/faculty")
public class FacultyController {
    private final FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @PostMapping
    public Faculty createFaculty(@RequestBody Faculty faculty) {
        return facultyService.create(faculty);
    }
    @GetMapping("{id}")
    public Faculty getFaculty(@PathVariable Long id) {
        if (!(id == null))
            return facultyService.get(id);
        return null;
    }
    @GetMapping
    public Collection<Faculty> getFaculty(@RequestParam(required = false) String color) {
        if (color != null) {
            return facultyService.findByColor(color);
        }
        return facultyService.getAll();
    }
    @PutMapping
    public Faculty updateFaculty(@RequestBody Faculty faculty) {
        return facultyService.update(faculty);
    }
    @DeleteMapping("{id}")
    public void delFaculty(@PathVariable Long id) {
        if (!(id == null))
            facultyService.delete(id);
    }
    @PostConstruct
    public void forTest() {
        facultyService.create(new Faculty("wweeerrrr", "white"));
        facultyService.create(new Faculty("fjdkfhdjkfhdjkfh", "red"));
        facultyService.create(new Faculty("fjdklfjdklfjdkl", "red"));
        facultyService.create(new Faculty("aaaalllll", "black"));
    }
}
