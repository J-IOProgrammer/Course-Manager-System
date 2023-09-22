package com.jio.coursemanagersystem.controller;

import com.jio.coursemanagersystem.model.Course;
import com.jio.coursemanagersystem.service.CourseService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import static org.mockito.Mockito.*;

public class CourseControllerTest {

    @InjectMocks
    private CourseController courseController;

    @Mock
    private CourseService courseService;

    private WebTestClient webTestClient;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        webTestClient = WebTestClient.bindToController(courseController).build();
    }
    @Test
    public void testGetCourseById() {
        Long courseId = 1L;
        Course course = new Course();
        course.setId(courseId);
        course.setName("Sample Course");

        when(courseService.getCourseById(courseId)).thenReturn(Mono.just(course));

        webTestClient.get()
                .uri("/courses/{courseId}", courseId)
                .exchange()
                .expectStatus().isOk()
                .expectBody(Course.class)
                .isEqualTo(course);

        verify(courseService, times(1)).getCourseById(courseId);
    }

    @Test
    public void testCreateCourse() {
        Course course = new Course();
        course.setName("New Course");

        when(courseService.createCourse(any(Course.class))).thenReturn(Mono.just(course));

        webTestClient.post()
                .uri("/courses")
                .body(Mono.just(course), Course.class)
                .exchange()
                .expectStatus().isOk()
                .expectBody(Course.class)
                .isEqualTo(course);

        verify(courseService, times(1)).createCourse(any(Course.class));
    }
}

