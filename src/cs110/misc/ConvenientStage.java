package cs110.misc;

import java.io.IOException;
import java.net.URL;

import cs110.control.DataDisplayController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lombok.Getter;

@Getter
public class ConvenientStage<T> extends Stage {

    private final T controller;

    public ConvenientStage(String filename) throws IOException {
        URL fxml = getClass().getClassLoader().getResource(filename);
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(fxml);
        Scene scene = new Scene(fxmlLoader.load());

        super.setScene(scene);
        this.controller = fxmlLoader.getController();
    }

    public DataDisplayController getController() {
        return (DataDisplayController) this.controller;
    }
}
