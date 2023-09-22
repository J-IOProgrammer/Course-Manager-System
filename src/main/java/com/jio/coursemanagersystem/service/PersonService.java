package com.jio.coursemanagersystem.service;

import com.jio.coursemanagersystem.model.Person;
import com.jio.coursemanagersystem.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Flux<Person> getAllPersons() {
        return personRepository.findAll();
    }

    public Mono<Person> getPersonById(Long personId) {
        return personRepository.findById(personId);
    }

    public Mono<Person> createPerson(Person person) {
        return personRepository.save(person);
    }

    public Mono<Void> deletePersonById(Long personId) {
        return personRepository.deleteById(personId);
    }
}

