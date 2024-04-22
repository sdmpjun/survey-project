package ap;

/**
 *
 * @author Chen Bingru
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class QuestionnaireDataAccess {

    public List<Questionnaire> getAllQuestionnaires() {
        List<Questionnaire> questionnaires = new ArrayList<>();
        String line;
        String csvFile = "AP.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                int QuestionnaireCode = Integer.parseInt(data[0]);
                String QuestionnaireTitle = data[1];
                String QuestionnaireDeadline = data[2];
                String QuestionnaireCreationTime = data[3];
                String QuestionnaireStatus = data[4];
                String CreateBy = data[5];

                Questionnaire questionnaire = new Questionnaire(QuestionnaireCode, QuestionnaireTitle, QuestionnaireDeadline, QuestionnaireCreationTime, QuestionnaireStatus, CreateBy);
                questionnaires.add(questionnaire);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return questionnaires;
    }
    public void saveQuestionnaire(Questionnaire questionnaire) {
        String csvFile = "AP.csv";

        try (FileWriter fw = new FileWriter(csvFile, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            
            // Assuming Questionnaire has a method to get its data in CSV format
            String csvData = questionnaire.toCsvString();
            out.println(csvData);

        } catch (IOException e) {
            // Handle exceptions
            System.out.println("An error occurred while writing to the CSV file: " + e.getMessage());
        }
    }
}
