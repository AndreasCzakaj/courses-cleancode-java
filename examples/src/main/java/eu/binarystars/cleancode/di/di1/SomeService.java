package eu.binarystars.cleancode.di.di1;

public class SomeService {
    TheRealDatabase db = new TheRealDatabase();
    void process() {
        db.load();
    }
}
