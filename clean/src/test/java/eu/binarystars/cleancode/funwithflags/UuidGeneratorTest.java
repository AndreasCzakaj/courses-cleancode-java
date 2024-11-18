package eu.binarystars.cleancode.funwithflags;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.regex.Pattern;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

class UuidGeneratorTest {

    @ParameterizedTest(name = "it should match pattern {1} for case: {2}")
    @MethodSource("createParams")
    public void create(UuidGenerator uuidGenerator, String expectedRegex, String info) {
        // when
        var actual = uuidGenerator.create();

        // then
        assertThat(actual).matches(Pattern.compile(expectedRegex));
    }
    static Stream<Arguments> createParams() {
        return Stream.of(
                Arguments.arguments(new UuidGeneratorNaiveRandomImpl(), "[a-f0-9]{32}", "lower case, no dashes")
                //Arguments.arguments(new ???(), "[A-F0-9]{32}", "upper case, no dashes"),
                //Arguments.arguments(new ???(), "[A-F0-9]{32}", "lower case, with dashes"),
                //Arguments.arguments(new ???(), "[A-F0-9]{32}", "upper case, with dashes")
        );
    }
}
