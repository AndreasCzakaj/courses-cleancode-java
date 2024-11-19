package eu.binarystars.cleancode.functions;

import eu.binarystars.cleancode.classes.EmployeePrinter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class FunctionsTest {
    Functions sut;
    Employee employee;
    Map<String, Map<String, String>> translations = Map.of(
            "en", Map.of("gf", "Managing Director"),
            "de", Map.of("gf", "Geschäftsführer")
    );
    BiFunction<String, String, Optional<String>> translationsProvider;
    List<String> collector;

    @BeforeEach
    void beforeEach() {
        sut = new Functions();
        translationsProvider = (locale, key) -> Optional.ofNullable(translations.get(locale).get(key));
        collector = new ArrayList<>();
    }

    @Test
    void printAddressLine1() {
        sut.printAddressLine1(
                Employee.builder().name("n1").position("gf").build(),
                translationsProvider,
                "en",
                collector::add
        );
        sut.printAddressLine1(
                Employee.builder().name("n2").position("gf").build(),
                translationsProvider,
                "de",
                collector::add
        );
        assertThat(collector).hasSize(2).containsExactly(
                "n1 - Managing Director",
                "n2 - Geschäftsführer"
        );
    }

    @Test
    void printAddressLine2() {
        var employeePrinterEn = new Functions.EmployeePrinter2(
                translationsProvider, "en"
        );
        var employeePrinterDe = new Functions.EmployeePrinter2(
                translationsProvider, "de"
        );

        employeePrinterEn.printAddressLine2(
                Employee.builder().name("n1").position("gf").build(),
                collector::add
        );
        employeePrinterDe.printAddressLine2(
                Employee.builder().name("n2").position("gf").build(),
                collector::add
        );
        assertThat(collector).hasSize(2).containsExactly(
                "n1 - Managing Director",
                "n2 - Geschäftsführer"
        );
    }

    @Test
    void printAddressLine3() {
        Function<String, Optional<String>> translationsProviderEn = (key) -> translationsProvider.apply("en", key);
        Function<String, Optional<String>> translationsProviderDe = (key) -> translationsProvider.apply("de", key);

        sut.printAddressLine3(translationsProviderEn)
            .apply(
                Employee.builder().name("n1").position("gf").build()
            ).accept(collector::add);
        sut.printAddressLine3(translationsProviderDe)
            .apply(
                Employee.builder().name("n2").position("gf").build()
            ).accept(collector::add);
        assertThat(collector).hasSize(2).containsExactly(
                "n1 - Managing Director",
                "n2 - Geschäftsführer"
        );
    }
    @Test
    void printAddressLine4() {
        var printerEn = new Functions.EmployeePrinter4(collector::add, (key) -> translationsProvider.apply("en", key));
        var printerDe = new Functions.EmployeePrinter4(collector::add, (key) -> translationsProvider.apply("de", key));

        printerEn.printAddressLine(Employee.builder().name("n1").position("gf").build());
        printerDe.printAddressLine(Employee.builder().name("n2").position("gf").build());

        assertThat(collector).hasSize(2).containsExactly(
                "n1 - Managing Director",
                "n2 - Geschäftsführer"
        );
    }
}
