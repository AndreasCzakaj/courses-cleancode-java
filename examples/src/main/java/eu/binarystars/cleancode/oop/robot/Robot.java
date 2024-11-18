package eu.binarystars.cleancode.oop.robot;

public class Robot implements Automaton {

    Robot(Position initialPosition) {
        this.currentPosition = initialPosition;
    }

    private Position currentPosition;

    public void move(Vector v, MovementListener listener) {
        //...
    }

    @Override
    public void startup() {

    }

    @Override
    public void shutdown() {

    }
}
