package app;

import geometry2d.Figure;
import geometry3d.Cylinder;
import storage.BinaryStorage;
import storage.Storage;
import storage.TextStorage;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Аргументы не переданы. Выходим.");
            return; // Программа завершится
        }

        Path inputTextFilePath = Path.of(args[0]);
        Path outputBinaryFilePath = Path.of(args[1]);

        Storage textStorage = new TextStorage();
        List<Figure> figures;
        try {
             figures = textStorage.read(inputTextFilePath);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e);
            return;
        }

        for (Figure figure : figures) {
            System.out.println(figure.toString());
        }

        if (figures.isEmpty()) System.out.println("TREWOGA!!! PUSTOI SPISOC");
        else {
            Cylinder cylinder = new Cylinder(figures.get((int) (Math.random() * figures.size())), 67);
            System.out.println(cylinder);
        }

        Storage binaryStorage = new BinaryStorage();
        try {
            binaryStorage.write(outputBinaryFilePath, figures);
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}