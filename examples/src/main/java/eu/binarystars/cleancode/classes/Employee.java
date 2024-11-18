package eu.binarystars.cleancode.classes;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Employee {
    private String name;
    private String position;
}
