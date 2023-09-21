package com.jio.coursemanagersystem.repository;

import com.jio.coursemanagersystem.model.CoursePerson;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface CoursePersonRepository extends ReactiveCrudRepository<CoursePerson, Long> {
}
