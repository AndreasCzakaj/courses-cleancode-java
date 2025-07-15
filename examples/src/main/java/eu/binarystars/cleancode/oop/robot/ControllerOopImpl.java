package eu.binarystars.cleancode.oop.robot;

import java.util.ArrayList;
import java.util.function.Function;

public class ControllerOopImpl {
    void doIt(Function<Position, Automaton> factory) {
        var automaton = factory.apply(
                Position.builder().x(1).y(2).z(0).build()
        );

        // this works for all implementations
        // adding a new Automaton implementation is non-breaking
        automaton.startup();
        automaton.move(Vector.builder().x(2).y(7).z(1).build(), newPosition -> {});
        automaton.shutdown();

        // but adding a new method to the interface
        // will break all existing impl classes
    }

}
