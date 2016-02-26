package ua.tcb.webdriver;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import ua.tcb.data.UserData;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Created by Maksym_Mazurkevych on 2/24/2016.
 */
public class BasicTestCase {

    public static final String BROWSER_FF = "firefox";
    private static boolean isBrowserOpened = false;
    public static FirefoxDriver driver = null;

    protected static String baseUrl =  "https://tcb.vn.ua";
    protected static String nameToFind = "Никитюк";
//    private static boolean isInitialized = false;
//    public static Properties CONFIG = null;

    public UserData admin = new UserData("maksim.mazurkevych@gmail.com", "gtnhjdbx2014");

//    @BeforeSuite
//    public static String initializeBaseUrl() {
//
//        if (!isInitialized) {
//            CONFIG = new Properties();
//            FileInputStream ip;
//            try {
//                ip = new FileInputStream(System.getProperty("user.dir") + "//src//test//resources//config.properties");
//                CONFIG.load(ip);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            isInitialized = true;
//            nameToFind = CONFIG.getProperty("nameToFind");
//            System.out.println(nameToFind);
//        }
//
//        return nameToFind;
//    }

    @AfterTest(alwaysRun = true)
    public void tearDown() throws Exception {
        driver.quit();
        isBrowserOpened = false;
    }

    @BeforeClass
    public static WebDriver setUp() throws IOException {
        if (!isBrowserOpened) {

//            FirefoxProfile profile = new FirefoxProfile();
//            profile.addExtension(new File(System.getProperty("user.dir")
//                    + "//src//main//resources//firebug-2.0.14-fx.xpi"));
//            profile.addExtension(new File(System.getProperty("user.dir")
//                    + "//src//main//resources//firepath-0.9.7.1-fx.xpi"));
            driver = new FirefoxDriver();
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

    protected static void captureScreenShot(String fileName) throws IOException {
        try {
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir") + File.separator + "target" + File.separator + "surefire-reports" + File.separator + "html" + File.separator + fileName + ".jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
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
