package eu.binarystars.cleancode.ccn;

public class CCN2 {
    int getPort() {
        String portAsString = System.getenv("port");
        if (portAsString == null) {
            return 8080;
        }
        try {
            return Integer.parseInt(portAsString);
        } catch (NumberFormatException e) {
             return 8080;
        }
    }
}
