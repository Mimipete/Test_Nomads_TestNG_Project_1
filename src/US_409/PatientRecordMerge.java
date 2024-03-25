package US_409;

import POM.HomePageContent;
import POM.LoginContent;
import Utility.BaseDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PatientRecordMerge extends BaseDriver {
    @Test(groups = {"Regression","PatientManagement"})
    public void TC_PatientRecordMerge(){
        LoginContent lc= new LoginContent();
        HomePageContent hc= new HomePageContent();

        myJsClick(lc.demoButton);
        myJsClick(lc.exploreOpenMRS2);
        myJsClick(lc.exploreOpenMRS2Demo);
        Assert.assertEquals(driver.getCurrentUrl(), "https://demo.openmrs.org/openmrs/login.htm", "User couldn't land on the login page of Demo OpenMRS");
        mySendKeys(lc.username,"admin");
        mySendKeys(lc.password,"Admin123");
        myClick(lc.locations.getFirst());
        myClick(lc.logInButton);
        Assert.assertNotNull(hc.logoutButton,"Login failed!");

    }
}
