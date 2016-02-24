package ua.tcb;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ua.tcb.pages.HomePage;
import ua.tcb.pages.TravelPage;
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
        WebDriverWait wait = new WebDriverWait(driver, 15);

        HomePage homePage = new HomePage(driver);
        TravelPage travelPage = homePage.navigateToTravelPage();

        //some code to to on first page
        selectJourney(wait, travelPage);

        //some code to go on father pages
        for (int i = 0; i < travelPage.getListOfPages().size() - 1; i++) {
            travelPage.getListOfPages().get(i).click();
            selectJourney(wait, travelPage);
        }
    }

    private void selectJourney(WebDriverWait wait, TravelPage travelPage) {
        for (int j = 0; j < travelPage.getEntryBlock().getOrderButtons().size(); j++){
            travelPage.getEntryBlock().getOrderButtons().get(j).click();

            if (isPresentAndDisplayed(travelPage.getContentBlock().getErrorMsg())){
                driver.navigate().back();
            }
            else
            {
                travelPage.getContentBlock().registerClick();
                travelPage.getContentBlock().radioBtnClick();
                wait.until(ExpectedConditions.visibilityOf(travelPage.getContentBlock().getPlaceTable()));

                for (int tr=1; tr <= travelPage.getContentBlock().getListOfTrs().size(); tr++){
                    for(int td = 1;td <= travelPage.getContentBlock().getListOfTds().size(); td++){
                        if (driver.findElement(By.xpath("//table[@class='bus']/tbody/tr[" + tr + "]/td[" + td + "]")).getAttribute("title").contains("Гарбар Валентина")){
//                            takescreenshot();
                            System.out.println("Знайшов");
                            break;
                        }
                        else
                            {
                                driver.navigate().back();
                                driver.navigate().back();
                            }
                    }
                }

            }
        }
    }

}
