package de.uni.siegen.springDemo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.StringJoiner;

@Entity
public class Person implements Serializable {
    @Id
    private Long id;
    @Column(length=50, nullable=false)
    private String lastname;
    @Column(length=50, nullable=false)
    private String firstname;

    public Person() {}

    public Person(Long id, String lastname, String firstname) {
        this.id = id;
        this.lastname = lastname;
        this.firstname = firstname;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Person.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("lastname='" + lastname + "'")
                .add("firstname='" + firstname + "'")
                .toString();
    }
}
