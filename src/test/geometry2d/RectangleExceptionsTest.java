package test.geometry2d;

import exceptions.IncorrectSizeException;
import geometry2d.Rectangle;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RectangleExceptionsTest {

    @Test
    void constructorThrowsOnNegativeLength() {
        assertThrows(IncorrectSizeException.class, () -> new Rectangle(-1., 5.));
    }

    @Test
    void constructorThrowsOnNegativeWidth() {
        assertThrows(IncorrectSizeException.class, () -> new Rectangle(5., -3.));
    }

    @Test
    void constructorThrowsOnZeroLength() {
        assertThrows(IncorrectSizeException.class, () -> new Rectangle(0., 5.));
    }

    @Test
    void constructorThrowsOnZeroWidth() {
        assertThrows(IncorrectSizeException.class, () -> new Rectangle(5., 0.));
    }

    @Test
    void constructorThrowsOnInfiniteLength() {
        assertThrows(IncorrectSizeException.class, () -> new Rectangle(Double.POSITIVE_INFINITY, 5.));
    }

    @Test
    void constructorThrowsOnInfiniteWidth() {
        assertThrows(IncorrectSizeException.class, () -> new Rectangle(5., Double.NEGATIVE_INFINITY));
    }

    @Test
    void constructorThrowsOnBothSidesZero() {
        assertThrows(IncorrectSizeException.class, () -> new Rectangle(0., 0.));
    }
}
