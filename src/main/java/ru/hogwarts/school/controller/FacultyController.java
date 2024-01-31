package ru.hogwarts.school.controller;

import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.service.FacultyService;

import java.util.List;

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
    @PutMapping("{id}")
    public Faculty updateFaculty(@PathVariable Long id, @RequestBody Faculty faculty) {
        return facultyService.update(id, faculty);
    }
    @DeleteMapping("{id}")
    public void delFaculty(@PathVariable Long id) {
        if (!(id == null))
            facultyService.delete(id);
    }
    @GetMapping
    public List<Faculty> getListFacultyByColor(@RequestParam String color) {
        return facultyService.getListFacultyByColor(color);
    }
    @PostConstruct
    public void forTest() {
        facultyService.create(new Faculty("wweeerrrr", "white"));
        facultyService.create(new Faculty("fjdkfhdjkfhdjkfh", "red"));
        facultyService.create(new Faculty("fjdklfjdklfjdkl", "red"));
        facultyService.create(new Faculty("aaaalllll", "black"));
    }
}
