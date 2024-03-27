package US_409;

import POM.HomePageContent;
import POM.LoginContent;
import POM.ParentPage;
import Utility.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class PatientRecordMerge extends BaseDriver {
    @Test(groups = {"Regression", "PatientManagement"}, priority = 9)
    public void TC_PatientRecordMerge() {
        LoginContent lc = new LoginContent();
        HomePageContent hc = new HomePageContent();
        List<String> patientIDs = new ArrayList<>();

        myJsClick(lc.demoButton);
        myJsClick(lc.exploreOpenMRS2);
        myJsClick(lc.exploreOpenMRS2Demo);
        Assert.assertEquals(driver.getCurrentUrl(), "https://demo.openmrs.org/openmrs/login.htm", "User couldn't land on the login page of Demo OpenMRS");
        mySendKeys(lc.username, "admin");
        mySendKeys(lc.password, "Admin123");
        myClick(lc.locations.getFirst());
        myClick(lc.logInButton);
        langCheck();
        Assert.assertNotNull(hc.logoutButton, "Login failed!");
        myClick(hc.findPatientRecord);
        patientIDs.add(hc.patientRecordList.get(0).findElement(By.cssSelector("td")).getText().substring(0, 6));
        patientIDs.add(hc.patientRecordList.get(1).findElement(By.cssSelector("td")).getText().substring(0, 6));
        driver.navigate().back();
        myClick(hc.dataManagementButton);
        myClick(hc.mergePatientButton);
        mySendKeys(hc.inputID.getFirst(), patientIDs.getFirst());
        mySendKeys(hc.inputID.get(1), patientIDs.get(1) + Keys.ENTER);
        myClick(hc.continueButton);
        Assert.assertTrue(hc.mergeWarning.getText().contains("Merging cannot be undone!"), "The warning message for the merging process could not be displayed!");
        myClick(hc.patients.get(ParentPage.RandomGenerator(1, 0)));
        myClick(hc.confirmButton);
        Assert.assertTrue(hc.IDText.getText().contains(patientIDs.getFirst()), "Error");
        Assert.assertTrue(hc.IDText.getText().contains(patientIDs.get(1)), "Error");

    }
}
