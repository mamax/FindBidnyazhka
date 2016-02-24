package ua.tcb.common;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

import java.util.List;
import java.util.Random;

@Name("Common elements")
@FindBy(xpath="//div[contains(@class,'main')]")
public class CommElements extends HtmlElement {

    public List<WebElement> getListOfPages() {
        return listOfPages;
    }

    @FindBy(xpath = "//center/a")
    private List<WebElement> listOfPages;


    private static final String BROWSER_FF = "firefox";
//    protected WebDriver driver;
    private boolean acceptNextAlert = true;
    protected final static String pass = "123456";
    protected final String ssn = "197910252399";
    protected String baseUrl;
    private static final String DEVTEST = "//src//main//resources//application.properties";

    protected static String rndStrNum() {
        char[] chars = "0123456789".toCharArray();
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            char c = chars[random.nextInt(chars.length)];
            sb.append(c);
        }
        return sb.toString();
    }

    protected static String rndStrName() {
        char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            char c = chars[random.nextInt(chars.length)];
            sb.append(c);
        }
        return sb.toString();
    }



    public void typeIn(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
    }

    public void typeIn(WebElement element, int  val) {

        element.clear();
        element.sendKeys(String.valueOf(val));
    }

    public void typeEnter(WebElement element, String text) {
        typeIn(element, text);
        element.sendKeys(Keys.ENTER);
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
