package US_405;

import POM.LoginContent;
import Utility.BaseDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyAccount extends BaseDriver {
    @Test(groups = {"Smoke", "DependsOn"}, dependsOnMethods = "US_402.PerformLoginInTheSystem.TC_PerformLoginInTheSystem")
    public void TC_MyAccount() {
        LoginContent lc = new LoginContent();
        myJsClick(lc.demoButton);
        myClick(lc.exploreOpenMRS2);
        myJsClick(lc.exploreOpenMRS2Demo);
        mySendKeys(lc.username, "admin");
        mySendKeys(lc.password, "Admin123");
        myClick(lc.locations.get(RandomGenerator(lc.locations.size() - 1, 0)));
        myClick(lc.logInButton);
        Actions dAct = new Actions(driver);
        dAct.moveToElement(lc.profileIcon).perform();
        myClick(lc.userAccount);
        Assert.assertTrue(isClickable(lc.changePassword));
        Assert.assertTrue(isClickable(lc.myLanguage));
    }
}