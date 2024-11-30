package eu.binarystars.cleancode.naming;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    String coreFirstName;
    String coreLastName;
    String coreState;
    String addrStreetAndNo;
    String addrZipAndCity;
    String addrState;

}
