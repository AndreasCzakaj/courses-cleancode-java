package eu.binarystars.cleancode.comments;

public class Comments {
    void init() {
        // get the port
        final String defaultPortAsString = "8080";
        // Admin spelled the env param wrong, and we can't change it
        String portAsString = System.getenv("prot");
        int port = Integer.parseInt(portAsString == null ? defaultPortAsString : portAsString);

        // start server on given port
        System.out.println(port);
    }
}
