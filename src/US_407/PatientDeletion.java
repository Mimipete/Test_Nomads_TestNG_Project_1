package US_407;

import POM.LoginContent;
import Utility.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.plaf.PanelUI;

import static Utility.BaseDriver.driver;

public class PatientDeletion extends BaseDriver {

    @Test
    public void TC_PatientDeletion() {
        DeletePatient dp = new DeletePatient();
        LoginContent lc = new LoginContent();

        myJsClick(lc.demoButton);
        myClick(lc.exploreOpenMRS2);
        myJsClick(lc.exploreOpenMRS2Demo);
        mySendKeys(lc.username, "admin");
        mySendKeys(lc.password, "Admin123");
        myClick(dp.InpatientWard);
        myClick(lc.logInButton);

        myClick(dp.FindPatientRecord);
        mySendKeys(dp.patientSearch,"sarah ba");
        myClick(dp.patient);
        myClick(dp.DeletePatient);
        mySendKeys(dp.reason, "discharged");
        myClick(dp.Confirm);




    }
}
