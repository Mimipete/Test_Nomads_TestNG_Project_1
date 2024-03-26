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
        myClick(lc.locations.get(0));
        myClick(lc.logInButton);

        if (driver.getTitle().equals("Login")) {
            driver.get("https://openmrs.org/");
        }
    }

    @DataProvider
    Object[][] credentials() {
        Object[][] nameAndpasswordd = {
                {"", ""},
                {"admin", ""},
                {"", "Admin123"},
                {"name4", "Admin123"},
                {"admin", "password4"},
                {"name6", "password2"},
                {"admin", "Admin123"}
        };
        return nameAndpasswordd;

    }
}

