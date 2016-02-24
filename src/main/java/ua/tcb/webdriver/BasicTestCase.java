package ua.tcb.webdriver;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import ua.tcb.data.UserData;

import java.io.File;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * Created by Maksym_Mazurkevych on 2/24/2016.
 */
public class BasicTestCase {

//    protected static WebDriver driver;
    public static final String BROWSER_FF = "firefox";
    private static boolean isBrowserOpened = false;
    public static WebDriver dr = null;
    public static FirefoxDriver driver = null;
    public static Properties CONFIG = null;
    protected static String baseUrl =  "https://tcb.vn.ua";

    public UserData admin = new UserData("maksim.mazurkevych@gmail.com", "gtnhjdbx2014");

    @AfterTest(alwaysRun = true)
    public void tearDown() throws Exception {
        driver.quit();
        isBrowserOpened = false;
    }

    @BeforeClass
    public static WebDriver setUp() throws IOException {
        if (!isBrowserOpened) {

            FirefoxProfile profile = new FirefoxProfile();
            profile.addExtension(new File(System.getProperty("user.dir")
                    + "//src//main//resources//firebug-2.0.14-fx.xpi"));
            profile.addExtension(new File(System.getProperty("user.dir")
                    + "//src//main//resources//firepath-0.9.7.1-fx.xpi"));
            driver = new FirefoxDriver(profile);
            System.out.println("Opening " + BROWSER_FF);
            isBrowserOpened = true;
            driver.manage().window().setSize(new Dimension(1024, 1024));

            System.out.println("Dimension : " + driver.manage().window().getSize());
            driver.manage().timeouts().pageLoadTimeout(70, TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
            driver.manage().timeouts().setScriptTimeout(15, TimeUnit.SECONDS);
//            driver.manage().window().maximize();
            driver.get("https://tcb.vn.ua/");
        }
        return driver;
    }

    protected boolean isPresentAndDisplayed(WebElement element) {
        try {
            element.isDisplayed();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

}
