package ru.hogwarts.school.service;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repository.StudentRepository;

import java.util.Collection;

@Service
public class StudentServiceImpl implements StudentService{
    Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);
    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    public Student create(Student student) {
        logger.info("Was invoked method for create student");
        return studentRepository.save(student);
    }
    public void delete(Long id) {
        logger.info("Was invoked method for delete student");
        studentRepository.deleteById(id);
    }
    public Student get(Long id) {
        logger.info("Was invoked method for get student");
        return studentRepository.findById(id).get();
    }
    public Student update(Student student) {
        logger.info("Was invoked method for update student");
        return studentRepository.save(student);
    }
    public Collection<Student> getAll(/*Integer pageNumber, Integer pageSize*/) {
//        PageRequest pageRequest = PageRequest.of(pageNumber -1, pageSize);
        logger.info("Was invoked method for get all students");
        return studentRepository.findAll(/*pageRequest*/)/*.getContent()*/;
    }
    public Collection<Student> findByAgeBetween(int from, int to) {
        logger.info("Was invoked method for get students by age");
        return studentRepository.findByAgeBetween(from,to);
    }
    public Faculty getFacultyById(Long studentId) {
        logger.info("Was invoked method for get faculty by ID student");
        return studentRepository.findById(studentId).get().getFaculty();
    }
    public int countAllStudents() {
        logger.info("Was invoked method for count all students");
        return studentRepository.countAllStudents();
    }
    public double getAvgAgeStudents(){
        logger.info("Was invoked method for get average age students");
        return studentRepository.getAvgAgeStudents();
    }
    public Collection<Student> getLastFiveStudent() {
        logger.info("Was invoked method for get list last five students");
        return studentRepository.getLastFiveStudent();
    }
}
