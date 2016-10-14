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
@FindBy(xpath = "//div[@class='yourorser biginfotrip obr']")
public class ContentBlock extends CommElements {

    @FindBy(xpath = "//div[@class='allbut']")
    private WebElement register;

    public void registerClick() {
        register.click();
    }

    public WebElement getPlacesAbsent() {
        return placesAbsent;
    }

    @FindBy(xpath = "//span[text()='Місць немає!']")
    private WebElement placesAbsent;

}
