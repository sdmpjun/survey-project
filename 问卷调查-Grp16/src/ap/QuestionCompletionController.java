package ap;

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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Chen Bingru
 */

public class QuestionCompletionController implements Initializable {

    @FXML
    private AnchorPane QuestionCompletion;

    @FXML
    private TextArea Question1;

    @FXML
    private TextField Question2;

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
    private ToggleGroup Polar;

    @FXML
    private RadioButton No;

    @FXML
    private Slider Question5;

    @FXML
    private DatePicker Question6;

    @FXML
    private Button Submit;

    @FXML
    private Button Storage;
    
    @FXML
    void SubmitCurrentPage(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("CompleteQuestion.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Scene scene = Submit.getScene();
            scene.setRoot(root);
        } catch (Exception e) {
            System.out.println("Cant to load a new window");
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
