package ua.tcb.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ua.tcb.pages.blocks.ContentBlock;

/**
 * Created by Maksym_Mazurkevych on 2/25/2016.
 */
public class FirstStepBuy extends Page {

    public FirstStepBuy(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open(String text) {
    }

    public ContentBlock getContentBlock() {
        return contentBlock;
    }

    private ContentBlock contentBlock;

    @FindBy(xpath = "//input[@value='Зареєструвати!']")
    private WebElement register;

    public void registerClick() {
        register.click();
    }

    public WebElement getErrorMsg() {
        return errorMsg;
    }

    @FindBy(xpath = "//div[@class='redblock']")
    private WebElement errorMsg;

    @Name("radio button")
    @FindBy(xpath = "//input[@type='radio']")
    private WebElement radioBtn;


    public WebElement getRadioBtn() {
        return radioBtn;
    }

    public void radioBtnClick() {
        radioBtn.click();
    }

}
