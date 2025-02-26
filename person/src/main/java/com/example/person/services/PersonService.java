package com.example.person.services;


import com.example.person.models.Person;
import com.example.person.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    // Create or update person
    public Person savePerson(Person person) {
        return personRepository.save(person);
    }

    // Get all people
    public List<Person> getAllPeople() {
        return personRepository.findAll();
    }

    // Get person by ID
    public Optional<Person> getPersonById(Integer id) {
        return personRepository.findById(id);
    }

    // Delete person by ID
    public void deletePerson(Integer id) {
        personRepository.deleteById(id);
    }
}
