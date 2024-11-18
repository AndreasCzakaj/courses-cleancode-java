package eu.binarystars.cleancode.functions;

public class Functions {
    void getFullName(String firstName, String lastName, StringBuffer stringBuffer) {
        stringBuffer.append(firstName).append(" ").append(lastName);
    }
}
