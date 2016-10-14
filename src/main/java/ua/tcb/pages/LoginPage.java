package ua.tcb.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Maksym_Mazurkevych on 10/13/2016.
 */
public class LoginPage extends Page {

    @FindBy(id = "bfb")
    private WebElement ButtonFacebook;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open() {
        driver.navigate().to(baseUrl + "login/");
    }

    public FaceBookPage loginThrowFaceBook() {
        ButtonFacebook.click();
        return new FaceBookPage(driver);
    }
}
