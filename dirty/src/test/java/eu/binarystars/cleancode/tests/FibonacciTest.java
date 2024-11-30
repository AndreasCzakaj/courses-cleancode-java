package eu.binarystars.cleancode.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class FibonacciTest {
    FibonacciLoopImpl fibonacci;

    @BeforeEach
    void setUp() {
        fibonacci = new FibonacciLoopImpl();
    }


    @Test
    void negatives() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> fibonacci.calc(-1));
        assertThat(e.getMessage()).contains("negative indices not allowed for Fibonacci");
    }

    @Test
    void outOfBounds() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> fibonacci.calc(47));
        assertThat(e.getMessage()).contains("only supported for index <= 46");
    }

    void shouldYieldNullForNull() {
        Integer index = null;
        Integer expected = null;
        Integer actual = fibonacci.calc(index);
        assertThat(actual).isEqualTo(expected);
    }

    void shouldYield0For0() {
        Integer index = 0;
        Integer expected = 0;
        Integer actual = fibonacci.calc(index);
        assertThat(actual).isEqualTo(expected);
    }

    void shouldYield1For1() {
        Integer index = 1;
        Integer expected = 1;
        Integer actual = fibonacci.calc(index);
        assertThat(actual).isEqualTo(expected);
    }

    void shouldYield6For8() {
        Integer index = 6;
        Integer expected = 8;
        Integer actual = fibonacci.calc(index);
        assertThat(actual).isEqualTo(expected);
    }
}
