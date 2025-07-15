package eu.binarystars.cleancode.oop.robot;

import java.util.ArrayList;
import java.util.function.Function;

public class ControllerProceduralImpl {
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
