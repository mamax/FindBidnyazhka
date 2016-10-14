package ua.tcb.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Maksym_Mazurkevych on 2/24/2016.
 */
public class HomePage extends Page {

    @FindBy(xpath = "//a[@href='/login/']")
    private WebElement logToolbar;

    @FindBy(xpath = "//a[@href='/trips/']")
    private WebElement travel;

    public WebElement getLogout() {
        return logout;
    }

    @FindBy(xpath = "//a[@href='/?logout']")
    private WebElement logout;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open() {
        driver.get(baseUrl);
    }

    public LoginPage loginToolbarClick() {
        logToolbar.click();
        return new LoginPage(driver);
    }

    public TravelPage navigateToTripsPage(){
        travel.click();
        return new TravelPage(driver);
    }
}
