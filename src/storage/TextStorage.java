package storage;

import geometry2d.Circle;
import geometry2d.Figure;
import geometry2d.Rectangle;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class TextStorage implements Storage {

    private Figure parseFigure(String str) throws ClassNotFoundException, IOException {
        String[] words = str.replace(",", "").split("\\s+");
        try {
            if (Objects.equals(words[1], "Circle"))
                return new Circle(Double.parseDouble(words[3]));
            if (Objects.equals(words[1], "Rectangle"))
                return new Rectangle(Double.parseDouble(words[3]), Double.parseDouble(words[5]));
        } catch (IndexOutOfBoundsException e) {
            throw new IOException();
        }
        throw new ClassNotFoundException();
    }

    @Override
    public List<Figure> read(Path path) throws IOException, ClassNotFoundException {
        List<Figure> figures = new ArrayList<>();

        try (Scanner scanner = new Scanner(path, StandardCharsets.UTF_8)) {
            while (scanner.hasNextLine()) {
                figures.add(parseFigure(scanner.nextLine()));
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
        Files.write(path, "".getBytes());  // Clear file

        for (Figure figure : figures) {
            Files.writeString(path, figure.toString(), StandardCharsets.UTF_8, StandardOpenOption.APPEND);
        }
    }
}
