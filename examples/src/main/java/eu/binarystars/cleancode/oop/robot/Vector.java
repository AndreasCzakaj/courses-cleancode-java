package eu.binarystars.cleancode.oop.robot;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Vector {
    public int x;
    public int y;
    public int z;
}
