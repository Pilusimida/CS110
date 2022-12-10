package cs110;

import cs110.control.CsvViewerController;
import cs110.control.TextViewerController;
import cs110.misc.ConvenientStage;
import cs110.model.CsvData;
import cs110.model.TextData;
import javafx.stage.Stage;
import lombok.Data;

/**
 * Shares data between stages / controllers.
 * <p>
 * Learn more: <a href="https://www.dineshonjava.com/context-object-design-pattern">Context Object Design Pattern</a>
 */
@Data
public class Context {

    public static final Context INSTANCE = new Context();

    private Context() {
        // singleton
    }


    // data source /////////////////////////////////////////////////

    private CsvData csvDataSource;
    private TextData textDataSource;

    // stages //////////////////////////////////////////////////////

    private Stage mainPage;
    private ConvenientStage<TextViewerController> textViewer;
    private ConvenientStage<CsvViewerController> csvViewer;

    public TextData getTextDataSource() {
        return textDataSource;
    }


    public void setCsvDataSource(CsvData csvDataSource) {
        this.csvDataSource = csvDataSource;
    }

    public void setTextDataSource(TextData textDataSource) {
        this.textDataSource = textDataSource;
    }

    public ConvenientStage<TextViewerController> getTextViewer() {
        return textViewer;
    }

    public void setMainPage(Stage mainPage) {
        this.mainPage = mainPage;
    }

    public void setTextViewer(ConvenientStage<TextViewerController> textViewer) {
        this.textViewer = textViewer;
    }
}
