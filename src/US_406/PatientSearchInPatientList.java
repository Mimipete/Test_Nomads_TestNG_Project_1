package US_406;

import POM.HomePageContent;
import POM.LoginContent;
import Utility.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class PatientSearchInPatientList extends BaseDriver {
    @Test(groups = {"PatientManagement"})
    public void TC_PatientSearchInPatientList() {
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
        mySendKeys(hpc.patientSearch, "100KK3");
        wait.until(ExpectedConditions.textToBe(By.xpath("//tr[@class='odd']/td[2]"), "Test Nomads"));
        Assert.assertTrue(hpc.patientRecordList.getFirst().isEnabled());
        myJsClick(hpc.patientRecordList.getFirst());
        for (int i = 0; i < hpc.patientInformation.size(); i++) {
            Assert.assertTrue(hpc.patientInformation.get(i).isDisplayed());
        }
        driver.navigate().back();
        mySendKeys(hpc.patientSearch, "100ABC");
        wait.until(ExpectedConditions.visibilityOf(hpc.empty));
        Assert.assertEquals(hpc.empty.getText(), "No matching records found");
    }
}