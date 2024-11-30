package eu.binarystars.cleancode.naming;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class PersonTest {

    @Test
    void person() {
        var person = new Person();
        person.coreFirstName = "Kim";
        person.coreLastName = "Gordon";
        person.coreState = "active";
        person.addrStreetAndNo = "Penny Lane";
        person.addrZipAndCity = "Beverly Bills, 90210";
        person.addrState = "California";
        
        assertThat(person.coreFirstName).isEqualTo("Kim");
        assertThat(person.coreLastName).isEqualTo("Gordon");
        assertThat(person.coreState).isEqualTo("active");
        assertThat(person.addrStreetAndNo).isEqualTo("Penny Lane");
        assertThat(person.addrZipAndCity).isEqualTo("Beverly Bills, 90210");
        assertThat(person.addrState).isEqualTo("California");
    }
}
