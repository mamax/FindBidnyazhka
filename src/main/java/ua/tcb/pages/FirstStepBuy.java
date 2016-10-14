package ua.tcb.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ua.tcb.pages.blocks.ContentBlock;
import ua.tcb.pages.blocks.RegisterBlock;

/**
 * Created by Maksym_Mazurkevych on 2/25/2016.
 */
public class FirstStepBuy extends Page {

    public FirstStepBuy(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open() {
    }

    public ContentBlock getContentBlock() {
        return contentBlock;
    }

    private ContentBlock contentBlock;

    public RegisterBlock getRegisterBlock() {
        return registerBlock;
    }

    private RegisterBlock registerBlock;

    public WebElement getErrorMsg() {
        return errorMsg;
    }

    @FindBy(xpath = "//div[@class='redblock']")
    private WebElement errorMsg;

    @FindBy(xpath = "//div[@class='tourtext']/h1")
    private WebElement h3tag;

    public WebElement getH3tag() {
        return h3tag;
    }
}
