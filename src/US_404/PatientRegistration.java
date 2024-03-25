package US_404;

import POM.HomePageContent;
import POM.LoginContent;
import Utility.BaseDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class PatientRegistration extends BaseDriver {
    @Test//(groups = {"Regression"}, dependsOnMethods = {"US_402.PerformLoginInTheSystem.TC_PerformLoginInTheSystem"})
    public void TC_PatientRegistration() {
        LoginContent lc = new LoginContent();
        HomePageContent hpc = new HomePageContent();
        //-----
        myJsClick(lc.demoButton);
        myClick(lc.exploreOpenMRS2);
        myJsClick(lc.exploreOpenMRS2Demo);
        //------
        mySendKeys(lc.username, "admin");
        mySendKeys(lc.password, "Admin123");
        myClick(lc.locations.get(RandomGenerator(lc.locations.size() - 1, 0)));
        myClick(lc.logInButton);

        myClick(hpc.registerAPatientButton);
        mySendKeys(hpc.given, "deneme1");
        mySendKeys(hpc.familyName, "deneme2");
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
        //Wait(2);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));  //****
        Assert.assertEquals(hpc.givenName.getText(), "deneme1", "Yanlış değer");
        Assert.assertTrue(hpc.patientID.isDisplayed());
        System.out.println(hpc.patientID.getText());

    }
}
