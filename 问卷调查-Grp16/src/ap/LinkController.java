package ap;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author Chen Bingru
 */
public class LinkController implements Initializable {
    
    @FXML
    private Button Confirm;

    @FXML
    void closeCurrentPage(ActionEvent event) {
        Stage stage = (Stage) Confirm.getScene().getWindow();
        stage.close();
    }
    
    @FXML
    void LinkButton(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("QuestionCompletion.fxml"));
            Parent root3 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.initStyle(StageStyle.DECORATED);
            stage.setScene(new Scene(root3));
            stage.show();
        } catch (Exception e) {
            System.out.println("Cant load new window");
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
