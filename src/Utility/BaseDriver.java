package Utility;

import POM.ParentPage;
import org.apache.logging.log4j.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.time.Duration;

public class BaseDriver extends ParentPage {
    public static Logger logTutma = LogManager.getLogger();
    public static WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void beforeClass() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.get("https://openmrs.org/");
        langSet();
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        ParentPage.Wait(3);
        driver.quit();

        logTutma.info("Driver closed.");
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        logTutma.info("Method started.");

    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod(ITestResult sonuc) {
        logTutma.info(sonuc.getName() + " Method " + (sonuc.getStatus() == 1 ? "Passed." : "Failed."));

    }

    public void langSet() {
        WebElement element = driver.findElement(By.xpath("//*[@class='gt-current-lang']/span[1]"));
        if (!element.getText().equalsIgnoreCase("en")) {
            myClick(element);
            myClick(driver.findElement(By.cssSelector("[data-gt-lang='en']")));
        }
    }

    public void langCheck(){ // parameter?
        WebElement findPatientText= driver.findElement(By.cssSelector("div[id='apps'] :nth-child(1)"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(findPatientText));
        if (!findPatientText.getText().contains("Find")){
            myClick(driver.findElement(By.cssSelector("[id*='administration']")));
            myClick(driver.findElement(By.cssSelector("[id*='legacyAdmin']")));
            myClick(driver.findElement(By.cssSelector("[id='localeOptions']>a")));
            myClick(driver.findElement(By.cssSelector("[alt='OpenMRS Logo']")));
        }
    }
}
