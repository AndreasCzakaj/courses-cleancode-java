package eu.binarystars.cleancode.functions;

import lombok.Builder;

@Builder
public class Person {
    private String name;
    private int age;
    private String email;

    public static class PersonBuilder {
        public Person build() {
            // Custom validation
            if (name == null || name.trim().isEmpty()) {
                throw new IllegalArgumentException("XXX not be null or empty");
            }
            if (age < 0) {
                throw new IllegalArgumentException("Age cannot be negative");
            }

            // Custom logic before building
            if (email != null) {
                email = email.toLowerCase().trim();
            }

            // Call the original build logic
            return new Person(name, age, email);
        }
    }
}