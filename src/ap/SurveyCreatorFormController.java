package ap;

/**
 *
 * @author Chen Bingru
 */

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javafx.scene.control.cell.PropertyValueFactory;

public class SurveyCreatorFormController implements Initializable {

    @FXML
    private TableView<Form> SurveyCreatorForm;

    @FXML
    private TableColumn<Form, Integer> SCId;

    @FXML
    private TableColumn<Form, String> Username;

    @FXML
    private TableColumn<Form, String> Password;

    @FXML
    private TableColumn<Form, String> FirstName;

    @FXML
    private TableColumn<Form, String> LastName;

    @FXML
    private TableColumn<Form, String> Faculty;

    @FXML
    private TableColumn<Form, String> EmailAddress;

    @FXML
    private TableColumn<Form, String> Gender;

    @FXML
    private TableColumn<Form, String> PhoneNo;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<Form> data = FXCollections.observableArrayList();
        String csvFile = "Survey_Creator_Form.csv";
        String cvsSplitBy = ",";
        
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            br.readLine(); // Skip the header

            String line;
            while ((line = br.readLine()) != null) {
                String[] formEntry = line.split(cvsSplitBy);
                Form form = new Form(
                        Integer.parseInt(formEntry[0]),
                        formEntry[1],
                        formEntry[2],
                        formEntry[3],
                        formEntry[4],
                        formEntry[5],
                        formEntry[6],
                        formEntry[7],
                        formEntry[8]);
                data.add(form);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        
        SCId.setCellValueFactory(new PropertyValueFactory<>("SCId"));
        Username.setCellValueFactory(new PropertyValueFactory<>("Username"));
        Password.setCellValueFactory(new PropertyValueFactory<>("Password"));
        FirstName.setCellValueFactory(new PropertyValueFactory<>("FirstName"));
        LastName.setCellValueFactory(new PropertyValueFactory<>("LastName"));
        Faculty.setCellValueFactory(new PropertyValueFactory<>("Faculty"));
        EmailAddress.setCellValueFactory(new PropertyValueFactory<>("EmailAddress"));
        Gender.setCellValueFactory(new PropertyValueFactory<>("Gender"));
        PhoneNo.setCellValueFactory(new PropertyValueFactory<>("PhoneNo"));

        SurveyCreatorForm.setItems(data);
    }
    
}
