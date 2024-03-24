package US_407;

import Utility.BaseDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeletePatient {
    public DeletePatient() {
        PageFactory.initElements(BaseDriver.driver, this);
    }

    @FindBy(id = "Inpatient Ward")
    public WebElement InpatientWard;

    @FindBy(xpath = "//div[@class='row'][3]/div/a")
    public WebElement FindPatientRecord;

    @FindBy(css = "input[class='form-control']")
    public WebElement patientSearch;

    @FindBy(xpath = "//tbody[@role='alert']/tr[1]")
    public WebElement patient;

    @FindBy(xpath = "//div[@class='col-12 col-lg-3 p-0']/div/ul/li[8]")
    public WebElement DeletePatient;

    @FindBy(xpath = "//div[@id='delete-patient-creation-dialog']/div[2]/input")
    public WebElement reason;

    @FindBy(xpath = "//div[@id='delete-patient-creation-dialog']/div[2]/button")
    public WebElement Confirm;

    @FindBy(id = "patient-search")
    public WebElement patientSearch2;



}
