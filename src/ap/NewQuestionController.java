package ap;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuButton;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Region;

/**
 * FXML Controller class
 *
 * @author Chen Bingru
 */

public class NewQuestionController implements Initializable {

    @FXML
    private AnchorPane NewQuestion;

    @FXML
    private Button Back;

    @FXML
    private TextField Title;

    @FXML
    private MenuButton Type;

    @FXML
    private DatePicker Deadline;

    @FXML
    private Button Submit;

    @FXML
    private Button Storage;

    @FXML
    private TextField Text;

    @FXML
    private TextField Code;

    @FXML
    private DatePicker CreationTime;

    @FXML
    private Button MCQ;

    @FXML
    private Button PolarQuestion;

    @FXML
    private Button Opinionscale;

    @FXML
    private Button Likertscale;

    @FXML
    private Button Rankorder;

    @FXML
    private Button Rating;

    @FXML
    private Button Demographic;

    @FXML
    private Button Openended;

    @FXML
    private VBox questionsContainer;
    
    @FXML
    void closeCurrentPage(ActionEvent event) {
        Stage stage = (Stage) Back.getScene().getWindow();
        stage.close();
    }

    @FXML
    void Code(ActionEvent event) {

    }
    
     @FXML
    void CreationTime(ActionEvent event) {

    }

    @FXML
    void Deadline(ActionEvent event) {

    }
    
    @FXML
    void Title(ActionEvent event) {

    }
    
    private void addSpacing() {
    Region spacing = new Region();
    spacing.setPrefHeight(20); // Setting height
    questionsContainer.getChildren().add(spacing);
    }
    
    @FXML
    void Demographic(ActionEvent event) {
        Label questionLabel = new Label("Demographic Question: ...");
        TextField demographicField = new TextField();
        demographicField.setPromptText("Enter demographic data here");
        questionsContainer.getChildren().addAll(questionLabel, demographicField);
        addSpacing();
    }

    @FXML
    void Likertscale(ActionEvent event) {
        Label questionLabel = new Label("Likert Scale Question: ...");
        ToggleGroup group = new ToggleGroup();
        RadioButton stronglyDisagree = new RadioButton("Strongly Disagree");
        stronglyDisagree.setToggleGroup(group);
        RadioButton disagree = new RadioButton("Disagree");
        disagree.setToggleGroup(group);
        RadioButton neutral = new RadioButton("Neutral");
        neutral.setToggleGroup(group);
        RadioButton agree = new RadioButton("Agree");
        agree.setToggleGroup(group);
        RadioButton stronglyAgree = new RadioButton("Strongly Agree");
        stronglyAgree.setToggleGroup(group);
        questionsContainer.getChildren().addAll(questionLabel, stronglyDisagree, disagree, neutral, agree, stronglyAgree);
        addSpacing();
    }

    @FXML
    void MCQ(ActionEvent event) {
        Label questionLabel = new Label("MCQ Question: ...");
        CheckBox option1 = new CheckBox("Option 1");
        CheckBox option2 = new CheckBox("Option 2");
        CheckBox option3 = new CheckBox("Option 3");
        CheckBox option4 = new CheckBox("Option 4");
        // Add more options
        questionsContainer.getChildren().addAll(questionLabel, option1, option2, option3, option4);
        addSpacing();
    }

    @FXML
    void Openended(ActionEvent event) {
        Label questionLabel = new Label("Open-ended Question: ...");
        TextArea openEndedArea = new TextArea();
        openEndedArea.setPromptText("Type your answer here");
        questionsContainer.getChildren().addAll(questionLabel, openEndedArea);
        addSpacing();
    }

    @FXML
    void Opinionscale(ActionEvent event) {
        Label questionLabel = new Label("Opinion Scale Question: ...");
        Slider opinionScale = new Slider(1, 5, 3); // Slider from 1 to 5
        opinionScale.setShowTickLabels(true);
        opinionScale.setShowTickMarks(true);
        questionsContainer.getChildren().addAll(questionLabel, opinionScale);
        addSpacing();
    }

