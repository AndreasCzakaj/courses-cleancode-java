package eu.binarystars.cleancode.di.di2;

public class App {
    App(SomeService someService) {
        this.someService = someService;
    }
    SomeService someService;

    void begin() {
        someService.process();
    }
}
