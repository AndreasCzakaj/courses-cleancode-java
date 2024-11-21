package eu.binarystars.cleancode.oop.robot;

import lombok.Builder;

@Builder(toBuilder = true)
public class Position {
    public int x;
    public int y;
    public int z;
}
