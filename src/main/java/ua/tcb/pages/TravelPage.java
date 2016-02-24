package ua.tcb.pages;

import org.openqa.selenium.WebDriver;
import ua.tcb.pages.blocks.ContentBlock;
import ua.tcb.pages.blocks.EntryBlock;

import java.io.IOException;

/**
 * Created by msks on 24.02.2016.
 */
public class TravelPage extends Page {

    public TravelPage(WebDriver driver) throws IOException {
        super(driver);
    }

    @Override
    public void open(String text) {
        driver.get(baseUrl + "travel/");
    }

    public EntryBlock getEntryBlock() {
        return entryBlock;
    }

    EntryBlock entryBlock;

    public ContentBlock getContentBlock() {
        return contentBlock;
    }

    ContentBlock contentBlock;
}
