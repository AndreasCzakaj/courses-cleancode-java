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

        Optional<Person> maybeExistingPerson = getPersonFromStorage(signUpData.userName);
        if (maybeExistingPerson.isPresent()) {
            throw new IllegalArgumentException("userName: already exists");
        }
        Person person = Person.builder()
                .userName(signUpData.userName)
                .passwordHash(signUpData.password) // ToDo: hash tha thang
                .email(signUpData.email)
                .build();
        Person savedPerson = savePersonToStorage(person);
        return SignUpResult.builder().person(savedPerson).build();
    }

    Optional<Person> getPersonFromStorage(String userName) {
        try {
            return dao.get(userName);
        } catch (DaoException e) {
            throw new InternalServerException(e);
        }
    }

    Person savePersonToStorage(Person person) {
        try {
            return dao.save(person);
        } catch (DaoException e) {
            throw new InternalServerException(e);
        }
    }

    void validateSignUpData(SignUpData signUpData) {
        // check data... throw ValidationException if needed
    }
}
