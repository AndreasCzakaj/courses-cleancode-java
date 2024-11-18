package eu.binarystars.cleancode.funwithflags;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

class EmployeePrinterTest {
    EmployeePrinter sut;
    List<String> collector;

    @BeforeEach
    void beforeEach() {
        collector = new ArrayList<>();
        Consumer<String> consumer = collector::add;
        sut = new EmployeePrinter(consumer);
    }

    @Test
    void shouldPrintNothingIfListIsNull() {
        sut.print(null);
        assertThat(collector).hasSize(0);
    }

    @Test
    void shouldPrintNothingIfListIsEmpty() {
        sut.print(List.of());
        assertThat(collector).hasSize(0);
    }

    @Test
    void shouldPrintOne() {
        sut.print(List.of(
                Employee.builder().name("n1").position("p1").build()
        ));
        assertThat(collector)
                .hasSize(1)
                .containsExactly("n1 (p1)");
    }

    @Test
    void shouldPrintTwo() {
        sut.print(List.of(
                Employee.builder().name("n1").position("p1").build(),
                Employee.builder().name("n2").position("p2").build()
        ));
        assertThat(collector)
                .hasSize(2)
                .containsExactly(
                        "n1 (p1)",
                        "n2 (p2)"
                );
    }
}
