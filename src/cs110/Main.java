package cs110;

import cs110.control.TextViewerController;
import cs110.misc.ConvenientStage;
import cs110.misc.Utils;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage mainPage) throws Exception {
        mainPage.setScene(Utils.loadFxml("view/MainPage.fxml"));
        mainPage.setTitle("JavaFX Multi Stage Application Demo");
        Context.INSTANCE.setMainPage(mainPage);

        ConvenientStage<TextViewerController> textViewer = new ConvenientStage<>("view/TextViewer.fxml");
        textViewer.setTitle("Text Viewer");
        Context.INSTANCE.setTextViewer(textViewer);

        mainPage.show();
    }
}
