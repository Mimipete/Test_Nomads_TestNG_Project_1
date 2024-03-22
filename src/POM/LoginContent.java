package POM;

import Utility.BaseDriver;
import org.openqa.selenium.support.PageFactory;

public class LoginContent {
    public LoginContent() {
        PageFactory.initElements(BaseDriver.driver,this);
    }

}
