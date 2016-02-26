package ua.tcb;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ua.tcb.pages.FirstStepBuy;
import ua.tcb.pages.HomePage;
import ua.tcb.pages.TravelPage;
import ua.tcb.webdriver.BasicTestCase;

import java.io.IOException;

/**
 * Created by Maksym_Mazurkevych on 2/24/2016.
 */
@Listeners(ua.tcb.webdriver.Screenshot.class)
public class FindPerson extends BasicTestCase {

    @BeforeMethod
    public void logToApp() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 15);

        HomePage homePage = new HomePage(driver);
        homePage.loginToolbarClick();

        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(1));
//        driver.switchTo().frame(1);
        driver.switchTo().activeElement();

        Thread.sleep(7000L);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='facebook']/a")));
        driver.findElement(By.xpath("//div[@id='facebook']/a")).click();
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        String winHandleBefore = driver.getWindowHandle();
        //switch to another window
//        driver.switchTo().defaultContent();
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }
//      actions on another page
        driver.findElement(By.id("email")).sendKeys(admin.name);
        driver.findElement(By.id("pass")).sendKeys(admin.pass);
        driver.findElement(By.id("loginbutton")).click();

        // Close the new window, if that window no more required
//                driver.close();

        // Switch back to original browser (first window)
        driver.switchTo().window(winHandleBefore);

        Thread.sleep(1000L);
        wait.until(ExpectedConditions.visibilityOf(homePage.getLogout()));
    }

    @Test
    public void testFindPerson() throws IOException {
        WebDriverWait wait = new WebDriverWait(driver, 15);

        HomePage homePage = new HomePage(driver);
        TravelPage travelPage = homePage.navigateToTravelPage();

        //some code to to on first page
        selectJourney(wait);

        //some code to go on father pages
        for (int i = 0; i < travelPage.getListOfPages().size() - 1; i++) {
            driver.get(baseUrl +"/travel/?pageq=" + (2+i));
            selectJourney(wait);
        }
    }

    private void selectJourney(WebDriverWait wait) throws IOException {
        outer:
        for (int j = 0; j < driver.findElements(By.xpath("//a[text()='Замовити']")).size(); j++){
            driver.findElements(By.xpath("//a[text()='Замовити']")).get(j).click();
            FirstStepBuy firstStepBuy = new FirstStepBuy(driver);

            if (isPresentAndDisplayed(firstStepBuy.getContentBlock().getErrorMsg())){
                driver.navigate().back();
            }
            else
            {
                firstStepBuy.getContentBlock().registerClick();
                if (isPresentAndDisplayed(firstStepBuy.getErrorMsg())){
                    navigateBackTwoTimes();
                }
                else {
                    firstStepBuy.getContentBlock().radioBtnClick();
                    System.out.println("----- " + firstStepBuy.getH3tag().getText() + "------");
                    wait.until(ExpectedConditions.visibilityOf(firstStepBuy.getContentBlock().getPlaceTable()));

                    for (int tr = 1; tr <= firstStepBuy.getContentBlock().getListOfTrs().size(); tr++)
                        for (int td = 1; td <= firstStepBuy.getContentBlock().getListOfTds().size(); td++) {
                            System.out.println(driver.findElement(By.xpath("//table[@class='bus']/tbody/tr[" + tr + "]/td[" + td + "]")).getAttribute("title"));
                            if (driver.findElement(By.xpath("//table[@class='bus']/tbody/tr[" + tr + "]/td[" + td + "]")).getAttribute("title").contains(nameToFind)) {
                                System.out.println("found");
                                captureScreenShot(nameToFind);
                                navigateBackTwoTimes();
                                break outer;
                            }
                        }
                    navigateBackTwoTimes();
                }
            }
        }
    }

    private void navigateBackTwoTimes() {
        driver.navigate().back();
        driver.navigate().back();
    }

}
