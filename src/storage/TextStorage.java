package storage;

import geometry2d.Circle;
import geometry2d.Figure;
import geometry2d.Rectangle;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class TextStorage implements Storage {
    public static Figure parseFigure(String str) throws ClassNotFoundException, IOException {
        String[] words = str.split("\\s+");
        try {
            if (Objects.equals(words[0], "Circle"))
                return new Circle(Double.parseDouble(words[1]));
            if (Objects.equals(words[0], "Rectangle"))
                return new Rectangle(Double.parseDouble(words[1]), Double.parseDouble(words[2]));
        } catch (IndexOutOfBoundsException e) {
            throw new IOException("Incorrect save format: " + str);
        }
        throw new ClassNotFoundException("Netu Takogo klassa: " + words[0]);
    }

    @Override
    public List<Figure> read(Path path) throws IOException, ClassNotFoundException {
        List<Figure> figures = new ArrayList<>();

        try (Scanner scanner = new Scanner(path, StandardCharsets.UTF_8)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().strip();
                if (Objects.equals(line, "")) continue;

                figures.add(parseFigure(line));
            }

            IOException readError = scanner.ioException();
            if (readError != null) {
                throw readError;
            }
        }
        return figures;
    }

    @Override
    public void write(Path path, List<Figure> figures) throws IOException {
        StringBuilder content = new StringBuilder();

        for (Figure figure : figures) {
            content.append(figure.toSaveString()).append("\n");  // COPYRIGHT: Захару запрещается воровать эту строчку кода
        }

        Files.writeString(path, content, StandardCharsets.UTF_8);
    }
}
