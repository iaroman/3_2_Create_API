package ru.hogwarts.school.service;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.domain.PageRequest;
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
    public Collection<Student> getAll(/*Integer pageNumber, Integer pageSize*/) {
//        PageRequest pageRequest = PageRequest.of(pageNumber -1, pageSize);
        return studentRepository.findAll(/*pageRequest*/)/*.getContent()*/;
    }
    public Collection<Student> findByAgeBetween(int from, int to) {
        return studentRepository.findByAgeBetween(from,to);
    }
    public Faculty getFacultyById(Long studentId) {
        return studentRepository.findById(studentId).get().getFaculty();
    }
    public int countAllStudents() {
        return studentRepository.countAllStudents();
    }
    public double getAvgAgeStudents(){
        return studentRepository.getAvgAgeStudents();
    }
    public Collection<Student> getLastFiveStudent() {
        return studentRepository.getLastFiveStudent();
    }
}
