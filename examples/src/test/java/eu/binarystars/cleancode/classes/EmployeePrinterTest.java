package eu.binarystars.cleancode.classes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class EmployeePrinterTest {
    List<String> collector;
    EmployeePrinter sut;

    @BeforeEach
    void beforeEach() {
        collector = new ArrayList<>();
        sut = new EmployeePrinter();
    }

    @ParameterizedTest
    @MethodSource("print1OneParams")
    void print1One(Employee employee, String expected) {
        sut.print1(List.of(employee), collector::add);
        assertThat(collector).hasSize(1).contains(expected);
    }

    static Stream<Arguments> print1OneParams() {
        return Stream.of(
                Arguments.arguments(Employee.builder().name("n1").position("p1").build(), "n1 (p1)"),
                Arguments.arguments(Employee.builder().name(null).position("p1").build(), "anonymous (p1)"),
                Arguments.arguments(Employee.builder().name("n1").position(null).build(), "n1 (n.a.)"),
                Arguments.arguments(Employee.builder().name(null).position(null).build(), "anonymous (n.a.)")
        );
    }

    @ParameterizedTest
    @MethodSource("print1OneParams")
    void toLine2(Employee employee, String expected) {
        assertThat(sut.toLine2(employee)).isEqualTo(expected);
    }
}
