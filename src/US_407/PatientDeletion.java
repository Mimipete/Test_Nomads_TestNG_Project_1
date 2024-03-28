package US_407;

import POM.HomePageContent;
import POM.LoginContent;
import Utility.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class PatientDeletion extends BaseDriver {
    @Test(groups = {"Smoke", "PatientManagement"},priority = 7)
    public void TC_PatientDeletion() {
        WebDriverWait wait = new WebDriverWait(BaseDriver.driver, Duration.ofSeconds(20));
        LoginContent lc = new LoginContent();
        HomePageContent hpc = new HomePageContent();
        myJsClick(lc.demoButton);
        myClick(lc.exploreOpenMRS2);
        myJsClick(lc.exploreOpenMRS2Demo);
        mySendKeys(lc.username, "admin");
        mySendKeys(lc.password, "Admin123");
        myClick(lc.locations.get(RandomGenerator(lc.locations.size() - 1, 0)));
        myClick(lc.logInButton);
        myClick(hpc.findPatientRecord);
        mySendKeys(hpc.patientSearch, "100JNX");
        wait.until(ExpectedConditions.textToBe(By.xpath("//tr[@class='odd']/td[2]"), "Test Nomads"));
        myJsClick(hpc.patient);
        myClick(hpc.deletePatient);
        mySendKeys(hpc.reason, "discharged");
        myClick(hpc.confirmRight);
        mySendKeys(hpc.patientSearch, "100JNX");
        wait.until(ExpectedConditions.visibilityOf(hpc.empty));
        Assert.assertTrue(hpc.empty.getText().contains("No matching records found"));
    }
}
