package POM;

import Utility.BaseDriver;
import org.openqa.selenium.support.PageFactory;

public class HomePageContent {
    public HomePageContent() {
        PageFactory.initElements(BaseDriver.driver,this);
    }
}
