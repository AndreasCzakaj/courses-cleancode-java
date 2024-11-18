package eu.binarystars.cleancode.switchex;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static java.util.stream.Stream.of;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class SwitchTest {
    Switch sut;

    @BeforeEach
    void beforeEach() {
        sut = new Switch();
    }

    @ParameterizedTest(name = "it should yield {1} for input {1}")
    @MethodSource("shouldGetHeroParams")
    public void shouldGetHero1(String power, String expected) {
        Assertions.assertThat(sut.getHero(power)).isEqualTo(expected);
    }
    
    @ParameterizedTest(name = "it should yield {1} for input {1}")
    @MethodSource("shouldGetHeroParams")
    public void shouldGetHero2(String power, String expected) {
        Assertions.assertThat(sut.getHero2(power)).isEqualTo(expected);
    }

    static Stream<Arguments> shouldGetHeroParams() {
        Switch sut = new Switch();
        return of(
                arguments("", "Aquaman"),
                arguments("unknown", "Aquaman"),
                arguments("wind", "Storm"),
                arguments("laser", "Cyclops")
        );
    }
}
