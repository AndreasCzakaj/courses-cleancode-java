package eu.binarystars.cleancode.oop.robot;

import java.util.EventListener;
import java.util.function.Consumer;

public interface MovementListener extends EventListener {
    void onCompleted(Consumer<Position> newPosition);
}
