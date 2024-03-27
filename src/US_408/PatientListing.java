package US_408;

import POM.LoginContent;
import Utility.BaseDriver;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PatientListing extends BaseDriver {
    @Test(groups = {"Regression", "Patient Management"})
    public void TC_PatientListing() {
        LoginContent lc = new LoginContent();
        myClick(lc.demoButton);
        myClick(lc.exploreOpenMRS2);
        myClick(lc.exploreOpenMRS2Demo);
        mySendKeys(lc.username, "admin");
        mySendKeys(lc.password, "Admin123");
        myClick(driver.findElement(By.cssSelector("[id='Inpatient Ward']")));
        myClick(driver.findElement(By.cssSelector("[id='loginButton']")));

        myClick(lc.findPatientRecord);

        int nmr = lc.patientRecordList.size();
        String[] nmr2 = lc.numbers.getText().split(" ");
        int nmr3 = Integer.parseInt(nmr2[5]);
        int nmr4=Integer.parseInt(nmr2[3]);
        while (nmr4!=nmr3) {
            myClick(lc.next);
            nmr += lc.patientRecordList.size();
            nmr2=lc.numbers.getText().split(" ");
            nmr3=Integer.parseInt(nmr2[5]);
            nmr4=Integer.parseInt(nmr2[3]);
        }
        Assert.assertEquals(nmr, nmr3, "bomboclatt!");
    }
}
