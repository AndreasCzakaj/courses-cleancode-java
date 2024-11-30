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
        // given
        // when
        // then        
        assertThat(person).usingRecursiveComparison().isEqualTo(
                Person.builder()
                        .coreFirstName("Kim").coreLastName("Gordon").coreState("active")
                        .addrStreetAndNo("Penny Lane").addrZipAndCity("Beverly Bills, 90210").addrState("California")
                .build()
        );
    }
}
