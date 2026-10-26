package geometry2d;

import exceptions.IncorrectSizeException;

import java.io.Serial;
import java.io.Serializable;
import java.util.Locale;

public class Circle implements Figure, Serializable {
    @Serial
    private static final long serialVersionUID = 67;
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
        return String.format(Locale.US, "Type: Circle, Radius: %f, Area: %f, Perimeter: %f", radius, area(), perimeter());
    }

    @Override
    public String toSaveString() {
        return String.format(Locale.US, "Circle %f", radius);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Circle circle = (Circle) o;
        return Double.compare(radius, circle.radius) == 0;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(radius);
    }
}
