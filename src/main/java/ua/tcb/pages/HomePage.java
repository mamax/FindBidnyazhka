package ua.tcb.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;
import java.util.List;

/**
 * Created by Maksym_Mazurkevych on 2/24/2016.
 */
public class HomePage extends Page {

    @FindBy(xpath = "//a[@id='uLogin']/img")
    private WebElement logToolbar;

    @FindBy(xpath = "//div[@id='facebook']/a")
    private WebElement linkFb;

    @FindBy(xpath = "//a[@href=\"/travel/\"]")
    private WebElement travel;

    public WebElement getLogout() {
        return logout;
    }

    @FindBy(xpath = "//a[@href='/?logout']")
    private WebElement logout;

    public List<WebElement> getListOfPages() {
        return listOfPages;
    }

    @FindBy(xpath = "//center/a")
    private List<WebElement> listOfPages;

    public WebElement getList() {
        return list;
    }

    @FindBy(xpath = "//div[@id='wrapper']")
    private WebElement list;

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

    public WebElement getLinkFb() {
        return linkFb;
    }

    public void clickFacebook() {
        linkFb.click();
    }

    public void navigateToTravels() {
        travel.click();
    }
}
