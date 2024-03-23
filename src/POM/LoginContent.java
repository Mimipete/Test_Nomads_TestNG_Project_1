package POM;

import Utility.BaseDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginContent {
    public LoginContent() {
        PageFactory.initElements(BaseDriver.driver, this);
    }
    @FindBy(css = "a[class='zak-button']")
    public WebElement demoButton;
    @FindBy(xpath = "(//span[@class='elementor-button-text'])[2]")
    public WebElement exploreOpenMRS2;
    @FindBy(xpath = "//*[text()='Enter the OpenMRS 2 Demo']")
    public WebElement exploreOpenMRS2Demo;
    @FindBy(id = "username")
    public WebElement username;
    @FindBy(id = "password")
    public WebElement password;
    @FindBy(css = "ul[id='sessionLocation']>li:nth-child(1)")
    public WebElement location;
    @FindBy(id = "loginButton")
    public WebElement logInButton;

    @FindBy(id = "sessionLocationError")
    public WebElement LocationAlert;

}
