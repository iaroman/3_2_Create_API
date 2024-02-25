package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repository.StudentRepository;

import java.util.Collection;

@Service
public class StudentServiceImpl implements StudentService{
    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    public Student create(Student student) {
        return studentRepository.save(student);
    }
    public void delete(Long id) {
        studentRepository.deleteById(id);
    }
    public Student get(Long id) {
        return studentRepository.findById(id).get();
    }
    public Student update(Student student) {
        return studentRepository.save(student);
    }
    public Collection<Student> getAll() {
        return studentRepository.findAll();
    }
    public Collection<Student> findByAgeBetween(int from, int to) {
        return studentRepository.findByAgeBetween(from,to);
    }
    public Faculty getFacultyById(Long studentId) {
        return studentRepository.findById(studentId).get().getFaculty();
    }
}
