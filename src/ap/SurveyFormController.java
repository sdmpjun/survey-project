package ap;

/**
 *
 * @author Chen Bingru
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Chen Bingru
 */

public class SurveyFormController implements Initializable {
    
    @FXML
    private TableView<Form> SurveyForm;

    @FXML
    private TableColumn<Form, Integer> SurveyId;

    @FXML
    private TableColumn<Form, String> SurveyTitle;

    @FXML
    private TableColumn<Form, Integer> Id;

    @FXML
    private TableColumn<Form, String> CreatorName;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<Form> data = FXCollections.observableArrayList();
        String csvFile = "Survey_Form.csv";
        String cvsSplitBy = ",";
        
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            br.readLine(); // Skip the header

            String line;
            while ((line = br.readLine()) != null) {
                String[] formEntry = line.split(cvsSplitBy);
                Form form = new Form(
                        Integer.parseInt(formEntry[0]),
                        formEntry[1],
                        Integer.parseInt(formEntry[2]),
                        formEntry[3]);
                data.add(form);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        
        SurveyId.setCellValueFactory(new PropertyValueFactory<>("SurveyId"));
        SurveyTitle.setCellValueFactory(new PropertyValueFactory<>("SurveyTitle"));
        Id.setCellValueFactory(new PropertyValueFactory<>("Id"));
        CreatorName.setCellValueFactory(new PropertyValueFactory<>("CreatorName"));

        SurveyForm.setItems(data);
    } 
    
}
