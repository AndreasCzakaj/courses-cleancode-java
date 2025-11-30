package eu.binarystars.cleancode.funwithflags;

import java.security.SecureRandom;
import java.util.Collections;
import java.util.Random;
import java.util.stream.IntStream;

public class UuidGeneratorNaiveRandomImpl implements UuidGenerator {
    private static final Random RANDOM = new SecureRandom();

    public String create() {
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 32; i++) {
            sb.append(createOne());
        }
        return sb.toString();
    }
    
    String createOne() {
        return Integer.toHexString(RANDOM.nextInt(16));
    }
}
