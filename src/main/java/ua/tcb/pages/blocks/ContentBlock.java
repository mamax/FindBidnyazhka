package ua.tcb.pages.blocks;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ua.tcb.common.CommElements;

import java.util.List;

/**
 * Created by msks on 24.02.2016.
 */
@Name("Content block")
@FindBy(xpath = "//div[@class='contentpadding']")
public class ContentBlock extends CommElements {

    @FindBy(xpath = "//table[@class='bus']/tbody/tr")
    private List<WebElement> listOfTrs;

    @FindBy(xpath = "//table[@class='bus']/tbody/tr[1]/td")
    private List<WebElement> listOfTds;

    public WebElement getPlaceTable() {
        return placeTable;
    }

    @FindBy(xpath = "//table[@class='bus']")
    private WebElement placeTable;

    public List<WebElement> getRadioBtns() {
        return radioBtn;
    }

    @Name("radio button")
    @FindBy(xpath = "//input[@name='bus']")
    private List<WebElement> radioBtn;

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

    public List<WebElement> getListOfTrs() {
        return listOfTrs;
    }

    public List<WebElement> getListOfTds() {
        return listOfTds;
    }
}
