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

        try {
            Optional<Person> maybeExistingPerson = dao.get(signUpData.userName);
            if (maybeExistingPerson.isPresent()) {
                throw new IllegalArgumentException("userName: already exists");
            }
            Person person = Person.builder()
                    .userName(signUpData.userName)
                    .passwordHash(signUpData.password) // ToDo: hash tha thang
                    .email(signUpData.email)
                    .build();
            Person savedPerson = dao.save(person);
            return SignUpResult.builder().person(savedPerson).build();
        } catch (IOException e) {
            throw new InternalServerException(e);
        }
    }

    void validateSignUpData(SignUpData signUpData) {
        // check data... throw ValidationException if needed
    }
}
