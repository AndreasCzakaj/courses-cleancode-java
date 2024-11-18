package eu.binarystars.cleancode.switchex;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Stream.of;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class Switch2Test {
    List<String> collector;
    Switch2 sut;

    @BeforeEach
    void beforeEach() {
        sut = new Switch2();
        collector = new ArrayList<>();
    }

    @ParameterizedTest(name = "it should yield {1} for input {1}")
    @MethodSource("shouldGetHeroParams")
    public void useForce(String power, String expected) {
        sut.useForce(power, collector::add);
        assertThat(collector).hasSize(1).containsExactly(expected);
    }

    static Stream<Arguments> shouldGetHeroParams() {
        return of(
                arguments("", "plitsch, platsch"),
                arguments("unknown", "plitsch, platsch"),
                arguments("wind", "blow'em away!"),
                arguments("laser", "burn'em!")
        );
    }
}
