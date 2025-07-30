package eu.binarystars.cleancode.tests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FibonacciLoopImplTest extends FibonacciTestBase {

    @Override
    Fibonacci createFibonacci() {
        return new FibonacciLoopImpl();
    }

    @Test
    public void itShouldPassFor46() {
        Integer index = 46;
        Integer expected = 1_836_311_903;
        assertThat(fibonacci.calc(index)).isEqualTo(expected);
    }
}
