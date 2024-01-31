package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class StudentServiceImpl implements StudentService{
    private Map<Long, Student> studentMap = new HashMap<>();

    public Student create(Student student) {
        studentMap.put(student.getId(), student);
        return student;
    }
    public void delete(Long id) {
        studentMap.remove(id);
    }
    public Student get(Long id) {
        if (studentMap.containsKey(id)) {
            return studentMap.get(id);
        }
        return null;
    }
    public Student update(Long id, Student student) {
        if (studentMap.containsKey(id)) {
            studentMap.get(id).setName(student.getName());
            studentMap.get(id).setAge(student.getAge());
            return studentMap.get(id);
        }
        return null;
    }
    public List<Student> getListStudentsByAge(int age) {
        List<Student> list = new ArrayList<>();
        for (Student value : studentMap.values()) {
            if (value.getAge() == age)
                list.add(value);
        }
        return list;
    }
}
