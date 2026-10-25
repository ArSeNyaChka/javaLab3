package test.geometry2d;

import geometry2d.Rectangle;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RectangleToStringTest {

    @Test
    void toStringContainsCorrectType() {
        Rectangle rect = new Rectangle(3., 4.);

        String actual = rect.toString();

        assertTrue(actual.contains("Type: Rectangle"));
    }

    @Test
    void toStringContainsLengthAndWidth() {
        Rectangle rect = new Rectangle(3., 4.);

        String actual = rect.toString();

        assertTrue(actual.contains("Length: 3.000000"));
        assertTrue(actual.contains("Width: 4.000000"));
    }

    @Test
    void toStringContainsAreaAndPerimeter() {
        Rectangle rect = new Rectangle(3., 4.);

        String actual = rect.toString();

        assertTrue(actual.contains("Area: 12.000000"));
        assertTrue(actual.contains("Perimeter: 14.000000"));
    }

    @Test
    void toSaveStringForRectangle() {
        Rectangle rect = new Rectangle(3., 4.);

        String actual = rect.toSaveString();

        assertEquals("Rectangle 3.000000 4.000000", actual);
    }
}
