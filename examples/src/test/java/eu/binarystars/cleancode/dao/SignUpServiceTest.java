package eu.binarystars.cleancode.dao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;


class SignUpServiceTest {
    GenericDaoMapImpl<String, Person> dao;
    SignUpService service;

    final String wrongPassword = "wrongpassword";

    final Person existingPerson = Person.builder()
            .userName("i_already_exist")
            .passwordHash("password1")
            .email("i_already_exist@acme.com")
            .build();

    final Person newPerson = Person.builder()
            .userName("i_am_new")
            .passwordHash("password2")
            .email("i_am_new@acme.com")
            .build();

    @BeforeEach
    void beforeEach() throws Exception {
        dao = new GenericDaoMapImpl<>(person -> person.userName);
        dao.save(existingPerson);
        initService();
    }

    void initService() {
        service = new SignUpService(dao);
    }

    @Test
    void shouldFailForDuplicateEmails() {
        // given
        SignUpData signUpData = SignUpData.builder().userName(existingPerson.userName).build();
        // then
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> service.process(signUpData));
        assertThat(e.getMessage()).contains("email: already exist");
    }

    @Test
    void shouldWork() throws Exception {
        // given
        SignUpData signUpData = SignUpData.builder()
                .userName(newPerson.userName)
                .password(newPerson.passwordHash)
                .email(newPerson.email)
                .build();

        // when
        final var result = service.process(signUpData);

        // then
        assertThat(result).isNotNull();
        final var actual = dao.get(newPerson.userName);
        assertThat(actual).isPresent();
        assertThat(actual.get()).usingRecursiveComparison().isEqualTo(newPerson);
    }
}
