package eu.binarystars.cleancode.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.function.Supplier;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FibonacciTest {
    Fibonacci fibonacci;

    @BeforeEach
    void setUp() {
        fibonacci = new Fibonacci();
    }

    @Test
    @Disabled("todo")
    void itShouldYield0ForIndex0() {
        // given
        Integer index = 0;
        Integer expected = 0;

        // when
        Integer actual = fibonacci.calc(index);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @Disabled("todo")
    void itShouldThrowForIndexNull() {
        // given
        Integer index = null;
        String expected = "Index must not be null";

        // when/then
        IllegalArgumentException e = assertThrows(
                IllegalArgumentException.class,
                () -> fibonacci.calc(index)
        );

        // then
        //assertThat(???).isEqualTo(???);
    }

    @Test
    @Disabled("todo")
    void shouldYield1ForIndex1() {
    }

    @Test
    @Disabled("todo")
    void shouldYield1ForIndex2() {
    }

    @Test
    @Disabled("todo")
    void shouldYield2ForIndex3() {
    }


    @Test
    @Disabled("todo")
    void shouldYield8ForIndex6() {
    }


    @Test
    @Disabled("todo")
    void shouldYield102334155ForIndex40() {
    }

    @Test
    @Disabled("todo")
    void itShouldThrowForNegativeIndex() {
    }

    @Test
    @Disabled("todo")
    void itShouldThrowForIndexGreaterThan46() {
    }






























    @ParameterizedTest(name = "it should yield {1} for input {0}")
    @MethodSource("passParams")
    @Disabled
    public void itShouldPass(Integer input, Integer expected) {
    }

    static Stream<Arguments> passParams() {
        return Stream.of(
                Arguments.arguments(0, 0),
                Arguments.arguments(1, 1),
                Arguments.arguments(2, 1),
                Arguments.arguments(3, 2),
                Arguments.arguments(4, 3),
                Arguments.arguments(5, 5),
                Arguments.arguments(6, 8),
                Arguments.arguments(10, 55),
                Arguments.arguments(40, 102_334_155),
                Arguments.arguments(46, 1_836_311_903)
        );
    }

    @ParameterizedTest(name = "it should throw IllegalArgumentException with message \"{1}\" for input {0}")
    @MethodSource("throwParams")
    @Disabled
    public void itShouldThrow(Integer input, String expectedMessage) {
    }

    static Stream<Arguments> throwParams() {
        return Stream.of(
                Arguments.arguments(null, "Index must not be null"),
                Arguments.arguments(-1, "Index must be positive integer"),
                Arguments.arguments(47, "Index only allowed up to 46")
        );
    }
}
