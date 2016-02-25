package ua.tcb.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;

/**
 * Created by Maksym_Mazurkevych on 2/24/2016.
 */
public class HomePage extends Page {

    @FindBy(xpath = "//a[@id='uLogin']/img")
    private WebElement logToolbar;

    @FindBy(xpath = "//a[@href='/travel/']")
    private WebElement travel;

    public WebElement getLogout() {
        return logout;
    }

    @FindBy(xpath = "//a[@href='/?logout']")
    private WebElement logout;

    public HomePage(WebDriver driver) throws IOException {
        super(driver);
    }

    @Override
    public void open(String text) {
        driver.get(baseUrl);
    }

    public void loginToolbarClick() {
        logToolbar.click();
    }

    public TravelPage navigateToTravelPage(){
        travel.click();
        return new TravelPage(driver);
    }
}
