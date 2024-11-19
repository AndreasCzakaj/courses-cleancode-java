package eu.binarystars.cleancode.functions;

import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

public class Functions {
    void getFullName(String firstName, String lastName, StringBuffer stringBuffer) {
        stringBuffer.append(firstName).append(" ").append(lastName);
    }


    // unclean with 4 args
    void printAddressLine1(Employee employee, BiFunction<String, String, Optional<String>> translationProvider, String language, Consumer<String> printConsumer) {
        final var positionKey = employee.getPosition();
        final var sb = new StringBuilder();
        sb.append(employee.getName());
        translationProvider.apply(language, positionKey).ifPresent(s -> sb.append(" - ").append(s));
        printConsumer.accept(sb.toString());
    }

    // extracted to class
    static class EmployeePrinter2 {
        private final BiFunction<String, String, Optional<String>> translationProvider;
        private final String language;

        EmployeePrinter2(BiFunction<String, String, Optional<String>> translationProvider, String language) {
            this.translationProvider = translationProvider;
            this.language = language;
        }

        void printAddressLine2(Employee employee, Consumer<String> printConsumer) {
            final var rawTitle = employee.getPosition();
            final var sb = new StringBuilder();
            sb.append(employee.getName());
            translationProvider.apply(language, rawTitle).ifPresent(s -> sb.append(" - ").append(s));
            printConsumer.accept(sb.toString());
        }
    }

    // extracted to lambdas
    Function<Employee, Consumer<Consumer<String>>> printAddressLine3(Function<String, Optional<String>> translationProvider) {
        return (employee) -> {
            return (printConsumer) -> {
                final var positionKey = employee.getPosition();
                final var sb = new StringBuilder();
                sb.append(employee.getName());
                translationProvider.apply(positionKey).ifPresent(s -> sb.append(" - ").append(s));
                printConsumer.accept(sb.toString());
            };
        };
    }


    // extracted to class
    static class EmployeePrinter4 {
        private final Consumer<String> printConsumer;
        private final Function<String, Optional<String>> translationProvider;

        EmployeePrinter4(Consumer<String> printConsumer, Function<String, Optional<String>> translationProvider) {
            this.printConsumer = printConsumer;
            this.translationProvider = translationProvider;
        }

        void printAddressLine(Employee employee) {
            final var rawTitle = employee.getPosition();
            final var sb = new StringBuilder();
            sb.append(employee.getName());
            translationProvider.apply(rawTitle).ifPresent(s -> sb.append(" - ").append(s));
            printConsumer.accept(sb.toString());
        }
    }

}
