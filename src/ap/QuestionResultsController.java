package ap;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Chen Bingru
 */
public class QuestionResultsController implements Initializable {

    @FXML
    private TabPane Results;

    @FXML
    private Tab Results1;

    @FXML
    private Button Back;

    @FXML
    private Tab Statistics1;

    @FXML
    private PieChart PieChart1;

    @FXML
    private BarChart<?, ?> BarChart1;

    @FXML
    private PieChart PieChart2;

    @FXML
    private BarChart<?, ?> BarChart2;

    @FXML
    private Tab Aggregation1;

    @FXML
    private TableView<Questionnaire> AggregationTable1;

    @FXML
    private TableColumn<Questionnaire, String> Question1;

    @FXML
    private TableColumn<Questionnaire, String> Question2;

    @FXML
    private TableColumn<?, ?> Question3;

    @FXML
    private TableColumn<Questionnaire, String> Option1;

    @FXML
    private TableColumn<Questionnaire, String> Option2;

    @FXML
    private TableColumn<Questionnaire, String> Option3;

    @FXML
    private TableColumn<Questionnaire, String> Option4;

    @FXML
    private TableColumn<Questionnaire, String> Question4;

    @FXML
    private TableColumn<Questionnaire, String> Question5;

    @FXML
    private TableColumn<Questionnaire, String> Question6;

    @FXML
    private Tab Results2;

    @FXML
    private Button Back2;

    @FXML
    private Tab Statistics2;

    @FXML
    private PieChart PieChart3;

    @FXML
    private BarChart<?, ?> BarChart3;

    @FXML
    private BarChart<?, ?> BarChart4;

    @FXML
    private PieChart PieChart4;

    @FXML
    private Tab Aggregation2;

    @FXML
    private TableView<Questionnaire> AggregationTable2;

    @FXML
    private TableColumn<Questionnaire, String> Question11;

    @FXML
    private TableColumn<Questionnaire, String> Question21;

    @FXML
    private TableColumn<?, ?> Question31;

    @FXML
    private TableColumn<Questionnaire, String> Option11;

    @FXML
    private TableColumn<Questionnaire, String> Option21;

    @FXML
    private TableColumn<Questionnaire, String> Option31;

    @FXML
    private TableColumn<Questionnaire, String> Option41;

    @FXML
    private TableColumn<Questionnaire, String> Question41;

    @FXML
    private TableColumn<Questionnaire, String> Question51;
    
    @FXML
    void CloseCurrentPage1(ActionEvent event) {
        Stage stage = (Stage) Back.getScene().getWindow();
        stage.close();
    }

    @FXML
    void CloseCurrentPage2(ActionEvent event) {
        Stage stage = (Stage) Back2.getScene().getWindow();
        stage.close();
    }
    
    public void selectTab(String tabId) {
        if ("Results1".equals(tabId)) {
            Results.getSelectionModel().select(Results1);
        } else if ("Results2".equals(tabId)) {
            Results.getSelectionModel().select(Results2);
        }
    }

    @FXML
    private TableColumn<Questionnaire, String> Question61;
    
    ObservableList<Questionnaire> list1 = FXCollections.observableArrayList (
        new Questionnaire("Group 16", "Question 2", "Yes", "", "", "Yes", "Yes", "75", "01-10-2023"),
        new Questionnaire("Part B", "Question 2", "", "Yes", "Yes", "", "No", "80", "31-12-2023")
    );
    
    ObservableList<Questionnaire> list2 = FXCollections.observableArrayList (
        new Questionnaire("Group 16", "Part A", "Yes", "Yes", "Yes", "Yes", "No", "90", "31-10-2023"),
        new Questionnaire("Group 16", "Part B", "", "Yes", "", "Yes", "Yes", "100", "01-11-2023")
    );
    
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<PieChart.Data> pieChart1Data = FXCollections.observableArrayList(
            new PieChart.Data("Option 1", 25),
            new PieChart.Data("Option 2", 25),
            new PieChart.Data("Option 3", 50),
            new PieChart.Data("Option 4", 50));
        
