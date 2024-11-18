package eu.binarystars.cleancode.funwithflags;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

public class EmployeePrinter {
    private final Consumer<String> printDelegate;

    EmployeePrinter(Consumer<String> printDelegate) {
        this.printDelegate = printDelegate;
    }

    public void print(List<Employee> employees) {
        Optional.ofNullable(employees)
                .stream()
                .flatMap(List::stream)
                .map(employee -> String.format("%s (%s)", employee.name(), employee.position()))
                .forEach(printDelegate::accept);
        ;
    }
}
