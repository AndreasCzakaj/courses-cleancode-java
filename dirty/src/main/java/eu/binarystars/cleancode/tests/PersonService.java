package eu.binarystars.cleancode.tests;

import eu.binarystars.cleancode.naming.Person;

import java.util.Optional;

public class PersonService {
    Person signUp(final Person person) {
        if (Optional.ofNullable(person).map(p -> p.coreFirstName).map(String::length).orElse(0) < 2) {
            throw new IllegalArgumentException("First name must be at least 2 characters long");
        }
        person.coreState = "new";
        person.id = "1";
        return person;
    }
}
