package eu.binarystars.cleancode.di.di2;

public class Main {
    public static void main(String[] args) {
        final Main self = new Main();
        self.init();
        self.start();
    }

    void init() {
        DependenciesContainer dependenciesContainer = new DependenciesContainer();
        this.app = dependenciesContainer.createApp();
    }

    App app;
    void start() {
        app.begin();
    }
}
