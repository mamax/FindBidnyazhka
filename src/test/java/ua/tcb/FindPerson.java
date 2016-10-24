package ua.tcb;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ua.tcb.data.UserData;
import ua.tcb.pages.*;
import ua.tcb.util.SendMail;
import ua.tcb.webdriver.BasicTestCase;

/**
 * Created by Maksym_Mazurkevych on 2/24/2016.
 */
@Listeners(ua.tcb.webdriver.Screenshot.class)
public class FindPerson extends BasicTestCase {

    private void logToApp(UserData admin) {
        WebDriverWait wait = new WebDriverWait(driver, 10);

        HomePage homePage = new HomePage(driver);
        homePage.open();
        LoginPage loginPage = homePage.loginToolbarClick();

        FaceBookPage faceBookPage = loginPage.loginThrowFaceBook();
        faceBookPage.EnterCredentials(admin.name, admin.pass);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='maska']")));
    }

    @Test
    public void testFindPerson() throws Exception {
        logToApp(admin);
        HomePage homePage = new HomePage(driver);
        homePage.open();
        TravelPage travelPage = homePage.navigateToTripsPage();
        if (travelPage.selectJourney(nameToFind)){
            SendMail.mailScreenShot();
        }
    }

}