    @FXML
    void PolarQuestion(ActionEvent event) {
        Label questionLabel = new Label("Polar Question: ...");
        ToggleGroup group = new ToggleGroup();
        RadioButton yesOption = new RadioButton("Yes");
        yesOption.setToggleGroup(group);
        RadioButton noOption = new RadioButton("No");
        noOption.setToggleGroup(group);
        questionsContainer.getChildren().addAll(questionLabel, yesOption, noOption);
        addSpacing();
    }

    @FXML
    void Rankorder(ActionEvent event) {
        Label questionLabel = new Label("Rank Order Question: ...");
        ListView<String> optionsList = new ListView<>();
        optionsList.getItems().addAll("Option 1", "Option 2", "Option 3");
        optionsList.setPrefHeight(100);
        questionsContainer.getChildren().addAll(questionLabel, optionsList);
        addSpacing();
    }

    @FXML
    void Rating(ActionEvent event) {
        Label questionLabel = new Label("Rating Question: ...");
        Slider ratingSlider = new Slider(1, 10, 5); // Slider from 1 to 10
        ratingSlider.setShowTickLabels(true);
        ratingSlider.setShowTickMarks(true);
        questionsContainer.getChildren().addAll(questionLabel, ratingSlider);
        addSpacing();
    }

    @FXML
    void SubmitCurrentPage(ActionEvent event) {
        int QuestionnaireCode = Integer.parseInt(Code.getText());
        String QuestionnaireTitle = Title.getText();
        String QuestionnaireDeadline = Deadline.getValue().toString();
        String QuestionnaireCreationTime = CreationTime.getValue().toString();
        // Setting static
        String QuestionnaireStatus = "Published";
        String CreateBy = "Admin";
        // Collect data for all question types
        String QuestionData = collectAllQuestionData();
        // save to CSV
        saveQuestionnaireToCSV(QuestionnaireCode, QuestionnaireTitle, QuestionnaireDeadline, QuestionnaireCreationTime, QuestionnaireStatus, CreateBy, QuestionData);
        Questionnaire questionnaire = new Questionnaire(QuestionnaireCode, QuestionnaireTitle, "published", QuestionnaireDeadline, "Name", QuestionnaireCreationTime);

        QuestionnaireDataAccess dataAccess = new QuestionnaireDataAccess();
        dataAccess.saveQuestionnaire(questionnaire);
    }

    void saveQuestionnaireToCSV(int QuestionnaireCode, String QuestionnaireTitle, String QuestionnaireDeadline, String QuestionnaireCreationTime, String QuestionnaireStatus, String CreateBy, String QuestionData) {
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
                  .append(',')
                  .append(QuestionData)
                  .append('\n');
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    String collectAllQuestionData() { // Collection for each question
        StringBuilder allQuestionsData = new StringBuilder();
        allQuestionsData.append(collectMCQData());
        allQuestionsData.append(collectPolarQuestionData());
        allQuestionsData.append(collectOpinionScaleData());
        allQuestionsData.append(collectLikertScaleData());
        allQuestionsData.append(collectRankOrderData());
        allQuestionsData.append(collectRatingData());
        allQuestionsData.append(collectDemographicData());
        return allQuestionsData.toString();
    }

    // Data collection for each question type
    String collectMCQData() {
        return "MCQ Data;";
    }

    String collectPolarQuestionData() {
        return "Polar Question Data;";
    }
    
    String collectOpinionScaleData() {
        return "OpinionScale: Value;";
    }

    String collectLikertScaleData() {
        return "LikertScale: SelectedOption;";
    }

    String collectRankOrderData() {
        return "RankOrder: OrderedItems;";
    }

    String collectRatingData() {
        return "Rating: Value;";
    }

    String collectDemographicData() {
        return "Demographic: Data;";
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

}
