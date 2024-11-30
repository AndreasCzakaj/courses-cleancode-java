package eu.binarystars.cleancode.ocp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class MyServiceTest {
    MyService sut;

    @BeforeEach
    void beforeEach() {
        sut = new MyService();
    }

    @Test
    void init() {
        assertThat(sut.magic(null)).isEqualTo("Expelliarmus!");
    }
}
