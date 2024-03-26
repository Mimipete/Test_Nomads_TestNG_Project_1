package US_404;

import POM.HomePageContent;
import POM.LoginContent;
import Utility.BaseDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class PatientRegistration extends BaseDriver {
    @Test(groups = {"Regression", "DependsOn"}, dependsOnMethods = {"US_402.PerformLoginInTheSystem.TC_PerformLoginInTheSystem"})
    public void TC_PatientRegistration() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        LoginContent lc = new LoginContent();
        HomePageContent hpc = new HomePageContent();

        myJsClick(lc.demoButton);
        myClick(lc.exploreOpenMRS2);
        myJsClick(lc.exploreOpenMRS2Demo);
        mySendKeys(lc.username, "admin");
        mySendKeys(lc.password, "Admin123");
        myClick(lc.locations.get(RandomGenerator(lc.locations.size() - 1, 0)));
        myClick(lc.logInButton);

        myClick(hpc.registerAPatientButton);
        mySendKeys(hpc.given, "Test");
        mySendKeys(hpc.familyName, "Nomads");
        myClick(hpc.nextButton);
        Select gender = new Select(hpc.gender);
        gender.selectByValue("M");
        myClick(hpc.nextButton);
        mySendKeys(hpc.day, "2");
        Select month = new Select(hpc.month);
        month.selectByValue("1");
        mySendKeys(hpc.year, "2000");
        myClick(hpc.nextButton);
        mySendKeys(hpc.address, "Türkiye");
        myClick(hpc.nextButton);
        myClick(hpc.nextButton);
        myClick(hpc.nextButton);
        myClick(hpc.confirm);
        wait.until(ExpectedConditions.visibilityOf(hpc.givenName));
        Assert.assertTrue(hpc.givenName.isDisplayed(), "Patient name could not be displayed.");
        Assert.assertEquals(hpc.givenName.getText(), "Test", "The name displayed does not belong to the registered patient.");
        Assert.assertTrue(hpc.patientID.isDisplayed());
    }
}
