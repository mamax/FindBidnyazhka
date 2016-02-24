package ua.tcb.pages.blocks;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ua.tcb.common.CommElements;

import java.util.List;

/**
 * Created by msks on 24.02.2016.
 */
@FindBy(xpath = "//div[@class='contentpadding']")
public class ContentBlock extends CommElements {

    @FindBy(xpath = "//input[@value=\"Зареєструвати!\"]")
    private WebElement register;

    @FindBy(xpath = "//input[@type='radio']")
    private WebElement radioBtn;

    @FindBy(xpath = "//table[@class='bus']/tbody/tr")
    private List<WebElement> listOfTrs;

    @FindBy(xpath = "//table[@class='bus']/tbody/tr[1]/td")
    private List<WebElement> listOfTds;

    public WebElement getErrorMsg() {
        return errorMsg;
    }

    @FindBy(xpath = "//div[@class='redblock']")
    private WebElement errorMsg;

    public WebElement getPlaceTable() {
        return placeTable;
    }

    @FindBy(xpath = "//table[@class='bus']")
    private WebElement placeTable;

    public void registerClick() {
        register.click();
    }

    public void radioBtnClick() {
        radioBtn.click();
    }

    public List<WebElement> getListOfTrs() {
        return listOfTrs;
    }

    public List<WebElement> getListOfTds() {
        return listOfTds;
    }
}
