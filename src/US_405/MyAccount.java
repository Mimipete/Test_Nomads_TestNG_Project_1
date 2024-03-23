package US_405;

import POM.LoginContent;
import Utility.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.awt.*;

public class MyAccount extends BaseDriver {
    @Test(groups = "Smoke")
    public void TC_MyAccount() throws InterruptedException, AWTException {
        LoginContent lc = new LoginContent();
        myClick(lc.demoButton);
        myClick(lc.exploreOpenMRS2);
        myClick(lc.exploreOpenMRS2Demo);
        mySendKeys(lc.username, "admin");
        mySendKeys(lc.password, "Admin123");
        myClick(driver.findElement(By.cssSelector("[id='Inpatient Ward']")));
        myClick(driver.findElement(By.cssSelector("[id='loginButton']")));
        driver.findElement(By.cssSelector("[id='navbarSupportedContent']"));

        Robot robot = new Robot();
        robot.mouseMove(1100, 180);

        //BEKLE
        myClick(driver.findElement(By.cssSelector("[id='user-account-menu']")));

        WebElement task1 = driver.findElement(By.cssSelector("[id='tasks'] .button:nth-child(1)"));
        myClick(task1);
        Assert.assertEquals("https://demo.openmrs.org/openmrs/adminui/myaccount/changePassword.page", driver.getCurrentUrl(), "booomedup");

        driver.navigate().back();//????
        Assert.assertEquals("https://demo.openmrs.org/openmrs/adminui/myaccount/myAccount.page", driver.getCurrentUrl(), "booomedup");

        WebElement task2 = driver.findElement(By.cssSelector("[id='tasks'] .button:nth-child(2)"));
        myClick(task2);
        Assert.assertEquals("https://demo.openmrs.org/openmrs/adminui/myaccount/changeDefaults.page", driver.getCurrentUrl(), "booomedup");

    }
}
