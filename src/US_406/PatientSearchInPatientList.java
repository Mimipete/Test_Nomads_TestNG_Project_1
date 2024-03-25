package US_406;

import POM.HomePageContent;
import POM.LoginContent;
import Utility.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PatientSearchInPatientList extends BaseDriver {
    @Test
    public void TC_PatientSearchInPatientList(){
        LoginContent lc = new LoginContent();
        HomePageContent hpc = new HomePageContent();
        //-----
        myJsClick(lc.demoButton);
        myClick(lc.exploreOpenMRS2);
        myJsClick(lc.exploreOpenMRS2Demo);
        //------
        mySendKeys(lc.username, "admin");
        mySendKeys(lc.password, "Admin123");
        myClick(lc.locations.get(RandomGenerator(lc.locations.size()-1, 1)));
        myClick(lc.logInButton);

        myClick(hpc.findPatientRecord);
        System.out.println("**1. "+hpc.patientRecordList.getFirst().getText());
        mySendKeys(hpc.patientSearch,"100HVL");
        System.out.println("** "+hpc.patientRecordList.getFirst().getText());


        //System.out.println(driver.findElement(By.cssSelector("1. "+"tr[class='odd']>td[class='dataTables_empty']")).getText());
        //System.out.println(driver.findElement(By.cssSelector("2. "+"td[class='dataTables_empty']")).getText());

        //Assert.assertTrue(hpc.patientRecordList.get(0).findElement(By.cssSelector("[class='odd']>td")).getText().contains("100HVL"));

    }
}
