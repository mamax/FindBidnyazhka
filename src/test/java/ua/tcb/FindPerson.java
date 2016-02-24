package ua.tcb;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ua.tcb.pages.HomePage;
import ua.tcb.webdriver.BasicTestCase;

import java.io.IOException;

/**
 * Created by Maksym_Mazurkevych on 2/24/2016.
 */
public class FindPerson extends BasicTestCase {

    @BeforeMethod
    public void logToApp() throws InterruptedException, IOException {
        WebDriverWait wait = new WebDriverWait(driver, 15);

        HomePage homePage = new HomePage(driver);
        homePage.loginToolbarClick();
        String winHandleBefore = driver.getWindowHandle();
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(1));
//        driver.switchTo().frame(1);
//        driver.findElement(By.xpath("//div[@id='wrapper']"));

        Thread.sleep(4000L);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='facebook']/a")));
        driver.findElement(By.xpath("//div[@id='facebook']/a")).click();

//        driver.switchTo().defaultContent();
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }

        driver.findElement(By.id("email")).sendKeys(admin.name);
        driver.findElement(By.id("pass")).sendKeys(admin.pass);
        driver.findElement(By.id("loginbutton")).click();

        // Close the new window, if that window no more required
//                driver.close();

        // Switch back to original browser (first window)
        driver.switchTo().window(winHandleBefore);

//        wait.until(ExpectedConditions.visibilityOf(homePage.getList()));
        Thread.sleep(1000L);
        wait.until(ExpectedConditions.visibilityOf(homePage.getLogout()));
    }

    @Test
    public void testFindPerson() throws IOException {
        HomePage homePage = new HomePage(driver);
        homePage.navigateToTravels();

        //some code to to on firstpage

        for (int i = 0; i< homePage.getListOfPages().size() - 1; i++){
            homePage.getListOfPages().get(i).click();

            //some code to to on firstpage
        }
    }
}
