package de.uni.siegen.springDemo.services;

import de.uni.siegen.springDemo.dao.PersonRepository;
import de.uni.siegen.springDemo.model.Person;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service("PersonServiceImpl")
public class PersonServiceImpl implements PersonService {

    private PersonRepository personRepository;

    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public Person createPerson(Person person) {
        return personRepository.save(person);
    }

    @Override
    public Person updatePerson(Long id, Person person) {
        Person oldPerson = personRepository.findById(id).orElse(null);

        if(oldPerson == null) {
            throw new RuntimeException("person not exist");
        }
        person.setId(oldPerson.getId());
        person = personRepository.save(person);

        return person;
    }

    @Override
    public boolean deletePerson(Long id) {
        Optional<Person> person = personRepository.findById(id);

        if(person.isEmpty()) {
            throw new RuntimeException("id not found");
        }
        personRepository.delete(person.get());
        return true;
    }

    @Override
    public Person findPersonById(Long id) {
        return personRepository.findById(id).orElse(null);
    }

    @Override
    public Set<Person> findPersons() {
        List<Person> persons = personRepository.findAll();
        if(persons.isEmpty()) {
            return  null;
        }
        return persons
                .stream()
                .collect(Collectors.toSet());
    }

    @Override
    public Set<Person> findPersonsByFirstname(String firstname) {
        return personRepository.findByFirstname(firstname);

    }

    @Override
    public Set<Person> findPersonsByLastname(String lastname) {
        return personRepository.findByLastname(lastname);
    }
}
