package test.geometry2d;

import exceptions.IncorrectSizeException;
import geometry2d.Circle;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CircleTest {
    private static final double EPSILON = 1e-9;

    @Test
    void areaOfCircleWithRadius5() {
        Circle circle = new Circle(5.);

        double actual = circle.area();

        assertEquals(Math.PI * 25., actual, EPSILON);
    }

    @Test
    void areaOfCircleWithRadius1() {
        Circle circle = new Circle(1.);

        double actual = circle.area();

        assertEquals(Math.PI, actual, EPSILON);
    }

    @Test
    void perimeterOfCircleWithRadius5() {
        Circle circle = new Circle(5.);

        double actual = circle.perimeter();

        assertEquals(2. * Math.PI * 5., actual, EPSILON);
    }

    @Test
    void perimeterOfCircleWithRadius1() {
        Circle circle = new Circle(1.);

        double actual = circle.perimeter();

        assertEquals(2. * Math.PI, actual, EPSILON);
    }

    @Test
    void toSaveStringForCircle() {
        Circle circle = new Circle(3.5);

        String actual = circle.toSaveString();

        assertEquals("Circle 3.500000", actual);
    }

    @Test
    void toStringContainsCorrectData() {
        Circle circle = new Circle(2.);

        String actual = circle.toString();

        assertTrue(actual.contains("Circle"));
        assertTrue(actual.contains("2.000000"));
        assertTrue(actual.contains("Area:"));
        assertTrue(actual.contains("Perimeter:"));
    }

    @Test
    void constructorThrowsOnNegativeRadius() {
        assertThrows(IncorrectSizeException.class, () -> new Circle(-1.));
    }

    @Test
    void constructorThrowsOnZeroRadius() {
        assertThrows(IncorrectSizeException.class, () -> new Circle(0.));
    }

    @Test
    void constructorThrowsOnInfiniteRadius() {
        assertThrows(IncorrectSizeException.class, () -> new Circle(Double.POSITIVE_INFINITY));
    }
}
