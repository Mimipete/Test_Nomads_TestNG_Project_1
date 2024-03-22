package Utility;

import POM.ParentPage;
import org.apache.logging.log4j.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.time.Duration;

public class BaseDriver extends ParentPage {
    public static Logger logTutma = LogManager.getLogger();
    public static WebDriver driver;

    @BeforeClass
    public void beforeClass() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.get("https://openmrs.org/");
        langSet();
    }

    @AfterClass
    public void afterClass() {
        ParentPage.Wait(3);
        driver.quit();

        logTutma.info("Driver closed.");
    }

    @BeforeMethod
    public void beforeMetod() {
        logTutma.info("Method started.");

    }

    @AfterMethod
    public void afterMetod(ITestResult sonuc) {
        logTutma.info(sonuc.getName() + " Method finished. " + (sonuc.getStatus() == 1 ? "Passed" : "Failed"));

    }

    public void langSet() {
        WebElement element = driver.findElement(By.xpath("//*[@class='gt-current-lang']/span[1]"));
        if (!element.getText().equals("en")) {
            myClick(element);
            myClick(driver.findElement(By.cssSelector("[data-gt-lang='en']")));
        }
    }
}
