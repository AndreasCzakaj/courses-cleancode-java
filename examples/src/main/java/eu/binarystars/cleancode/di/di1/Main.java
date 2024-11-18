package eu.binarystars.cleancode.di.di1;

public class Main {
    public static void main(String[] args) {
        final Main self = new Main();
        self.init();
        self.start();
    }

    void init() {}

    App app;
    void start() {
        app = new App();
        app.begin();
    }
}
