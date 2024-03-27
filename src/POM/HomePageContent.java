package POM;

import Utility.BaseDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePageContent{
    public HomePageContent() {
        PageFactory.initElements(BaseDriver.driver, this);
    }

    @FindBy(xpath = "//ul[@class='navbar-nav ml-auto user-options']/li[3]/a")
    public WebElement logoutButton;

    @FindBy(xpath = "//ul[@class='navbar-nav ml-auto user-options']/li[1]")
    public WebElement profileIcon;

    @FindBy(id= "selected-location")
    public WebElement selectedLocation;

    // Register a patient
    @FindBy(css = "div[id='apps'] :nth-child(4)")
    public WebElement registerAPatientButton;

    @FindBy(name = "givenName")
    public WebElement given;

    @FindBy(name = "familyName")
    public WebElement familyName;

    @FindBy(id = "next-button")
    public WebElement nextButton;

    @FindBy(css = "select[id='gender-field']")
    public WebElement gender;

    @FindBy(name = "birthdateDay")
    public WebElement day;

    @FindBy(css = "select[name='birthdateMonth']")
    public WebElement month;

    @FindBy(name = "birthdateYear")
    public WebElement year;

    @FindBy(id = "address1")
    public WebElement address;

    @FindBy(xpath = "//input[@id = 'submit']")
    public WebElement confirm;

    // Patient's page
    @FindBy(css = "span[class='PersonName-givenName']")
    public WebElement givenName;

    @FindBy(css = "div[class='float-sm-right']>span")
    public WebElement patientID;

    // Find Patient Record
    @FindBy(css = "div[id='apps'] :nth-child(1)")
    public WebElement findPatientRecord;

    @FindBy(css = "table[id='patient-search-results-table']>tbody>tr")
    public List<WebElement> patientRecordList;

    @FindBy(id = "patient-search")
    public WebElement patientSearch;

    @FindBy(css = "div[class='col-12 col-lg-6']>div")
    public List<WebElement> patientInformation;

    @FindBy(css="[id='user-account-menu']")
    public WebElement userAccount;

    @FindBy(css="[id='tasks'] .button:nth-child(1)")
    public WebElement changePassword;

    @FindBy(css = "[id='tasks'] .button:nth-child(2)")
    public WebElement myLanguage;

    @FindBy(xpath = "//td[text()='No matching records found']")
    public WebElement empty;

    @FindBy(xpath = "//tbody[@role='alert']/tr[1]")
    public WebElement patient;

    @FindBy(xpath = "//div[@class='col-12 col-lg-3 p-0']/div/ul/li[8]")
    public WebElement deletePatient;

    @FindBy(xpath = "//div[@id='delete-patient-creation-dialog']/div[2]/input")
    public WebElement reason;

    @FindBy(xpath = "//div[@id='delete-patient-creation-dialog']/div[2]/button")
    public WebElement confirmRight;
}
