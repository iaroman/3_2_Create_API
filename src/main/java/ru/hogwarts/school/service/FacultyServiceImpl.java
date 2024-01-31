package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class FacultyServiceImpl implements FacultyService{
    private Map<Long, Faculty> facultyMap = new HashMap<>();
    public Faculty create(Faculty faculty) {
        facultyMap.put(faculty.getId(), faculty);
        return faculty;
    }
    public void delete(Long id) {
        facultyMap.remove(id);
    }
    public Faculty get(Long id) {
        if (facultyMap.containsKey(id)) {
           return facultyMap.get(id);
        }
        return null;
    }
    public Faculty update(Long id, Faculty faculty) {
        if (facultyMap.containsKey(id)) {
            facultyMap.get(id).setName(faculty.getName());
            facultyMap.get(id).setColor(faculty.getColor());
            return facultyMap.get(id);
        }
        return null;
    }
    public List<Faculty> getListFacultyByColor(String color) {
        List<Faculty> list = new ArrayList<>();
        for (Faculty value : facultyMap.values()) {
            if (color.equals(value.getColor()))
                list.add(value);
        }
        return list;
    }
}
