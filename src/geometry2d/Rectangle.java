package geometry2d;

import exceptions.IncorrectSizeException;

public class Rectangle implements Figure {
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
        return String.format("Type: Rectangle, Length: %f, Width: %f, Area: %f, Perimeter: %f", length, width, area(), perimeter());
    }
}
