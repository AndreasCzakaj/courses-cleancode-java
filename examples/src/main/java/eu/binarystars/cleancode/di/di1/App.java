package eu.binarystars.cleancode.di.di1;

public class App {
    SomeService someService = new SomeService();
    void begin() {
        someService.process();
    }
}
