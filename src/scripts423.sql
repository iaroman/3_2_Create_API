SELECT student.name, student.age, f.name
FROM student
LEFT JOIN faculty f on f.id = student.faculty_id;

SELECT *
FROM student
INNER JOIN avatar a on student.id = a.student_id;
