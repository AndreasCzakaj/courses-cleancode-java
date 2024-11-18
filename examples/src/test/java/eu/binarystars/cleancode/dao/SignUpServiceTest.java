package eu.binarystars.cleancode.dao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;


class SignUpServiceTest {
    SignUpService sut;
    Person existingPerson = new Person("i_already_exist@acme.com");

    @BeforeEach
    void beforeEach() throws Exception {
        GenericDaoMapImpl<String, Person> dao = new GenericDaoMapImpl<>(Person::email);
        dao.save(existingPerson);
        sut = new SignUpService(dao);
    }

    @Test
    void shouldFailForDuplicateEmails() {
        // given
        SignUpData signUpData = new SignUpData(existingPerson.email());
        // then
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> sut.process(signUpData));
        assertThat(e.getMessage()).contains("email: already exist");
    }
}
