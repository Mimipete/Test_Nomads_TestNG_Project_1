package US_407;

import POM.LoginContent;
import Utility.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.plaf.PanelUI;

import java.time.Duration;

import static Utility.BaseDriver.driver;

public class PatientDeletion extends BaseDriver {

    @Test(groups = {"Smoke", "PatientManagement"})
    public void TC_PatientDeletion() {
        DeletePatient dp = new DeletePatient();
        LoginContent lc = new LoginContent();
        WebDriverWait wait = new WebDriverWait(BaseDriver.driver, Duration.ofSeconds(20));

        myJsClick(lc.demoButton);
        myClick(lc.exploreOpenMRS2);
        myJsClick(lc.exploreOpenMRS2Demo);
        mySendKeys(lc.username, "admin");
        mySendKeys(lc.password, "Admin123");
        myClick(dp.InpatientWard);
        myClick(lc.logInButton);

        myClick(dp.FindPatientRecord);
        mySendKeys(dp.patientSearch,"100DEM");
        myClick(dp.patient);
        myClick(dp.DeletePatient);
        mySendKeys(dp.reason, "discharged");
        myClick(dp.Confirm);
        mySendKeys(dp.patientSearch,"100DEM");
        wait.until(ExpectedConditions.visibilityOf(dp.empty));
        Assert.assertTrue(dp.empty.getText().contains("No matching records found"));



    }
}
