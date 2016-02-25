package ua.tcb.pages.blocks;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ua.tcb.common.CommElements;

import java.util.List;

/**
 * Created by msks on 24.02.2016.
 */

@FindBy(xpath = "//div[@class='sometriap']")
public class EntryBlock extends CommElements {

    public List<WebElement> getOrderButtons() {
        return orderButtons;
    }

    @FindBy(xpath = "//a[text()='Зареєструвати!']")
    private List<WebElement> orderButtons;

    @FindBy(xpath = "//div[@class='redblock']")
    private WebElement errors;
}
