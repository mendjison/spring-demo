package de.uni.siegen.springDemo.dao;

import de.uni.siegen.springDemo.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.Set;

public interface PersonRepository extends JpaRepository<Person, Long> {

    Set<Person> findByLastname(String lastname);
    Set<Person> findByFirstname(String firstname);
    Optional<Person> findById(Long id);
}
