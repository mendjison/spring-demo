package de.uni.siegen.springDemo.web;

import de.uni.siegen.springDemo.model.Person;
import de.uni.siegen.springDemo.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping(path = "api/persons")
public class PersonController {

    @Autowired
    private PersonService personService;
    
    @PostMapping(consumes = "application/json", produces = "application/json")
    public Person save(@RequestBody  Person person) {
        return  personService.createPerson(person);
    }

    @PutMapping(path = "/{id}", consumes = "application/json", produces = "application/json")
    public Person update(@RequestBody  Person person, @PathVariable(name = "id") Long personId) {
        return  personService.updatePerson(personId, person);
    }

    @DeleteMapping(path = "/{id}")
    public boolean update( @PathVariable(name = "id") Long personId) {
        return  personService.deletePerson(personId);
    }

    @GetMapping
    public Set<Person> findPersons() {
        return  personService.findPersons();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Person> findById(@PathVariable(name = "id") Long personId) {

        return  ResponseEntity
                .accepted()
                .body(personService.findPersonById(personId));
    }

    @GetMapping(path = "/lastname")
    public ResponseEntity<Set<Person>> findByLastname(@RequestParam("lastname") String lastname) {

        return  ResponseEntity
                .accepted()
                .body(personService.findPersonsByLastname(lastname));
    }

    @GetMapping(path = "/firstname/{firstname}")
    public ResponseEntity<Set<Person>> findByFirstname(@PathVariable(name = "firstname") String firstname) {

        return  ResponseEntity
                .accepted()
                .body(personService.findPersonsByFirstname(firstname));
    }

}
