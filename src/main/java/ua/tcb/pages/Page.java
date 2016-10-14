package ua.tcb.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;
import ua.tcb.common.CommElements;
import ua.tcb.webdriver.BasicTestCase;

/**
 * Created by Maksym_Mazurkevych on 2/24/2016.
 */
public abstract class Page extends CommElements{

    protected static String baseUrl = BasicTestCase.url;
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected boolean isFound=false;

    public Page(WebDriver driver) {
////        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 15);
        PageFactory.initElements(new HtmlElementDecorator(new HtmlElementLocatorFactory(driver)), this);
    }


    public abstract void open();

}
