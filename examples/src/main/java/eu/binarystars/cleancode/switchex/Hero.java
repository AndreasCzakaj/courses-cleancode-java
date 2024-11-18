package eu.binarystars.cleancode.switchex;


import java.util.function.Consumer;

public interface Hero {
    void useForce(Consumer<String> forceConsumer);
}
