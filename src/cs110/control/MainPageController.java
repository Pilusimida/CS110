package cs110.control;

import cs110.Context;
import cs110.misc.ConvenientStage;
import cs110.misc.Utils;
import cs110.model.CsvData;
import cs110.model.TextData;
import java.io.File;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.MenuItem;
import javafx.scene.text.Text;

public class MainPageController {

    @FXML
    private MenuItem showTextMenu;

    @FXML
    private MenuItem showTableMenu;

    @FXML
    private Text csvIndicator;

    @FXML
    private Text txtIndicator;


    public void showTextPopup(ActionEvent actionEvent) {
        ConvenientStage<TextViewerController> textViewer = Context.INSTANCE.getTextViewer();
        textViewer.getController().update();
        textViewer.show();
    }

    public void showTableStage(ActionEvent actionEvent) {
        //用于展示表格界面，其实就是把原textviewer的搬过来（读取文件内容）
        ConvenientStage<TextViewerController> textViewer = Context.INSTANCE.getTextViewer();
        textViewer.getController().update();
        textViewer.show();
    }

    public void showHelp(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Demo for CS110 Project. SUSTech, 2022 Fall.");
        alert.show();
    }

    public void loadTopSellers(ActionEvent actionEvent) throws IOException {
        System.out.println("loading top sellers");
        File sellers = Utils.locateResource("data/top-sellers.csv");
        CsvData csv = new CsvData(sellers);
        System.out.println(csv.getRecords());
        Context.INSTANCE.setCsvDataSource(csv);
        csvIndicator.setText("Current CSV: top sellers");
        showTableMenu.setDisable(false);
    }

    public void loadNCE(ActionEvent actionEvent) throws IOException {
        System.out.println("loading NCE");
        File nce = Utils.locateResource("data/new-concept-english.txt");
        TextData text = new TextData(nce);
        System.out.println(text.getText());
        Context.INSTANCE.setTextDataSource(text);
        txtIndicator.setText("Current TXT: nce");
        showTextMenu.setDisable(false);
    }

    public void loadStory(ActionEvent actionEvent) throws IOException {
        System.out.println("loading Story");
        File story = Utils.locateResource("data/story.txt");
        TextData text = new TextData(story);
        System.out.println(text.getText());
        Context.INSTANCE.setTextDataSource(text);
        txtIndicator.setText("Current TXT: story");
        showTextMenu.setDisable(false);
    }

    public void doQuit(ActionEvent actionEvent) {
        System.out.println("bye");
        System.exit(0);
    }
}
