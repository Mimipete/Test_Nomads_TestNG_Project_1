package US_406;

import POM.HomePageContent;
import POM.LoginContent;
import Utility.BaseDriver;
import org.openqa.selenium.By;
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
        myClick(lc.locations.get(RandomGenerator(lc.locations.size(), 1)));
        myClick(lc.logInButton);
        //*****
        myClick(hpc.findPatientRecord);
        // ID
        for (int i = 0; i <hpc.patientRecordList.size() ; i++) {
            String id=hpc.patientRecordList.get(i).findElement(By.cssSelector("table[id='patient-search-results-table']>tbody>tr>td")).getText();
        }

       // mySendKeys(hpc.patientSearch,hpc.patientRecordList.get(RandomGenerator(hpc.patientRecordList.size(),0)).getText());

    }
}
