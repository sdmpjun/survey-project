package ap;

/**
 *
 * @author Chen Bingru
 */

public class Questionnaire {
    private Integer QuestionnaireCode;
    private String QuestionnaireTitle;
    private String QuestionnaireStatus;
    private String Deadline;
    private String CreateBy;
    private String CreationTime;
    private String Question1;
    private String Question2;
    private String Option1;
    private String Option2;
    private String Option3;
    private String Option4;
    private String Question4;
    private String Question5;
    private String Question6;
    private String Question11;
    private String Question21;
    private String Option11;
    private String Option21;
    private String Option31;
    private String Option41;
    private String Question41;
    private String Question51;
    private String Question61;
    
    public Questionnaire(Integer QuestionnaireCode, String QuestionnaireTitle, String QuestionnaireStatus, String QuestionnaireDeadline, String CreateBy, String QuestionnaireCreationTime) {
        this.QuestionnaireCode = QuestionnaireCode;
        this.QuestionnaireTitle = QuestionnaireTitle;
        this.QuestionnaireStatus = QuestionnaireStatus;
        this.Deadline = QuestionnaireDeadline;
        this.CreateBy = CreateBy;
        this.CreationTime = QuestionnaireCreationTime;
    }

    public Integer getQuestionnaireCode() {
        return QuestionnaireCode;
    }

    public String getQuestionnaireTitle() {
        return QuestionnaireTitle;
    }

    public String getQuestionnaireStatus() {
        return QuestionnaireStatus;
    }

    public String getDeadline() {
        return Deadline;
    }

    public String getCreateBy() {
        return CreateBy;
    }

    public String getCreationTime() {
        return CreationTime;
    }

    public void setQuestionnaireCode(Integer QuestionnaireCode) {
        this.QuestionnaireCode = QuestionnaireCode;
    }

    public void setQuestionnaireTitle(String QuestionnaireTitle) {
        this.QuestionnaireTitle = QuestionnaireTitle;
    }

    public void setQuestionnaireStatus(String QuestionnaireStatus) {
        this.QuestionnaireStatus = QuestionnaireStatus;
    }

    public void setDeadline(String QuestionnaireDeadline) {
        this.Deadline = QuestionnaireDeadline;
    }

    public void setCreateBy(String CreateBy) {
        this.CreateBy = CreateBy;
    }

    public void setCreationTime(String QuestionnaireCreationTime) {
        this.CreationTime = QuestionnaireCreationTime;
    }

    public Questionnaire(String Question1, String Question2, String Option1, String Option2, String Option3, String Option4, String Question4, String Question5, String Question6) {
        this.Question1 = Question1;
        this.Question2 = Question2;
        this.Option1 = Option1;
        this.Option2 = Option2;
        this.Option3 = Option3;
        this.Option4 = Option4;
        this.Question4 = Question4;
        this.Question5 = Question5;
        this.Question6 = Question6;
    }

    public Questionnaire(String Question11, String Question21, String Option11, String Option21, String Option31, String Option41, String Question41, String Question51) {
        this.Question11 = Question11;
        this.Question21 = Question21;
        this.Option11 = Option11;
        this.Option21 = Option21;
        this.Option31 = Option31;
        this.Option41 = Option41;
        this.Question41 = Question41;
        this.Question51 = Question51;
    }
    

    public String getQuestion1() {
        return Question1;
    }

    public String getQuestion2() {
        return Question2;
    }

    public String getOption1() {
        return Option1;
    }

    public String getOption2() {
        return Option2;
    }

    public String getOption3() {
        return Option3;
    }

    public String getOption4() {
        return Option4;
    }

    public String getQuestion4() {
        return Question4;
    }

    public String getQuestion5() {
        return Question5;
    }

    public String getQuestion6() {
        return Question6;
    }

    public String getQuestion11() {
        return Question11;
    }

    public String getQuestion21() {
        return Question21;
    }

    public String getOption11() {
        return Option11;
    }

    public String getOption21() {
        return Option21;
    }

    public String getOption31() {
        return Option31;
    }

    public String getOption41() {
        return Option41;
    }

    public String getQuestion41() {
        return Question41;
    }

    public String getQuestion51() {
        return Question51;
    }

    public String getQuestion61() {
        return Question61;
    }

    public void setQuestion1(String Question1) {
        this.Question1 = Question1;
    }

    public void setQuestion2(String Question2) {
        this.Question2 = Question2;
    }

    public void setOption1(String Option1) {
        this.Option1 = Option1;
    }

    public void setOption2(String Option2) {
        this.Option2 = Option2;
    }

    public void setOption3(String Option3) {
        this.Option3 = Option3;
    }

    public void setOption4(String Option4) {
        this.Option4 = Option4;
    }

    public void setQuestion4(String Question4) {
        this.Question4 = Question4;
    }

    public void setQuestion5(String Question5) {
        this.Question5 = Question5;
    }

    public void setQuestion6(String Question6) {
        this.Question6 = Question6;
    }

    public void setQuestion11(String Question11) {
        this.Question11 = Question11;
    }

    public void setQuestion21(String Question21) {
        this.Question21 = Question21;
    }

    public void setOption11(String Option11) {
        this.Option11 = Option11;
    }

    public void setOption21(String Option21) {
        this.Option21 = Option21;
    }

    public void setOption31(String Option31) {
        this.Option31 = Option31;
    }

    public void setOption41(String Option41) {
        this.Option41 = Option41;
    }

    public void setQuestion41(String Question41) {
        this.Question41 = Question41;
    }

    public void setQuestion51(String Question51) {
        this.Question51 = Question51;
    }

    public void setQuestion61(String Question61) {
        this.Question61 = Question61;
    }
    
    public String getMCQData() {
        // 假设 MCQ 数据储存在 Question1 和 Option1, Option2, Option3, Option4 字段
        return String.format("MCQ Question: %s\nOptions: %s, %s, %s, %s\n",
                             Question1, Option1, Option2, Option3, Option4);
    }

    public String getLikertscaleData() {
        // 假设 Likert Scale 数据储存在 Question2 字段
        return String.format("Likert Scale Question: %s\n", Question2);
    }

    public String getDemographicData() {
        // 假设 Demographic 数据储存在 Question3 字段
        return String.format("Demographic Question: %s\n", Question4);
    }

    public String getOpenendedData() {
        // 假设 Open-ended 数据储存在 Question4 字段
        return String.format("Open-ended Question: %s\n", Question5);
    }

    public String getOpinionscaleData() {
        // 假设 Opinion Scale 数据储存在 Question5 字段
        return String.format("Opinion Scale Question: %s\n", Question6);
    }

    public String getPolarQuestionData() {
        // 假设 Polar Question 数据储存在 Question6 字段
        return String.format("Polar Question: %s\n", Question6);
    }

    public String getRankorderData() {
        // 假设 Rank Order 数据储存在 Question7 字段
        return String.format("Rank Order Question: %s\n", Question6);
    }

    public String getRatingData() {
        // 假设 Rating 数据储存在 Question8 字段
        return String.format("Rating Question: %s\n", Question6);
    }


    String toCsvString() {
        StringBuilder sb = new StringBuilder();
        sb.append(QuestionnaireCode).append(",");
        sb.append("\"").append(QuestionnaireTitle.replace("\"", "\"\"")).append("\"").append(",");  // Escape quotes in title
        sb.append(QuestionnaireStatus).append(",");
        sb.append(Deadline).append(",");
        sb.append(CreateBy).append(",");
        sb.append(CreationTime);
        // Add other fields similarly, handling special characters like commas or quotes if necessary

        return sb.toString();
    }
    
}
