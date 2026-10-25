package geometry2d;

import exceptions.IncorrectSizeException;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;
import java.util.Locale;

public class Rectangle implements Figure, Serializable {
    @Serial
    private static final long serialVersionUID = 67;
    private final double length, width;

    public Rectangle(double length, double width) {
        if (length <= 0 || width <= 0) throw new IncorrectSizeException("Side most (wanted) bigger than zero");
        if (Double.isInfinite(length) || Double.isInfinite(width)) throw new IncorrectSizeException("Side can not be infinite");

        this.length = length;
        this.width = width;
    }

    @Override
    public double area() {
        return length * width;
    }

    @Override
    public double perimeter() {
        return 2 * (length + width);
    }

    @Override
    public String toString() {
        return String.format(Locale.US, "Type: Rectangle, Length: %f, Width: %f, Area: %f, Perimeter: %f", length, width, area(), perimeter());
    }

    @Override
    public String toSaveString() {
        return String.format(Locale.US, "Rectangle %f %f", length, width);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rectangle rectangle = (Rectangle) o;
        return Double.compare(length, rectangle.length) == 0 && Double.compare(width, rectangle.width) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(length, width);
    }
}
