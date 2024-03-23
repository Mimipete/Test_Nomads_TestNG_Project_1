package US_401;

import Utility.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckingLoginErrorsInTheSystem extends BaseDriver {
    @Test(groups = {"Smoke Test"})
    public void TC_CheckingLoginErrorsInTheSystem(){
        driver.get("https://openmrs.org/");

        WebElement demoButton= driver.findElement(By.xpath("//div[@class='zak-header-button zak-header-button--1']"));
        myClick(demoButton);
        //demoButton.click();

        WebElement openMrsButton2= driver.findElement(By.cssSelector("[href='#openmrs2']"));
        myClick(openMrsButton2);

        WebElement openMrsDemoButton= driver.findElement(By.linkText("https://demo.openmrs.org/openmrs/login.htm"));
        myClick(openMrsDemoButton);

        WebElement name= driver.findElement(By.id("username"));
        mySendKeys(name,null);

        WebElement password= driver.findElement(By.id("password"));
        mySendKeys(password,null);

        WebElement login= driver.findElement(By.id("loginButton"));
        myClick(login);

        WebElement aLocationAlert= driver.findElement(By.id("sessionLocationError"));
        Assert.assertEquals("Başarıyla giriş yaptınız!","You must choose a location!");

    }

}
