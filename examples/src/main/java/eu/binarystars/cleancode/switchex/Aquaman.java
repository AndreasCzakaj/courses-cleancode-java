package eu.binarystars.cleancode.switchex;

import java.util.function.Consumer;

public class Aquaman implements Hero {
    public void useForce(Consumer<String> forceConsumer) {
        forceConsumer.accept("plitsch, platsch");
    }
}
