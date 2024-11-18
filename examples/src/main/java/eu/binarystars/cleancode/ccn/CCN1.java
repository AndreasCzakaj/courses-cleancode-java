package eu.binarystars.cleancode.ccn;

public class CCN1 {
    int getPort() {
        String portAsString = System.getenv("port");
        if (portAsString != null) {
            try {
                return Integer.parseInt(portAsString);
            } catch (NumberFormatException e) {
                return 8080;
            }
        }
        return 8080;
    }
}
