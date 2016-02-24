package ua.tcb.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import ua.tcb.webdriver.BasicTestCase;

import java.io.IOException;

/**
 * Created by Maksym_Mazurkevych on 2/24/2016.
 */
public abstract class Page {

    protected WebDriver driver;
    protected String baseUrl = "https://tcb.vn.ua/login/";

    public Page(WebDriver driver) throws IOException {
        this.driver = BasicTestCase.setUp();
        PageFactory.initElements(driver, this);
    }

    public void type(WebElement webElement, String text){
        webElement.clear();
        webElement.sendKeys(text);
    }

    public abstract void open(String text);

    protected boolean isElementPresent(WebElement element) {
        try {
            element.isDisplayed();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
