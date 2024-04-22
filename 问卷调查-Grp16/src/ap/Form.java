package ap;

/**
 *
 * @author Chen Bingru
 */
public class Form {
    private Integer SCId;
    private String Username;
    private String Password;
    private String FirstName;
    private String LastName;
    private String Faculty;
    private String EmailAddress;
    private String Gender;
    private String PhoneNo;
    private Integer SurveyId;
    private String SurveyTitle;
    private Integer Id;
    private String CreatorName;

    public Form(Integer SCId, String Username, String Password, String FirstName, String LastName, String Faculty, String EmailAddress, String Gender, String PhoneNo) {
        this.SCId = SCId;
        this.Username = Username;
        this.Password = Password;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Faculty = Faculty;
        this.EmailAddress = EmailAddress;
        this.Gender = Gender;
        this.PhoneNo = PhoneNo;
    }

    public Integer getSCId() {
        return SCId;
    }

    public String getUsername() {
        return Username;
    }

    public String getPassword() {
        return Password;
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public String getFaculty() {
        return Faculty;
    }

    public String getEmailAddress() {
        return EmailAddress;
    }

    public String getGender() {
        return Gender;
    }

    public String getPhoneNo() {
        return PhoneNo;
    }

    public void setSCId(Integer SCId) {
        this.SCId = SCId;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public void setFaculty(String Faculty) {
        this.Faculty = Faculty;
    }

    public void setEmailAddress(String EmailAddress) {
        this.EmailAddress = EmailAddress;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    public void setPhoneNo(String PhoneNo) {
        this.PhoneNo = PhoneNo;
    }

    public Form(Integer SurveyId, String SurveyTitle, Integer Id, String CreatorName) {
        this.SurveyId = SurveyId;
        this.SurveyTitle = SurveyTitle;
        this.Id = Id;
        this.CreatorName = CreatorName;
    }

    public Integer getSurveyId() {
        return SurveyId;
    }

    public String getSurveyTitle() {
        return SurveyTitle;
    }

    public Integer getId() {
        return Id;
    }

    public String getCreatorName() {
        return CreatorName;
    }

    public void setSurveyId(Integer SurveyId) {
        this.SurveyId = SurveyId;
    }

    public void setSurveyTitle(String SurveyTitle) {
        this.SurveyTitle = SurveyTitle;
    }

    public void setId(Integer Id) {
        this.Id = Id;
    }

    public void setCreatorName(String CreatorName) {
        this.CreatorName = CreatorName;
    }
    
    
}
