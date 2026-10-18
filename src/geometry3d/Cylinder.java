package geometry3d;

import exceptions.IncorrectSizeException;
import exceptions.NullBaseException;
import geometry2d.Figure;

public class Cylinder {
    private final Figure base;
    private final double height;

    public Cylinder(Figure base, double height) {
        if (height <= 0) throw new IncorrectSizeException("Height most (wanted) bigger than zero");
        if (Double.isInfinite(height)) throw new IncorrectSizeException("Height can not be infinite");
        if (base == null) throw new NullBaseException("Cylinder base most (wanted) not be null");

        this.base = base;
        this.height = height;
    }

    public double volume() {
        return base.area() * height;
    }

    @Override
    public String toString() {
        return String.format("Type: Cylinder, Height: %f, Base: { %s }, Volume: %f", height, base.toString(), volume());
    }
}
