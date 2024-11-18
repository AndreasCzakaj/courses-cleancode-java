package eu.binarystars.cleancode.oop.robot;

public interface Automaton {
    void move(Vector v, MovementListener listener);

    void startup();

    void shutdown();

    //void findSarahConnor();
}
