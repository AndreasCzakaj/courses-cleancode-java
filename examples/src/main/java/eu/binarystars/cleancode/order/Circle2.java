package eu.binarystars.cleancode.order;

class Circle2 {
   Circle2(final double radius) {
        this.radius = radius;
    }

    private final double radius;

    public double area() {
        return this.diameter() * Math.PI;
    }

    private double diameter() {
        return this.radius * 2;
    }
}
