package cs110.misc;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Objects;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Utils {

    private static final String RESOURCE_ABS_PATH =
        Objects.requireNonNull(Utils.class.getClassLoader().getResource("")).getPath();

    private Utils() {
        // creating an instance of utility class is forbidden
    }

    /**
     * Loads a fxml file to JavaFX scene.
     *
     * @param filename full name (with ext-name) of the '.fxml' file in 'resources'
     * @return scene loaded from the fxml
     * @throws FileNotFoundException if the specified fxml file doesn't exist
     * @throws IOException           if have other trouble opening the fxml file
     */
    public static Scene loadFxml(String filename) throws IOException {
        URL fxml = Utils.class.getClassLoader().getResource(filename);
        if (Objects.isNull(fxml)) {
            throw new FileNotFoundException(filename + " not found in " + RESOURCE_ABS_PATH);
        }
        Parent parent = FXMLLoader.load(fxml);
        return new Scene(parent);
    }

    /**
     * Returns a File for reference.
     *
     * @param filename full name (with ext-name) of file in 'resources'
     * @return a File that could be used to be operated on
     * @throws FileNotFoundException if the file could not be found in 'resources'
     */
    public static File locateResource(String filename) throws FileNotFoundException {
        URL url = Utils.class.getClassLoader().getResource(filename);
        try {
            return new File(Objects.requireNonNull(url).toURI());
        } catch (NullPointerException | URISyntaxException e) {
            throw new FileNotFoundException(filename + " not found in " + RESOURCE_ABS_PATH);
        }
    }
}
