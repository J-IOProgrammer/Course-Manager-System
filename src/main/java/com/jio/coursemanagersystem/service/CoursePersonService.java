package com.jio.coursemanagersystem.service;

import com.jio.coursemanagersystem.model.CoursePerson;
import com.jio.coursemanagersystem.repository.CoursePersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class CoursePersonService {

    private final CoursePersonRepository coursePersonRepository;

    @Autowired
    public CoursePersonService(CoursePersonRepository coursePersonRepository) {
        this.coursePersonRepository = coursePersonRepository;
    }

    public Mono<CoursePerson> assignPersonToCourse(Long courseId, Long personId) {
        CoursePerson coursePerson = new CoursePerson();
        coursePerson.setCourseId(courseId);
        coursePerson.setPersonId(personId);
        return coursePersonRepository.save(coursePerson);
    }
}

