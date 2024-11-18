package eu.binarystars.cleancode.dao;

import java.io.IOException;
import java.util.Optional;

class SignUpService {
    private final GenericDao<String, Person> dao;
    SignUpService(GenericDao<String, Person> dao) {
        this.dao = dao;
    }

    SignUpResult process(SignUpData signUpData) {
        validateSignUpData(signUpData);
        Person person = new Person(signUpData.email());
        // set fields

        try {
            Optional<Person> maybeExistingPerson = dao.get(signUpData.email());
            if (maybeExistingPerson.isPresent()) {
                throw new IllegalArgumentException("email: already exists");
            }
            Person savedPerson = dao.save(person);
            var out = new SignUpResult();
            // ... fields
            return out;
        } catch (IOException e) {
            throw new InternalServerException(e);
        }
    }

    void validateSignUpData(SignUpData signUpData) {
        // check data... throw ValidationException if needed
    }
}
