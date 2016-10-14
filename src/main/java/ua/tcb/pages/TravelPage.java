package ua.tcb.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ua.tcb.webdriver.BasicTestCase;

import java.io.IOException;
import java.util.List;

/**
 * Created by msks on 24.02.2016.
 */
public class TravelPage extends Page {

    @FindBy(xpath="//a[text()='Детальніше']")
    private List<WebElement> ButonsMore;

    @FindBy(xpath = "//input[@name='igeerule']")
    private WebElement ChkbRules;

    @FindBy(xpath = "//input[@name='igeerule2']")
    private WebElement ChkbDogovir;

    @FindBy(xpath = "//input[@name='iamanonim']")
    private WebElement ChkbData;

    public TravelPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open() {
        driver.get(baseUrl + "trips/");
    }

    public boolean selectJourney(String nameToFind) throws IOException, InterruptedException {
        if (!isFound){
            for(int i=0; i < ButonsMore.size(); i++){
                ButonsMore.get(i).click();
                FirstStepBuy firstStepBuy = new FirstStepBuy(driver);
                wait.until(ExpectedConditions.visibilityOf(firstStepBuy.getH3tag()));
                System.out.println("----- " + firstStepBuy.getH3tag().getText() + " -----");

                if (isPresentAndDisplayed(firstStepBuy.getContentBlock().getPlacesAbsent())){
                    System.out.println(firstStepBuy.getContentBlock().getPlacesAbsent().getText());
                    driver.navigate().back();
                }
                else
                {
                    firstStepBuy.getContentBlock().registerClick();
                    Thread.sleep(200L);
                    wait.until(ExpectedConditions.visibilityOf(firstStepBuy.getRegisterBlock().getNextStepButton()));
                    ChkbRules.click();
                    ChkbDogovir.click();
                    ChkbData.click();

//                    else {
//                        wait.until(ExpectedConditions.visibilityOfAllElements(firstStepBuy.getRegisterBlock().getChbButtons()));
//                        for (int rr = 1; rr < firstStepBuy.getRegisterBlock().getChbButtons().size(); rr++) {
//                            firstStepBuy.getRegisterBlock().getChbButtons().get(rr).click();
//                        }
//
                    firstStepBuy.getRegisterBlock().getNextStepButton().click();
                    Thread.sleep(200L);
                    wait.until(ExpectedConditions.visibilityOfAllElements(firstStepBuy.getRegisterBlock().getListOfCells()));
                    for (WebElement cell : firstStepBuy.getRegisterBlock().getListOfCells())
                    if (cell.getAttribute("title").contains(nameToFind))
                    {
                                            System.out.println("Found " + nameToFind );
                                            BasicTestCase.captureScreenShot(nameToFind);
                                            isFound = true;
                                            return true;
                                        }
                        navigateBackTimes();
                }
            }
        }

        return false;
    }

    /**
     * Navigates back to enter point
     */
    private void navigateBackTimes() {
        System.out.println("Name is not found in this journey");
        driver.navigate().back();
        driver.navigate().back();
        driver.navigate().back();
    }


}
