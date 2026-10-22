package storage;

import geometry2d.Figure;

import java.io.*;
import java.nio.file.Path;
import java.util.List;

public class BinaryStorage implements Storage {

    @Override
    public List<Figure> read(Path path) throws IOException, ClassNotFoundException {
        List<Figure> figures;

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path.toFile()))) {
            figures = (List<Figure>) ois.readObject();
        }

        return figures;
    }

    @Override
    public void write(Path path, List<Figure> figures) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path.toFile()))) {
            oos.writeObject(figures);
        }
    }
}
