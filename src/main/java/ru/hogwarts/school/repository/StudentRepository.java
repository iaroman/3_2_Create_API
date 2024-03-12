package ru.hogwarts.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.hogwarts.school.model.Student;

import java.util.Collection;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Collection<Student> findByAgeBetween(int from, int to);

    @Query(value = "SELECT COUNT(*) FROM student", nativeQuery = true)
    int countAllStudents();

    @Query(value = "SELECT AVG(age) from student", nativeQuery = true)
    double getAvgAgeStudents();
    @Query(value = "SELECT * from student order by id desc limit 5", nativeQuery = true)
    Collection<Student> getLastFiveStudent();

}
