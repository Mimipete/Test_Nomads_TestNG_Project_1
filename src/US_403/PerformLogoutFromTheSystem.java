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
        int index = RandomGenerator(lc.locations.size() - 1, 0);
        String selectedLocations = lc.locations.get(index).getText();
        myClick(lc.locations.get(index));
        myClick(lc.logInButton);
        Assert.assertEquals(hpc.selectedLocation.getText(), selectedLocations, "The selected location could not be displayed on the page.");
        Assert.assertTrue(hpc.logoutButton.isDisplayed());
        myClick(hpc.logoutButton);
        Assert.assertEquals(driver.getTitle(), "Login", "Failed to return to the login page.");
    }
}