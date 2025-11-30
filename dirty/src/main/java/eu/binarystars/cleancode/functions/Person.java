package eu.binarystars.cleancode.functions;

import lombok.Builder;

@Builder
public class Person {
    private String name;
    private int age;
    private String email;
}