package com.jio.coursemanagersystem.repository;

import com.jio.coursemanagersystem.model.Course;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface CourseRepository extends ReactiveCrudRepository<Course, Long> {
}
