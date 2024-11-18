package eu.binarystars.cleancode.order;

class Circle1 {
    private final double radius;

    private double diameter() {
        return this.radius * 2;
    }

    public double area() {
        return this.diameter() * Math.PI;
    }

    Circle1(final double radius) {
        this.radius = radius;
    }
}
