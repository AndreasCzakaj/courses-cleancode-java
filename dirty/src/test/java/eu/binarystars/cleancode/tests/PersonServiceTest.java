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

    @Test
    void shouldSignUpValidPerson() {
        // given
        var person = new Person();
        person.coreFirstName = "CJ";
        person.coreLastName = "Ramone";

        // when
        var signedUpPerson = sut.signUp(person);

        // then
        assertThat(signedUpPerson.coreFirstName).isEqualTo(person.coreFirstName);
        assertThat(signedUpPerson.coreLastName).isEqualTo(person.coreLastName);
        assertThat(signedUpPerson.coreState).isEqualTo("new"); // or expected.coreState
        assertThat(signedUpPerson.id).matches(Pattern.compile("[0-9]{1,1}"));
    }

    @Test
    void shouldThrowErrorWhenSigningUpInvalidPerson() {
        // given
        var person = new Person();
        person.coreFirstName = "P";
        person.coreLastName = "Ramone";

        // when
        ThrowableAssert.ThrowingCallable action = () -> sut.signUp(person);

        // then
        assertThatThrownBy(action)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("First name must be at least 2 characters long")
                .hasNoCause();
    }
}
