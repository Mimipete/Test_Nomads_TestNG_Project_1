package US_407;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.plaf.PanelUI;

import static Utility.BaseDriver.driver;

public class PatientDeletion {

    @Test
    public void TC_PatientDeletion() {



        //  Doktor, "Hasta kaydı bul" [Find Patient Record] butonuna tıklar
        WebElement FindPatientRecord = driver.findElement(By.xpath("//div[@class='row'][3]/div/a"));
        FindPatientRecord.click();

        // Doktor, arama kutucuğuna listede bulmak istediği hastanın adını veya ID'sini girer
        WebElement patientSearch = driver.findElement(By.cssSelector("input[class='form-control']"));
        patientSearch.sendKeys("abdulkabir");

        // Doktor, arama sonucunda bulduğu hastanın üzerine tıklar.
        WebElement Patient = driver.findElement(By.xpath("//tbody[@role='alert']/tr[1]"));
        Patient.click();

        // Doktor, açılan yeni sayfada "General Actions" tabındaki [Delete Patient] linkini bulur ve tıklar.
        WebElement DeletePatient = driver.findElement(By.xpath("//div[@class='action-section']/ul[2]/li[6]"));
        DeletePatient.click();

        // Doktor onay kutusuna [SİLME SEBEBİ) yazarak silme işlemine onay verir
        WebElement reason = driver.findElement(By.xpath("//div[@id='delete-patient-creation-dialog']/div[2]/input"));
        reason.sendKeys("discharged");

        // Doktor, hastayı başarıyla siler.
        WebElement Confirm = driver.findElement(By.xpath("//div[@id='delete-patient-creation-dialog']/div[2]/button"));
        Confirm.click();


        //************************************************************************************************
        // Hastanın kayıtları sistemden silindigini tekrar aratarak kontrol ederiz
        WebElement patientSearch2 = driver.findElement(By.cssSelector("input[class='form-control']"));
        patientSearch2.sendKeys("abdulkabir");

        WebElement SearchResult = driver.findElement(By.cssSelector("td[valign='top']"));
        Assert.assertTrue(SearchResult.getText().contains("No matching records found"));





    }
}
