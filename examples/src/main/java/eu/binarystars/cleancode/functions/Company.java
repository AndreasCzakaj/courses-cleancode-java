package eu.binarystars.cleancode.functions;

import lombok.*;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;

import java.beans.ConstructorProperties;

@Accessors(chain = true, fluent = true)
@Getter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
public class Company {
    String name;
}
