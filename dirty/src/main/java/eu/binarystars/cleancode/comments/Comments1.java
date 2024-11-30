package eu.binarystars.cleancode.comments;

public class Comments1 {
    void init() {
        // get the port from env or use default
        String portAsString = System.getenv("port");
        final int defaultPort = 8080;
        int port = portAsString == null ? defaultPort : Integer.parseInt(portAsString);

        // start server on given port
        System.out.println(port);
    }
}
