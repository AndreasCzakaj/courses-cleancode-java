package eu.binarystars.cleancode.robot;

public class Robot {

    Robot(Position initialPosition) {
        this.currentPosition = initialPosition;
    }
    private Position currentPosition;
    void moveArm(Vector v, MovementListener listener) {
        //...
    }
}
