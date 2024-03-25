package Utility;

import POM.ParentPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.time.Duration;

public class BaseDriverParameter {
    public WebDriver driver;
    public static Logger logTutma = LogManager.getLogger();

    @BeforeClass
    @Parameters("browserType")
    public void beforeClass(String browserType) {

        switch (browserType.toLowerCase()) {
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            default:
                driver = new ChromeDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.get("https://openmrs.org/en");
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

}
