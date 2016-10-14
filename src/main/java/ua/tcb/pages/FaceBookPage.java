package ua.tcb.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Maksym_Mazurkevych on 10/13/2016.
 */
public class FaceBookPage extends Page {

    @FindBy(id = "email")
    private WebElement InputMail;

    @FindBy(id = "pass")
    private WebElement InputPass;

    @FindBy(id = "loginbutton")
    private WebElement loginButton;

    public FaceBookPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open() {
    }

    public void EnterCredentials(String name, String pass) {
        ClearAndType(InputMail, name);
        ClearAndType(InputPass, pass);
        loginButton.click();

    }
}
