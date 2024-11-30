package eu.binarystars.cleancode.tests;

import eu.binarystars.cleancode.naming.Person;
import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.function.Supplier;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.*;

class PersonServiceTest {
    PersonService sut;

    @BeforeEach
    void beforeEach() {
        sut = new PersonService();
    }

    static Person createValidPerson() {
        var person = new Person();
        person.coreFirstName = "CJ";
        person.coreLastName = "Ramone";
        return person;
    }

    @Test
    void shouldSignUpValidPerson() {
        // given
        var person = createValidPerson();

        // when
        var signedUpPerson = sut.signUp(person);

        // then
        expectSignedUpUser(signedUpPerson, person);
    }

    private static void expectSignedUpUser(final Person actual, final Person expected) {
        assertThat(actual.coreFirstName).isEqualTo(expected.coreFirstName);
        assertThat(actual.coreLastName).isEqualTo(expected.coreLastName);
        assertThat(actual.coreState).isEqualTo("new"); // or expected.coreState
        assertThat(actual.id).matches(Pattern.compile("[0-9]{1,1}"));
    }

    @Test
    void shouldThrowErrorWhenSigningUpInvalidPerson() {
        // given
        var person = createValidPerson();
        person.coreFirstName = "P";

        // when
        ThrowableAssert.ThrowingCallable action = () -> sut.signUp(person);

        // then
        assertThatThrownBy(action)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("First name must be at least 2 characters long")
                .hasNoCause();
    }
}
