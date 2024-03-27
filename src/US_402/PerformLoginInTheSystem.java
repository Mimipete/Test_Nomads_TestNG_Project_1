package US_402;

import POM.LoginContent;
import Utility.BaseDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PerformLoginInTheSystem extends BaseDriver {
    @Test(groups = {"Smoke", "Login","DependsOn"}, dataProvider = "credentials")
    public void TC_PerformLoginInTheSystem(String name, String password) {
        LoginContent lc = new LoginContent();
        myJsClick(lc.demoButton);
        myClick(lc.exploreOpenMRS2);
        myJsClick(lc.exploreOpenMRS2Demo);
        mySendKeys(lc.username, name);
        mySendKeys(lc.password, password);
        myClick(lc.locations.getFirst());
        myClick(lc.logInButton);
        if (driver.getTitle().equals("Login")) {
            driver.get("https://openmrs.org/");
        }
    }

    @DataProvider
    Object[][] credentials() {
        Object[][] nameAndPassword = {
                {"", ""},
                {"admin", ""},
                {"", "Admin123"},
                {"invalid", "Admin123"},
                {"admin", "invalid"},
                {"invalid", "invalid"},
                {"admin", "Admin123"}
        };
        return nameAndPassword;
    }
}