package geometry2d;

import exceptions.IncorrectSizeException;

public class Circle implements Figure {
    private final double radius;

    public Circle(double radius) {
        if (radius <= 0) throw new IncorrectSizeException("Radius most (wanted) bigger than zero");
        if (Double.isInfinite(radius)) throw new IncorrectSizeException("Radius can not be infinite");

        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }

    @Override
    public double perimeter() {
        return 2. * Math.PI * radius;
    }

    @Override
    public String toString() {
        return String.format("Type: Circle, Radius: %f, Area: %f, Perimeter: %f", radius, area(), perimeter());
    }
}
