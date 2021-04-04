package de.uni.siegen.springDemo.services;

import de.uni.siegen.springDemo.model.Person;

import java.util.Set;

public interface PersonService {
    Person createPerson(Person person);
    Person updatePerson(Long id, Person person);
    boolean deletePerson(Long id);
    Person findPersonById(Long id);
    Set<Person> findPersons();
    Set<Person> findPersonsByFirstname(String firstname);
    Set<Person> findPersonsByLastname(String lastname);
}
