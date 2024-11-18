package eu.binarystars.cleancode.di.di2;

public class SomeService {
    private final TheDatabasePort db;

    SomeService(TheDatabasePort db) {
        this.db = db;
    }

    void process() {
        db.load();
    }
}
