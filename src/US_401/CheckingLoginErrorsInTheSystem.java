package US_401;

import POM.LoginContent;
import Utility.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckingLoginErrorsInTheSystem extends BaseDriver {
    @Test
    public void TC_CheckingLoginErrorsInTheSystem() {

        LoginContent lc = new LoginContent();
        myJsClick(lc.demoButton);
        myClick(lc.exploreOpenMRS2);
        myClick(lc.exploreOpenMRS2Demo);
        mySendKeys(lc.username, "");
        mySendKeys(lc.password, "");
        myClick(lc.logInButton);
        Assert.assertEquals(lc.LocationAlert.getText(), "You must choose a location!", "Login basarili");

    }

}
