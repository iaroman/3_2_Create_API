package ru.hogwarts.school.controller;

import org.assertj.core.api.Assertions;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ResponseStatus;
import ru.hogwarts.school.model.Faculty;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import static org.hamcrest.Matchers.any;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
    public void testCreateFaculty() throws Exception {
        Faculty faculty = new Faculty("new faculty", "color");
        faculty.setId(1L);
        Assertions
                .assertThat(this.restTemplate.postForObject(
                        "http://localhost:" + port + "/faculty", faculty, Faculty.class))
                .isEqualTo(faculty);
    }
    @Test
    public void testGetFacultyById() throws Exception {
        Long id = 1L;

        Faculty faculty = restTemplate.getForObject(
                "http://localhost:" + port + "/faculty/" + id, Faculty.class);

        assertEquals(faculty.getId(), id);
    }
    @Test
    public void testGetListStudentsByIdFaculty() {
        Long id = 1L;

        Assertions
                .assertThat(this.restTemplate.getForObject(
                        "http://localhost:" + port + "/faculty/" + id + "/students", Collection.class))
                .isNotNull();
    }
    @Test
    public void testUpdateFaculty() {
        Long id = 1L;

        Faculty updateFaculty = new Faculty("new faculty", "new color");
        updateFaculty.setId(id);

        Assertions
                .assertThat(this.restTemplate.postForObject(
                        "http://localhost:" + port + "/faculty", updateFaculty, Faculty.class))
                .isNotNull();

       String newName = "faculty test";
       String newColor = "color test";

        Map<String, String> params = new HashMap<>();
        params.put("name", newName);
        params.put("color", newColor);

        restTemplate.put("http://localhost:" + port + "/faculty", updateFaculty, params);

        Faculty facultyForTest = restTemplate.getForObject(
                "http://localhost:" + port + "/faculty/" + id, Faculty.class);

        assertEquals(newName, facultyForTest.getName());
        assertEquals(newColor, facultyForTest.getColor());
    }

}
