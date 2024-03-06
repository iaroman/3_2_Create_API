package ru.hogwarts.school.controller;

import org.assertj.core.api.Assertions;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import ru.hogwarts.school.model.Faculty;

import java.util.Collection;

import static org.hamcrest.Matchers.any;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class FacultyControllerTemplateTest {
    @LocalServerPort
    private int port;
    @Autowired
    private FacultyController facultyController;
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void contextLoadsForFacultyController() throws Exception {
        Assertions.assertThat(facultyController).isNotNull();
    }
    @Test
    public void testGetFaculty() throws Exception {
        Assertions
                .assertThat(this.restTemplate.getForObject(
                        "http://localhost:" + port + "/faculty", String.class))
                .isNotNull();
    }
    @Test
    public void testTypeGetFaculty() throws Exception {
        Assertions
                .assertThat(this.restTemplate.getForObject(
                        "http://localhost:" + port + "/faculty", String.class))
                .isNotNull()
                .isEqualTo(any(JSONObject.class));
    }

    @Test
    public void testAuthor() throws Exception {
        Assertions
                .assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/info", String.class))
                .isEqualTo("Author of this application is Good person!");
    }
}
