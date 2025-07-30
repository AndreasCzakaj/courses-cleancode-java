package eu.binarystars.cleancode.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

abstract class FibonacciTestBase {
    Fibonacci fibonacci;

    @BeforeEach
    void setUp() {
        fibonacci = createFibonacci();
    }

    abstract Fibonacci createFibonacci();

    @ParameterizedTest(name = "it should yield {1} for index {0}")
    @MethodSource("passParams")
    public void itShouldPass(Integer index, Integer expected) {
        assertThat(fibonacci.calc(index)).isEqualTo(expected);
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
                Arguments.arguments(40, 102_334_155)/*,
                Arguments.arguments(46, 1_836_311_903)*/
        );
    }


    @ParameterizedTest(name = "it should throw IllegalArgumentException with message \"{1}\" for index {0}")
    @MethodSource("throwParams")
    public void itShouldThrow(Integer index, String expectedMessage) {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> fibonacci.calc(index));
        assertThat(thrown.getMessage()).isEqualTo(expectedMessage);
    }

    static Stream<Arguments> throwParams() {
        return Stream.of(
                Arguments.arguments(null, "Index must not be null"),
                Arguments.arguments(-1, "Index must be positive integer"),
                Arguments.arguments(47, "Index only allowed up to 46")
        );
    }
}
