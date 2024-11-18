package eu.binarystars.cleancode.dao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;


class SignUpServiceTest {
    GenericDaoMapImpl<String, Person> dao;
    SignUpService sut;
    Person existingPerson = new Person("i_already_exist@acme.com");
    Person newPerson = new Person("i_am_new@acme.com");

    @BeforeEach
    void beforeEach() throws Exception {
        dao = new GenericDaoMapImpl<>(Person::email);
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

    @Test
    void shouldWork() throws Exception {
        // given
        SignUpData signUpData = new SignUpData(newPerson.email());

        // when
        final var result = sut.process(signUpData);

        // then
        assertThat(result).isNotNull();
        final var actual = dao.get(newPerson.email());
        assertThat(actual).isPresent();
        assertThat(actual.get()).usingDefaultComparator().isEqualTo(newPerson);
    }
}
