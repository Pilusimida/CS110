package cs110.control;

import cs110.Context;
import cs110.model.TextData;
import javafx.fxml.FXML;
import javafx.scene.web.WebView;

public class TextViewerController implements DataDisplayController {

    @FXML
    private WebView content;

    @Override
    public void update() {
        TextData dataSource = Context.INSTANCE.getTextDataSource();
        String textContent = dataSource.getText();
        content.getEngine().loadContent(textContent);
    }
}
