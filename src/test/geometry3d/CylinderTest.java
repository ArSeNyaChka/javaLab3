package test.geometry3d;

import exceptions.IncorrectSizeException;
import exceptions.NullBaseException;
import geometry2d.Circle;
import geometry2d.Rectangle;
import geometry3d.Cylinder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CylinderTest {
    private static final double EPSILON = 1e-9;

    @Test
    void volumeOfCylinderWithCircleBase() {
        Circle base = new Circle(1.);
        Cylinder cylinder = new Cylinder(base, 2.);

        double expected = Math.PI * 1. * 1. * 2.;
        double actual = cylinder.volume();

        assertEquals(expected, actual, EPSILON);
    }

    @Test
    void volumeOfCylinderWithRectangleBase() {
        Rectangle base = new Rectangle(3., 4.);
        Cylinder cylinder = new Cylinder(base, 5.);

        double expected = 12. * 5.;
        double actual = cylinder.volume();

        assertEquals(expected, actual, EPSILON);
    }

    @Test
    void toStringContainsCorrectData() {
        Circle base = new Circle(2.);
        Cylinder cylinder = new Cylinder(base, 10.);

        String actual = cylinder.toString();

        assertTrue(actual.contains("Cylinder"));
        assertTrue(actual.contains("Base:"));
        assertTrue(actual.contains("Volume:"));
    }

    @Test
    void constructorThrowsOnNullBase() {
        assertThrows(NullBaseException.class, () -> new Cylinder(null, 5.));
    }

    @Test
    void constructorThrowsOnZeroHeight() {
        Circle base = new Circle(1.);
        assertThrows(IncorrectSizeException.class, () -> new Cylinder(base, 0.));
    }

    @Test
    void constructorThrowsOnNegativeHeight() {
        Rectangle base = new Rectangle(2., 3.);
        assertThrows(IncorrectSizeException.class, () -> new Cylinder(base, -1.));
    }

    @Test
    void constructorThrowsOnInfiniteHeight() {
        Circle base = new Circle(1.);
        assertThrows(IncorrectSizeException.class, () -> new Cylinder(base, Double.POSITIVE_INFINITY));
    }
}
