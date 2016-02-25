package ua.tcb.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ua.tcb.pages.blocks.ContentBlock;

import java.util.List;

/**
 * Created by msks on 24.02.2016.
 */
public class TravelPage extends Page {

    public TravelPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open(String text) {
        driver.get(baseUrl + "travel/");
    }

    public List<WebElement> getListOfPages() {
        return listOfPages;
    }

    @FindBy(xpath = "//center/a")
    private List<WebElement> listOfPages;

}
