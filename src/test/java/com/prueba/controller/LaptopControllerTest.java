package com.prueba.controller;

import com.prueba.entities.Gadgets;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class LaptopControllerTest {

    private TestRestTemplate testRestTemplate;

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    @LocalServerPort
    private int port;

    @BeforeEach
        void setUp() {
            restTemplateBuilder = restTemplateBuilder.rootUri("http://localhost:" + port);
            testRestTemplate = new TestRestTemplate((restTemplateBuilder));
    }

    @Test
    void findAll() {
        ResponseEntity<Gadgets[]> response =
                testRestTemplate.getForEntity("/api/laptop/gadgets", Gadgets[].class);

        //assertEquals(HttpStatus.OK, response.getStatusCode());
        //assertEquals(HttpStatus.OK, response.getBody());

        List<Gadgets> gadgets = Arrays.asList(response.getBody());
        System.out.println(gadgets.size());

    }

    @Test
    void findOneById() {
        ResponseEntity<Gadgets> response =
                testRestTemplate.getForEntity("/api/laptop/gadgets/1", Gadgets.class);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());

    }

    @Test
    void create() {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        String json = """
                {
                    "name": "webcam",
                    "brand": "apple",
                    "size": 650,
                    "price": 20.00
                    "online": true
                }
                """;

        HttpEntity<String> request = new HttpEntity<>(json, headers);
        ResponseEntity<Gadgets> response = testRestTemplate.exchange("/api/laptop/gadgets",HttpMethod.POST, request, Gadgets.class);

        Gadgets result = response.getBody();

        //assertEquals(1L, result.getId());
        assertEquals("webcam", result.getName());
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }

    @Test
    void deleteAll() {
    }
}