package ua.tcb.pages.blocks;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ua.tcb.common.CommElements;

import java.util.List;

/**
 * Created by Maksym_Mazurkevych on 10/13/2016.
 */
@FindBy(xpath = "//div[@class='yourorser obr ordergrid']")
public class RegisterBlock extends CommElements {

    @Name("check box buttons")
    @FindBy(xpath = "//input[@type='checkbox']")
    private List<WebElement> radioBtn;

    @FindBy(xpath = "//div[@class='bused']/table/tbody/tr/td")
    private List<WebElement> listofCells;

    public List<WebElement> getChbButtons() {
        return radioBtn;
    }

    public WebElement getNextStepButton() {
        return nextStepButton;
    }

    @FindBy(xpath = "//div[text()='Наступний крок']")
    private WebElement nextStepButton;

    @FindBy(xpath = "//table[@id='flor1']/tbody/tr")
    private List<WebElement> listOfTrs;

    @FindBy(xpath = "//table[@id='flor1']/tbody/tr[1]/td")
    private List<WebElement> listOfTds;

    @FindBy(xpath = "//table[@class='bus']")
    private List<WebElement> ListOfTables;

    public List<WebElement> getListOfTrs() {
        return listOfTrs;
    }

    public List<WebElement> getListOfTds() {
        return listOfTds;
    }

    public List<WebElement> getListOfTables() {
        return ListOfTables;
    }

    public List<WebElement> getListOfCells() {
        return listofCells;
    }
}
