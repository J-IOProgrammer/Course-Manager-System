package com.jio.coursemanagersystem.repository;

import com.jio.coursemanagersystem.model.Person;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface PersonRepository extends ReactiveCrudRepository<Person, Long> {
}

