package eu.binarystars.cleancode.oop.robot;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

public class Controller {
    void doItOoStyle(Function<Position, Automaton> factory) {
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

    void startProcedurally(Function<Position, AutomatonDto> factory) {
        var automaton = factory.apply(
                Position.builder().x(1).y(2).z(0).build()
        );

        if (!automaton.started) {
            if (automaton instanceof DroneDto) {
                if (automaton.battery > 4500) {
                    ((DroneDto)automaton).cameraStream = new ArrayList<>();
                    automaton.started = true;
                }
            } else if (automaton instanceof RobotDto) {
                if (automaton.battery > 3500) {
                    // do stuff
                    automaton.started = true;
                }
            }
        }
    }

    // it's easy to add this new function
    void moveProcedurally(Function<Position, AutomatonDto> factory) {
        var automaton = factory.apply(
                Position.builder().x(1).y(2).z(0).build()
        );

        if (automaton.started) {
            if (automaton instanceof DroneDto) {
                // ...
            } else if (automaton instanceof RobotDto) {
                // ...
            }
            // adding a new Dto class will require to add another case
            // to doItProcedurally and all the other functions
            // => just like the car type disaster
        }
    }
}
