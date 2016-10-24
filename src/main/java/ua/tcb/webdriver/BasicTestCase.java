package ua.tcb.webdriver;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import ua.tcb.data.UserData;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.NoSuchFileException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * Created by Maksym_Mazurkevych on 2/24/2016.
 */
public class BasicTestCase {

    private static boolean isBrowserOpened = false;
    public static WebDriver driver = null;
    public static String url;
    protected boolean isFound = false;
    protected static String nameToFind;
    public static Properties config = new Properties();


    public UserData admin = new UserData("maksim.mazurkevych@gmail.com", "gtnhjdbx2014");

    @BeforeSuite
    public static String initBaseUrl()  throws IOException  {
        config.load(getResource("config.properties"));
        url = config.getProperty("baseUrl");
        return url;
    }

    @BeforeSuite
    public static String initName() throws IOException {
        config.load(getResource("config.properties"));
        nameToFind = config.getProperty("name");
        return nameToFind;
    }

    public static InputStream getResource(String properties) throws NoSuchFileException
    {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        InputStream is = loader.getResourceAsStream(properties);

        if(is == null)
        {
            throw new NoSuchFileException("Resource file not found. Note that the current directory is the source folder!");
        }

        return is;
    }

    @BeforeTest
    public static void setupClass() {
        ChromeDriverManager.getInstance().setup();
    }

    @BeforeClass
    public static WebDriver setUp() throws IOException {
        if (!isBrowserOpened) {

            driver = new ChromeDriver();
            System.out.println("Opening Chrome");
            isBrowserOpened = true;
            driver.manage().window().setSize(new Dimension(1024, 1024));

            driver.manage().timeouts().pageLoadTimeout(70, TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
            driver.manage().timeouts().setScriptTimeout(15, TimeUnit.SECONDS);
            driver.manage().window().maximize();
        }
        return driver;
    }

    @AfterTest(alwaysRun = true)
    public void tearDown() throws Exception {
        driver.quit();
        isBrowserOpened = false;
    }

    public static void captureScreenShot(String fileName) throws IOException {
        try {
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir") + File.separator + "target" + File.separator + "surefire-reports" + File.separator + "html" + File.separator + fileName + ".jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
