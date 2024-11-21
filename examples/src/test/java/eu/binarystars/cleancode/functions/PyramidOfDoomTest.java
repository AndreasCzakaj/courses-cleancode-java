package eu.binarystars.cleancode.functions;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.params.provider.Arguments;

import java.util.Optional;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class PyramidOfDoomTest {

    public static interface MyService {
        String getCompanyName(Person person);
    }

    static class MyServiceDoomImpl implements MyService {
        @Override
        public String getCompanyName(Person person) {
            if (person != null) {
                var company = person.company();
                if (company != null) {
                    if (company.name() != null) {
                        return company.name();
                    }
                }
            }
            return "binary stars GmbH";
        }
    }

    static class MyServiceOptionalsImpl implements MyService {
        @Override
        public String getCompanyName(Person person) {
            return Optional.ofNullable(person)
                    .map(Person::company)
                    .map(Company::name)
                    .orElse("binary stars GmbH");
        }
    }


    @ParameterizedTest(name = "it should yield {2} for person {1} and implementation {0}")
    @MethodSource("pyramidOfDoomParams")
    public void pyramidOfDoom(MyService impl, Person person, String expected) {
        // when
        var actual = impl.getCompanyName(person);
        // then
        assertThat(actual)
                .as(String.format(
                        "it should yield '%s' for person %s and implementation %s",
                        expected, person, impl.getClass().getSimpleName()
                ))
                .isEqualTo(expected);
    }

    static Stream<Arguments> pyramidOfDoomParams() {
        var companyWithoutName  = Company.builder().build();
        var companyNamedAcme    = Company.builder().name("acme").build();

        var personWithoutCompany        = Person.builder().build();
        var personWithoutCompanyName    = Person.builder().company(companyWithoutName).build();
        var personWitCompanyNamedAcme   = Person.builder().company(companyNamedAcme).build();

        var doomImpl = new MyServiceDoomImpl();
        var optsImpl = new MyServiceOptionalsImpl();

        return Stream.of(
                arguments(doomImpl, null,                       "binary stars GmbH"),
                arguments(doomImpl, personWithoutCompany,       "binary stars GmbH"),
                arguments(doomImpl, personWithoutCompanyName,   "binary stars GmbH"),
                arguments(doomImpl, personWitCompanyNamedAcme,  "acme"),
                arguments(optsImpl, null,                       "binary stars GmbH"),
                arguments(optsImpl, personWithoutCompany,       "binary stars GmbH"),
                arguments(optsImpl, personWithoutCompanyName,   "binary stars GmbH"),
                arguments(optsImpl, personWitCompanyNamedAcme,  "acme")
        );
    }

}
