package ru.hogwarts.school.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
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
    @Operation(summary = "Create faculty")
    public Faculty createFaculty(@RequestBody Faculty faculty) {
        return facultyService.create(faculty);
    }
    @GetMapping("{id}")
    @Operation(summary = "Get faculty by id")
    public Faculty getFaculty(@PathVariable Long id) {
        if (!(id == null))
            return facultyService.get(id);
        return null;
    }
    @GetMapping
    @Operation(summary = "Get all faculty or by color or by name")
    public Collection<Faculty> getFaculty(@RequestParam(required = false) String color,
                                          @RequestParam(required = false) String name) {
        if (color != null) {
            return facultyService.findByColor(color);
        }
        if (name != null) {
            return facultyService.findByName(name);
        }
        return facultyService.getAll();
    }
    @GetMapping("{id}/students")
    @Operation(summary = "Get all list students by id faculty")
    public Collection<Student> getListStudentsByIdFaculty(@PathVariable Long id) {
        return facultyService.getListStudentsByIdFaculty(id);
    }
    @PutMapping
    @Operation(summary = "Update data faculty")
    public Faculty updateFaculty(@RequestBody Faculty faculty) {
        return facultyService.update(faculty);
    }
    @DeleteMapping("{id}")
    @Operation(summary = "Delete faculty by id")
    public void delFaculty(@PathVariable Long id) {
        if (!(id == null))
            facultyService.delete(id);
    }
    /*@PostConstruct
    public void forTest() {
        facultyService.create(new Faculty("wweeerrrr", "white"));
        facultyService.create(new Faculty("fjdkfhdjkfhdjkfh", "red"));
        facultyService.create(new Faculty("fjdklfjdklfjdkl", "red"));
        facultyService.create(new Faculty("aaaalllll", "black"));
    }*/
}
