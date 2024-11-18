package eu.binarystars.cleancode.di.di2;

public class DependenciesContainer {
    App createApp() {
        TheDatabasePort db = new TheDatabaseAdapter();
        SomeService someService = new SomeService(db);
        return new App(someService);
    }
}
