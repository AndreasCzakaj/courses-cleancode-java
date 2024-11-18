package eu.binarystars.cleancode.oop.robot;

import lombok.Builder;
import lombok.Getter;

public abstract class AutomatonDto {
    boolean started = false;
    Position currentPosition;
    int battery;
}
