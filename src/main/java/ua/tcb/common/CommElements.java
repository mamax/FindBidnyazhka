package ua.tcb.common;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

import java.util.List;

@Name("Common elements")
@FindBy(xpath="//div[contains(@class,'main')]")
public class CommElements extends HtmlElement {

    private static final String BROWSER_FF = "firefox";
//    protected WebDriver driver;

    public void typeIn(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
    }

    protected boolean isPresentAndDisplayed(WebElement element) {
        try {
            element.isDisplayed();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

//    protected boolean isLoggedOut() {
//        if (isPresentAndDisplayed(loginButton)) {
//            return true;
//        } else
//            return false;
//    }
//
//    protected boolean isLoggedIn() {
//        if (isPresentAndDisplayed(logOutButton)) {
//            return true;
//        } else
//            return false;
//    }

    @Override
    public Rectangle getRect() {
        return null;
    }

    @Override
    public <X> X getScreenshotAs(OutputType<X> outputType) throws WebDriverException {
        return null;
    }
}
