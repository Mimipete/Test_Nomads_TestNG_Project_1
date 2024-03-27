package US_403;

import POM.HomePageContent;
import POM.LoginContent;
import Utility.BaseDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PerformLogoutFromTheSystem extends BaseDriver {
    @Test(groups = {"Smoke", "Logout"})
    public void TC_PerformLogoutFromTheSystem() {
        LoginContent lc = new LoginContent();
        HomePageContent hpc = new HomePageContent();
        myJsClick(lc.demoButton);
        myClick(lc.exploreOpenMRS2);
        myJsClick(lc.exploreOpenMRS2Demo);
        mySendKeys(lc.username, "admin");
        mySendKeys(lc.password, "Admin123");
        myClick(lc.locations.getFirst());
        myClick(lc.logInButton);
        Assert.assertEquals(hpc.selectedLocation.getText(), "Inpatient Ward");
        Assert.assertTrue(hpc.logoutButton.isDisplayed());
        myClick(hpc.logoutButton);
        Assert.assertEquals(driver.getTitle(), "Login", "Failed to return to the login page.");
    }
}