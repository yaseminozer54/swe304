package com.example.person.repositories;

import com.example.person.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
public interface PersonRepository extends JpaRepository<Person, Integer> {
}
