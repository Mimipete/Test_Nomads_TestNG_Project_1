package US_401;

import POM.LoginContent;
import Utility.BaseDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CheckingLoginErrorsInTheSystem extends BaseDriver {
    @Test(dataProvider = "credentials", groups = {"Smoke", "Login"})
    public void TC_CheckingLoginErrorsInTheSystem(String username, String password, int location) {

        LoginContent lc = new LoginContent();
        myJsClick(lc.demoButton);
        myClick(lc.exploreOpenMRS2);
        myJsClick(lc.exploreOpenMRS2Demo);
        mySendKeys(lc.username, username);
        mySendKeys(lc.password, password);
        if (location!=8){
            myClick(lc.locations.get(location));
        }
        myClick(lc.logInButton);
        if (location==8){
            Assert.assertEquals(lc.LocationAlert.getText(), "You must choose a location!", "Login basarili");
        }
        else ()



    }

    @DataProvider
    Object[][] credentials() {
        Object[][] invalidDatas =
                {
                        {"admin", "", 1},
                        {"", "Admin123",0},
                        {"admin", "Admin123",8},
                        {"", "", 4},
                        {"admin", "", 8},
                        {"", "", 8},
                };
        return invalidDatas;
    }
}
