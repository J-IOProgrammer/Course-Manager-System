package com.jio.coursemanagersystem.service;

import com.jio.coursemanagersystem.model.Course;
import com.jio.coursemanagersystem.model.CoursePerson;
import com.jio.coursemanagersystem.repository.CoursePersonRepository;
import com.jio.coursemanagersystem.repository.CourseRepository;
import com.jio.coursemanagersystem.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class CourseService {

    private final CourseRepository courseRepository;
    private final PersonRepository personRepository;
    private final CoursePersonRepository coursePersonRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository, PersonRepository personRepository, CoursePersonRepository coursePersonRepository) {
        this.courseRepository = courseRepository;
        this.personRepository = personRepository;
        this.coursePersonRepository = coursePersonRepository;
    }

    public Mono<Course> getCourseById(Long courseId) {
        return courseRepository.findById(courseId);
    }

    public Mono<Course> createCourse(Course course) {
        return courseRepository.save(course);
    }

    public Mono<CoursePerson> assignPersonToCourse(Long courseId, Long personId) {
        CoursePerson coursePerson = new CoursePerson();
        coursePerson.setCourseId(courseId);
        coursePerson.setPersonId(personId);
        return coursePersonRepository.save(coursePerson);
    }
}