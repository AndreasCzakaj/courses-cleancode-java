package eu.binarystars.cleancode.funwithflags;

import lombok.Builder;
import lombok.Getter;
import lombok.experimental.Accessors;

@Getter
@Builder
@Accessors(fluent = true, chain = true)
public class Employee {
    private String name;
    private String position;
}
