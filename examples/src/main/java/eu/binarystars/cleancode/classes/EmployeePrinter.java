package eu.binarystars.cleancode.classes;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;

public class EmployeePrinter {
    public void print1(List<Employee> employees, Consumer<String> lineConsumer) {
        employees.stream()
                .filter(Objects::nonNull)
                .map(this::toLine1)
                .forEach(lineConsumer);
    }

    private String toLine1(final Employee employee) {
        return String.format("%s (%s)",
                Optional.ofNullable(employee.getName()).orElse("anonymous"),
                Optional.ofNullable(employee.getPosition()).orElse("n.a.")
        );
    }

    public void print2(List<Employee> employees, Consumer<String> lineConsumer) {
        employees.stream()
                .filter(Objects::nonNull)
                .map(this::toLine2)
                .forEach(lineConsumer);
    }

    String toLine2(final Employee employee) {
        return String.format("%s (%s)",
                Optional.ofNullable(employee.getName()).orElse("anonymous"),
                Optional.ofNullable(employee.getPosition()).orElse("n.a.")
        );
    }
}
