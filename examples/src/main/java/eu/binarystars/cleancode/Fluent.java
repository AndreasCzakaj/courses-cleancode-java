package eu.binarystars.cleancode;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Builder(toBuilder = true)
public class Fluent {
    public final String color;
    public final int height;

}
