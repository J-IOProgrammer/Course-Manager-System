package com.jio.coursemanagersystem.controller;

import com.jio.coursemanagersystem.model.Course;
import com.jio.coursemanagersystem.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private final CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/{courseId}")
    public Mono<Course> getCourseById(@PathVariable Long courseId) {
        return courseService.getCourseById(courseId);
    }

    @PostMapping
    public Mono<Course> createCourse(@RequestBody Course course) {
        return courseService.createCourse(course);
    }
}

