package ap;

/**
 *
 * @author Chen Bingru
 */

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class QuestionManagementController implements Initializable {
    
    @FXML
    private AnchorPane QuestionnaireManagement;

    @FXML
    private TextField Code;

    @FXML
    private TextField Title;

    @FXML
    private TextField Founder;

    @FXML
    private MenuButton Type;

    @FXML
    private CheckBox Status1;

    @FXML
    private CheckBox Status2;

    @FXML
    private CheckBox Status3;

    @FXML
    private CheckBox Status4;

    @FXML
    private DatePicker StartDate;

    @FXML
    private Button Search;

    @FXML
    private Button Reprovision;

    @FXML
    private DatePicker EndDate;

    @FXML
    private Button New;

    @FXML
    private Button Export;
    
    @FXML
    private TableView<Questionnaire> Table;

    @FXML
    private TableColumn<Questionnaire, Integer> QuestionnaireCode;

    @FXML
    private TableColumn<Questionnaire, String> QuestionnaireTitle;

    @FXML
    private TableColumn<Questionnaire, String> QuestionnaireStatus;

    @FXML
    private TableColumn<Questionnaire, String> Deadline;

    @FXML
    private TableColumn<Questionnaire, String> CreateBy;

    @FXML
    private TableColumn<Questionnaire, String> CreationTime;

    @FXML
    private TableColumn<Questionnaire, String> Operation;
    
    @FXML
    private Button View1;

    @FXML
    private Button Edit1;

    @FXML
    private Button Link1;

    @FXML
    private Button View2;

    @FXML
    private Button Edit2;

    @FXML
    private Button Link2;
    
    @FXML
    private Button SurveyCreatorForm;

    @FXML
    private Button SurveyForm;
    
    @FXML
    void Code(ActionEvent event) {

    }

    @FXML
    void Createdby(ActionEvent event) {

    }
    
    @FXML
    void StartDate(ActionEvent event) {

    }

    @FXML
    void Status1(ActionEvent event) {

    }

    @FXML
    void Status2(ActionEvent event) {

    }

    @FXML
    void Status3(ActionEvent event) {

    }

    @FXML
    void Status4(ActionEvent event) {

    }
    
    @FXML
    void EndDate(ActionEvent event) {

    }
    
    @FXML
    void Reprovision(ActionEvent event) {
        Code.clear();
        Title.clear();
        Founder.clear();
        StartDate.setValue(null);
        EndDate.setValue(null);
        Status1.setSelected(false);
        Status2.setSelected(false);
        Status3.setSelected(false);
        Status4.setSelected(false);
    }

    @FXML
    void Search(ActionEvent event) {
        
    }

    @FXML
    void Title(ActionEvent event) {

    }
    
    @FXML
    void Refresh(ActionEvent event) {
        loadCsvData();
    }
    
    @FXML
    void SurveyCreatorForm(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SurveyCreatorForm.fxml"));
            Parent root2 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.initStyle(StageStyle.DECORATED);
            stage.setScene(new Scene(root2));
            stage.show();
        } catch (Exception e) {
            System.out.println("Cant load new window");
        }
    }

    @FXML
    void SurveyForm(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SurveyForm.fxml"));
            Parent root8 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.initStyle(StageStyle.DECORATED);
            stage.setScene(new Scene(root8));
            stage.show();
        } catch (Exception e) {
            System.out.println("Cant load new window");
        }
    }
    
    @FXML
    void ExportTableContent(ActionEvent event) {
        try {  // Export data from a list
            FileChooser fileChooser = new FileChooser();
            fileChooser.setInitialFileName("table_data.csv");
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("CSV Files", "*.csv"));

            File file = fileChooser.showSaveDialog(Table.getScene().getWindow());

            if (file != null) {
                // Get data in TableView
                ObservableList<Questionnaire> data = Table.getItems();

                try (FileWriter writer = new FileWriter(file)) {
                    // Write CSV file header
                    writer.append("QuestionnaireCode,QuestionnaireTitle,QuestionnaireStatus,Deadline,CreateBy,CreationTime\n");

                    // Write data row
                    for (Questionnaire questionnaire : data) {
                        writer.append(questionnaire.getQuestionnaireCode() + "," +
                                      questionnaire.getQuestionnaireTitle() + "," +
                                      questionnaire.getQuestionnaireStatus() + "," +
                                      questionnaire.getDeadline() + "," +
                                      questionnaire.getCreateBy() + "," +
                                      questionnaire.getCreationTime());
                    }
                } catch (IOException e) {
                    System.out.println("Error exporting data to CSV file: " + e.getMessage());
                }
            }
        } catch (Exception e) {
            System.out.println("Unable to open file save dialog: " + e.getMessage());
        }
    }
    
    @FXML
    void handleButtonActionEdit1(ActionEvent event) {
        for (Questionnaire questionnaire : Table.getItems()) {
            if (questionnaire.getQuestionnaireCode() == 1) {
                editQuestionnaire(questionnaire);
                break;
            }
        }
    }

    @FXML
    void handleButtonActionEdit2(ActionEvent event) {
        for (Questionnaire questionnaire : Table.getItems()) {
            if (questionnaire.getQuestionnaireCode() == 3) {
                editQuestionnaire(questionnaire);
                break;
            }
        }
    }
    
    private void editQuestionnaire(Questionnaire questionnaire) {
        if (questionnaire != null) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("EditQuestion.fxml"));
                Parent root1 = loader.load();

                EditQuestionController editQuestionController = loader.getController();
                editQuestionController.initializeData(questionnaire);

                Stage stage = new Stage();
                stage.setScene(new Scene(root1));
                stage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    @FXML
    void handleButtonActionLink1(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Link.fxml"));
            Parent root3 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.initStyle(StageStyle.DECORATED);
            stage.setScene(new Scene(root3));
            stage.show();
        } catch (Exception e) {
            System.out.println("Cant load new window");
        }
    }

    @FXML
    void handleButtonActionLink2(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Link.fxml"));
            Parent root4 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.initStyle(StageStyle.DECORATED);
            stage.setScene(new Scene(root4));
            stage.show();
        } catch (Exception e) {
            System.out.println("Cant load new window");
        }
    }

    @FXML
    void handleButtonActionNew(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("NewQuestion.fxml"));
            Parent root5 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.initStyle(StageStyle.DECORATED);
            stage.setScene(new Scene(root5));
            stage.show();
        } catch (Exception e) {
            System.out.println("Cant load new window");
        }
    }

    @FXML
    void handleButtonActionView1(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ViewQuestion.fxml"));
            Parent root6 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.initStyle(StageStyle.DECORATED);
            stage.setScene(new Scene(root6));
            ViewQuestionController controller = fxmlLoader.getController();
            controller.selectTab("Questionnaire1");
            stage.show();
        } catch (Exception e) {
            System.out.println("Cant load new window");
        }
    }

    @FXML
    void handleButtonActionView2(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ViewQuestion.fxml"));
            Parent root7 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.initStyle(StageStyle.DECORATED);
            stage.setScene(new Scene(root7));
            ViewQuestionController controller = fxmlLoader.getController();
            controller.selectTab("Questionnaire2");
            stage.show();
        } catch (Exception e) {
            System.out.println("Cant load new window");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadQuestionnaireData();
    }

    private void loadQuestionnaireData() {
        QuestionnaireDataAccess dataAccess = new QuestionnaireDataAccess();
        ObservableList<Questionnaire> data = FXCollections.observableArrayList(dataAccess.getAllQuestionnaires());
        
        QuestionnaireCode.setCellValueFactory(new PropertyValueFactory<>("QuestionnaireCode"));
        QuestionnaireTitle.setCellValueFactory(new PropertyValueFactory<>("QuestionnaireTitle"));
        QuestionnaireStatus.setCellValueFactory(new PropertyValueFactory<>("QuestionnaireStatus"));
        Deadline.setCellValueFactory(new PropertyValueFactory<>("Deadline"));
        CreateBy.setCellValueFactory(new PropertyValueFactory<>("CreateBy"));
        CreationTime.setCellValueFactory(new PropertyValueFactory<>("CreationTime"));
        Operation.setCellValueFactory(new PropertyValueFactory<>("Operation"));

        Table.setItems(data);
    }
    
    public void loadCsvData() {
        QuestionnaireDataAccess dataAccess = new QuestionnaireDataAccess();
        ObservableList<Questionnaire> list = FXCollections.observableArrayList(dataAccess.getAllQuestionnaires());
        Table.setItems(list);
    }
}
