package ap;

/**
 *
 * @author Chen Bingru
 */

import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class EditQuestionController implements Initializable {

    @FXML
    private AnchorPane EditQuestion;

    @FXML
    private Button Back;

    @FXML
    private TextField Title;

    @FXML
    private MenuButton Type;

    @FXML
    private DatePicker Deadline;

    @FXML
    private TextArea Text;

    @FXML
    private Button Submit;

    @FXML
    private Button Storage;

    @FXML
    private TextField Code;

    @FXML
    private DatePicker CreationTime;

    @FXML
    private VBox Editorial;

    @FXML
    void CreationTime(ActionEvent event) {

    }

    @FXML
    void Deadline(ActionEvent event) {

    }

    @FXML
    void QuestionnaireCode(ActionEvent event) {

    }

    @FXML
    void QuestionnaireTitle(ActionEvent event) {

    }

    @FXML
    void SubmitCurrentPage(ActionEvent event) { // Write new Questionnaire data
        int QuestionnaireCode = Integer.parseInt(Code.getText());
        String QuestionnaireTitle = Title.getText();
        String QuestionnaireDeadline = Deadline.getValue().toString();
        String QuestionnaireCreationTime = CreationTime.getValue().toString();
        // Setting static
        String QuestionnaireStatus = "Published";
        String CreateBy = "Admin";
        // save to CSV
        saveQuestionnaireToCSV(QuestionnaireCode, QuestionnaireTitle, QuestionnaireDeadline, QuestionnaireCreationTime, QuestionnaireStatus, CreateBy);
        Questionnaire questionnaire = new Questionnaire(QuestionnaireCode, QuestionnaireTitle, "published", QuestionnaireDeadline, "Name", QuestionnaireCreationTime);

        QuestionnaireDataAccess dataAccess = new QuestionnaireDataAccess();
        dataAccess.saveQuestionnaire(questionnaire);
    }

    void saveQuestionnaireToCSV(int QuestionnaireCode, String QuestionnaireTitle, String QuestionnaireDeadline, String QuestionnaireCreationTime, String QuestionnaireStatus, String CreateBy) {
        String csvFile = "AP.csv";

        try (FileWriter writer = new FileWriter(csvFile, true)) {
            writer.append(String.valueOf(QuestionnaireCode))
                  .append(',')
                  .append(QuestionnaireTitle)
                  .append(',')
                  .append(QuestionnaireDeadline)
                  .append(',')
                  .append(QuestionnaireCreationTime)
                  .append(',')
                  .append(QuestionnaireStatus)
                  .append(',')
                  .append(CreateBy)
                  .append('\n');
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void closeCurrentPage(ActionEvent event) { 
        Stage stage = (Stage) Back.getScene().getWindow();
        stage.close();
    }

    
    private Questionnaire currentQuestionnaire;
    
    private LocalDate parseDate(String dateString) {
        List<String> formats = Arrays.asList("yyyy-MM-dd", "yyyy/MM/d");
            for (String format : formats) {
                try {
                    return LocalDate.parse(dateString, DateTimeFormatter.ofPattern(format));
                } catch (DateTimeParseException e) {
                    // Try next format
                }
            }
        throw new DateTimeParseException("Could not parse date: " + dateString, dateString, -1); // Provides an explicit error signal when a date error cannot be successfully parsed as a date
}

    public void initializeData(Questionnaire questionnaire) {
        System.out.println("Initializing EditQuestionController with questionnaire: " + questionnaire); // Make sure Questionnaire is called correctly and which data is called
        this.currentQuestionnaire = questionnaire;
        populateFields();
    }

    private void populateFields() { // Fill in the data
        if (currentQuestionnaire != null) {
            try {
                Title.setText(currentQuestionnaire.getQuestionnaireTitle());
                Code.setText(String.valueOf(currentQuestionnaire.getQuestionnaireCode()));
                LocalDate creationDate = parseDate(currentQuestionnaire.getCreationTime());
                LocalDate deadlineDate = parseDate(currentQuestionnaire.getDeadline());
                CreationTime.setValue(creationDate);
                Deadline.setValue(deadlineDate);
                addQuestionDataToEditorial();
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    private void addQuestionDataToEditorial() {
        String mcqData = currentQuestionnaire.getMCQData(); // Return MCQ data
        Text MCQText = new Text(mcqData); 
        Editorial.getChildren().add(MCQText);
        
        String likertscaleData = currentQuestionnaire.getLikertscaleData();
        Text LikertscaleText = new Text(likertscaleData);
        Editorial.getChildren().add(LikertscaleText);
        
        String demographicData = currentQuestionnaire.getDemographicData();
        Text DemographicText = new Text(demographicData);
        Editorial.getChildren().add(DemographicText);
        
        String openendedData = currentQuestionnaire.getOpenendedData();
        Text OpenendedText = new Text(openendedData);
        Editorial.getChildren().add( OpenendedText);
        
        String opinionscaleData = currentQuestionnaire.getOpinionscaleData();
        Text OpinionscaleText = new Text(opinionscaleData);
        Editorial.getChildren().add(OpinionscaleText);
        
        String polarQuestionData = currentQuestionnaire.getPolarQuestionData();
        Text PolarQuestionText = new Text(polarQuestionData);
        Editorial.getChildren().add(PolarQuestionText);
        
        String rankorderData = currentQuestionnaire.getRankorderData();
        Text RankorderText = new Text(rankorderData);
        Editorial.getChildren().add(RankorderText);
        
        String ratingData = currentQuestionnaire.getRatingData();
        Text RatingText = new Text(ratingData);
        Editorial.getChildren().add(RatingText);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

}
