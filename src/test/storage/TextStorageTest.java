package test.storage;

import geometry2d.Circle;
import geometry2d.Figure;
import org.junit.Test;
import storage.TextStorage;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TextStorageTest {
    @Test
    public void parseCircle() throws IOException, ClassNotFoundException {
        String data = "Circle 3.14";
        Figure circle = TextStorage.parseFigure(data);


        assertEquals(new Circle(3.14), circle);
    }
}
