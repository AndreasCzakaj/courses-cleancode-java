package eu.binarystars.cleancode.switchex;

import java.util.function.Consumer;

public class Cyclops implements Hero {
    public void useForce(Consumer<String> forceConsumer) {
        forceConsumer.accept("burn'em!");
    }
}