        PieChart1.setData(pieChart1Data);
        
        ObservableList<PieChart.Data> pieChart2Data = FXCollections.observableArrayList(
            new PieChart.Data("Yes", 100),
            new PieChart.Data("No", 50));

        PieChart2.setData(pieChart2Data);
        
        ObservableList<PieChart.Data> pieChart3Data = FXCollections.observableArrayList(
            new PieChart.Data("Option 1", 50),
            new PieChart.Data("Option 2", 25),
            new PieChart.Data("Option 3", 65),
            new PieChart.Data("Option 4", 10));
        
        PieChart3.setData(pieChart3Data);
        
        ObservableList<PieChart.Data> pieChart4Data = FXCollections.observableArrayList(
            new PieChart.Data("Yes", 55),
            new PieChart.Data("No", 45));

        PieChart4.setData(pieChart4Data);
        
        XYChart.Series seriesl = new XYChart.Series ();
        seriesl.setName ("Question 3");
        seriesl.getData().add (new XYChart.Data ("Option 1", 25));
        seriesl.getData().add (new XYChart.Data ("Option 2", 25));
        seriesl.getData().add (new XYChart.Data ("Option 3", 50));
        seriesl.getData().add (new XYChart.Data ("Option 4", 50));
        
        BarChart1.getData().addAll(seriesl);
        
        XYChart.Series series2 = new XYChart.Series ();
        series2.setName ("Question 4");
        series2.getData().add (new XYChart.Data ("Yes", 100));
        series2.getData().add (new XYChart.Data ("No", 50));
        
        BarChart2.getData().addAll(series2);
        
        XYChart.Series series3 = new XYChart.Series ();
        series3.setName ("Question 3");
        series3.getData().add (new XYChart.Data ("Option 1", 50));
        series3.getData().add (new XYChart.Data ("Option 2", 25));
        series3.getData().add (new XYChart.Data ("Option 3", 65));
        series3.getData().add (new XYChart.Data ("Option 4", 10));
        
        BarChart3.getData().addAll(series3);
        
        XYChart.Series series4 = new XYChart.Series ();
        series4.setName ("Question 4");
        series4.getData().add (new XYChart.Data ("Yes", 55));
        series4.getData().add (new XYChart.Data ("No", 45));
        
        BarChart4.getData().addAll(series4);
        
        Question1.setCellValueFactory(new PropertyValueFactory<>("Question1"));
        Question2.setCellValueFactory(new PropertyValueFactory<>("Question2"));
        Option1.setCellValueFactory(new PropertyValueFactory<>("Option1"));
        Option2.setCellValueFactory(new PropertyValueFactory<>("Option2"));
        Option3.setCellValueFactory(new PropertyValueFactory<>("Option3"));
        Option4.setCellValueFactory(new PropertyValueFactory<>("Option4"));
        Question4.setCellValueFactory(new PropertyValueFactory<>("Question4"));
        Question5.setCellValueFactory(new PropertyValueFactory<>("Question5"));
        Question6.setCellValueFactory(new PropertyValueFactory<>("Question6"));
        Question11.setCellValueFactory(new PropertyValueFactory<>("Question1"));
        Question21.setCellValueFactory(new PropertyValueFactory<>("Question2"));
        Option11.setCellValueFactory(new PropertyValueFactory<>("Option1"));
        Option21.setCellValueFactory(new PropertyValueFactory<>("Option2"));
        Option31.setCellValueFactory(new PropertyValueFactory<>("Option3"));
        Option41.setCellValueFactory(new PropertyValueFactory<>("Option4"));
        Question41.setCellValueFactory(new PropertyValueFactory<>("Question4"));
        Question51.setCellValueFactory(new PropertyValueFactory<>("Question5"));
        Question61.setCellValueFactory(new PropertyValueFactory<>("Question6"));
        
        AggregationTable1.setItems(list1);
        AggregationTable2.setItems(list2);
    }    
    
}
