package com.jio.coursemanagersystem.controller;

import com.jio.coursemanagersystem.model.Person;
import com.jio.coursemanagersystem.service.PersonService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import static org.mockito.Mockito.*;

public class PersonControllerTest {

    @InjectMocks
    private PersonController personController;

    @Mock
    private PersonService personService;

    private WebTestClient webTestClient;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        webTestClient = WebTestClient.bindToController(personController).build();
    }

    @Test
    public void testGetPersonById() {
        Long personId = 1L;
        Person person = new Person();
        person.setId(personId);
        person.setName("John Doe");

        when(personService.getPersonById(personId)).thenReturn(Mono.just(person));

        webTestClient.get()
                .uri("/persons/{personId}", personId)
                .exchange()
                .expectStatus().isOk()
                .expectBody(Person.class)
                .isEqualTo(person);

        verify(personService, times(1)).getPersonById(personId);
    }

    @Test
    public void testCreatePerson() {
        Person person = new Person();
        person.setName("Alice");

        when(personService.createPerson(any(Person.class))).thenReturn(Mono.just(person));

        webTestClient.post()
                .uri("/persons")
                .body(Mono.just(person), Person.class)
                .exchange()
                .expectStatus().isOk()
                .expectBody(Person.class)
                .isEqualTo(person);

        verify(personService, times(1)).createPerson(any(Person.class));
    }
}

