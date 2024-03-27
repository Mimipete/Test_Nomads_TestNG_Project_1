package POM;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

import static Utility.BaseDriver.driver;

public class ParentPage {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    public void myClick(WebElement element) {
        scrollToElement(element);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public void myJsClick(WebElement element) {
        scrollToElement(element);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }

    public void mySendKeys(WebElement element, String text) {
        wait.until(ExpectedConditions.visibilityOf(element));
        scrollToElement(element);
        element.clear();
        element.sendKeys(text);
    }

    public void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void verifyContainsText(WebElement element, String value) {
        wait.until(ExpectedConditions.textToBePresentInElement(element, value));
        Assert.assertTrue(element.getText().toLowerCase().contains(value.toLowerCase()));
    }

    public static void Wait(long sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean isClickable(WebElement element) {
        String url = driver.getCurrentUrl();
        element.click();
        String url2 = driver.getCurrentUrl();
        if (url.equalsIgnoreCase(url2)) {
            return false;
        } else {
            driver.navigate().back();
        }
        return true;
    }

    public static int RandomGenerator(int max, int min) {
        return (int) (Math.random() * (max - min + 1));
    }

    public static boolean ListContainsString(List<WebElement> list, String string) {
        boolean condition = false;
        for (WebElement e : list) {
            if (e.getText().equalsIgnoreCase(string))
                condition = true;
        }
        return condition;
    }

    public static void WaitNano(long sec) {
        try {
            Thread.sleep(sec * 100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
