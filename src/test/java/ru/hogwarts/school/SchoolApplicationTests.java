package ru.hogwarts.school;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import ru.hogwarts.school.controller.FacultyController;
import ru.hogwarts.school.controller.StudentController;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SchoolApplicationTests {
	@LocalServerPort
	private int port;

	@Autowired
	private StudentController studentController;
	@Autowired
	private FacultyController facultyController;
	@Autowired
	private TestRestTemplate restTemplate;
	@Test
	void contextLoadsForStudentController() throws Exception {
		Assertions.assertThat(studentController).isNotNull();
	}
	@Test
	void contextLoadsForFacultyController() throws Exception {
		Assertions.assertThat(facultyController).isNotNull();
	}


}
