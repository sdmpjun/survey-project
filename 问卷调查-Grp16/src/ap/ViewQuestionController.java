package ap;

/**
 *
 * @author Chen Bingru
 */

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author Chen Bingru
 */

public class ViewQuestionController implements Initializable {

    @FXML
    private TabPane ViewQuestion;

    @FXML
    private Tab Questionnaire1;

    @FXML
    private Button Back1;

    @FXML
    private TextArea Text1;

    @FXML
    private TextArea Question11;

    @FXML
    private Button Submit1;

    @FXML
    private Button Storage1;

    @FXML
    private CheckBox Option11;

    @FXML
    private CheckBox Option21;

    @FXML
    private CheckBox Option31;

    @FXML
    private CheckBox Option41;

    @FXML
    private RadioButton Yes1;

    @FXML
    private ToggleGroup Polar;

    @FXML
    private RadioButton No1;

    @FXML
    private Slider Question51;

    @FXML
    private TextField Question21;

    @FXML
    private DatePicker Question61;

    @FXML
    private Button ViewResults1;

    @FXML
    private Tab Questionnaire2;

    @FXML
    private Button Back2;

    @FXML
    private TextArea Text;

    @FXML
    private TextArea Question1;

    @FXML
    private Button Submit;

    @FXML
    private Button Storage;

    @FXML
    private CheckBox Option1;

    @FXML
    private CheckBox Option2;

    @FXML
    private CheckBox Option3;

    @FXML
    private CheckBox Option4;

    @FXML
    private RadioButton Yes;

    @FXML
    private ToggleGroup Polar1;

    @FXML
    private RadioButton No;

    @FXML
    private Slider Question5;

    @FXML
    private TextField Question2;

    @FXML
    private DatePicker Question6;

    @FXML
    private Button ViewResults2;
    
   @FXML
    void closeCurrentPage1(ActionEvent event) {
        Stage stage = (Stage) Back1.getScene().getWindow();
        stage.close();
    }
    
    @FXML
    void closeCurrentPage2(ActionEvent event) {
        Stage stage = (Stage) Back2.getScene().getWindow();
        stage.close();
    }

    @FXML
    void handleButtonActionResults1(ActionEvent event) {
        Stage stage = (Stage) ViewResults1.getScene().getWindow();
        stage.close();
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("QuestionResults.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage newstage = new Stage();
            newstage.initStyle(StageStyle.DECORATED);
            newstage.setScene(new Scene(root1));
            QuestionResultsController controller = fxmlLoader.getController();
            controller.selectTab("Results1");
            newstage.show();
        } catch (Exception e) {
            System.out.println("Cant load new window");
        }
    }

    @FXML
    void handleButtonActionResults2(ActionEvent event) {
        Stage stage = (Stage) ViewResults2.getScene().getWindow();
        stage.close();
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("QuestionResults.fxml"));
            Parent root2 = (Parent) fxmlLoader.load();
            Stage newstage = new Stage();
            newstage.initStyle(StageStyle.DECORATED);
            newstage.setScene(new Scene(root2));
            QuestionResultsController controller = fxmlLoader.getController();
            controller.selectTab("Results2");
            newstage.show();
        } catch (Exception e) {
            System.out.println("Cant load new window");
        }
    }
    
    public void selectTab(String tabId) {
        if ("Questionnaire1".equals(tabId)) {
            ViewQuestion.getSelectionModel().select(Questionnaire1);
        } else if ("Questionnaire2".equals(tabId)) {
            ViewQuestion.getSelectionModel().select(Questionnaire2);
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
